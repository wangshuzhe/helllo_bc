package w050119;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * 使用 swing 创建一个窗口，实现简单的网络通信测试程序
 */
public class InterruptibleSocketTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new InterruptibleSocketFrame();
            frame.setTitle("InterruptibleSocketTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
class InterruptibleSocketFrame extends JFrame {
    private Scanner in;
    private JButton interruptibleButton;
    private JButton blockingButton;
    private JButton cancelButton;
    private JTextArea messages;
    private TestServer server;
    private Thread connectThread;

    public InterruptibleSocketFrame() throws HeadlessException{
        JPanel northPanel = new JPanel();
        add(northPanel, BorderLayout.NORTH);
        final int TEST_ROWS = 20;
        final int TEST_COLUMNS = 60;
        messages = new JTextArea(TEST_ROWS, TEST_COLUMNS);
        add(new JScrollPane(messages));
        interruptibleButton = new JButton("Interruptible");
        blockingButton = new JButton("Blocking");
        northPanel.add(interruptibleButton);
        northPanel.add(blockingButton);
        interruptibleButton.addActionListener(event -> {
            interruptibleButton.setEnabled(false);
            blockingButton.setEnabled(false);
            cancelButton.setEnabled(true);
            connectThread = new Thread(() ->
            {
                try {
                    connectInterruptibly();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                connectThread.start();
            });
        });
        blockingButton.addActionListener(event -> {
            interruptibleButton.setEnabled(false);
            blockingButton.setEnabled(false);
            cancelButton.setEnabled(true);
            connectThread = new Thread(() ->{
                try {
                    connectBlocking();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            connectThread.start();
        });
        cancelButton = new JButton("Cancel");
        cancelButton.setEnabled(false);
        northPanel.add(cancelButton);
        cancelButton.addActionListener(event -> {
            connectThread.interrupt();
            cancelButton.setEnabled(false);
        });
        server = new TestServer();
        new Thread(server).start();
        pack();
    }
    /**
     * Connects to the test server, using interruptible I/O.
     */
    public void connectInterruptibly() throws IOException {
        messages.append("Interruptible:\n");
        try(SocketChannel channel = SocketChannel.open(new InetSocketAddress("localhost", 8189))){
            in = new Scanner(channel, "UTF-8");
            while (!Thread.currentThread().isInterrupted())
            {
                messages.append("Reading ");
                if (in.hasNextLine()){
                    String line = in.nextLine();
                    messages.append(line);
                    messages.append("\n");
                }
            }
        } finally {
            EventQueue.invokeLater(() ->
            {
                messages.append("Channel closed\n");
                interruptibleButton.setEnabled(true);
            });
        }
    }
    public void connectBlocking() throws IOException {
        messages.append("Blocking:\n");
        try (Socket sock = new Socket("localhost", 8189)) {
            in = new Scanner(sock.getInputStream(), "UTF-8");
            while (!Thread.currentThread().isInterrupted()) {
                messages.append("Reading ");
                if (in.hasNextLine()){
                    String line = in.nextLine();
                    messages.append(line);
                    messages.append("\n");
                }
            }
        } finally {
            EventQueue.invokeLater(() -> {
                messages.append("Socket closed\n");
                interruptibleButton.setEnabled(true);
                blockingButton.setEnabled(true);
            });
        }
    }
}
class TestServer  implements Runnable{


    @Override
    public void run() {
        try (ServerSocket s = new ServerSocket(8189)) {
            while (true) {
                Socket incoming = s.accept();
                Runnable runnable = new TestServerHandler(incoming);
                Thread thread = new Thread(runnable);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class TestServerHandler implements Runnable {

    private Socket incoming;
    private int counter;
    public TestServerHandler(Socket i) {
        incoming = i;
    }
    @Override
    public void run() {
        try {
            OutputStream outputStream = incoming.getOutputStream();
            PrintWriter out = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true);
            while(counter < 1000) {
                counter++;
                if (counter <= 10)
                    out.println(counter);
                Thread.sleep(100);
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                incoming.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
