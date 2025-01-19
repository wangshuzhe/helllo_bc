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
    //按钮
    private JButton interruptibleButton;
    private JButton blockingButton;
    private JButton cancelButton;
    //文本区域
    private JTextArea messages;
    private TestServer server;
    private Thread connectThread;

    //构造方法
    public InterruptibleSocketFrame() throws HeadlessException{
        //创建面板
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
                } finally {
                    System.out.println("1");
                }
/*
                耻辱，把启动线程的语句放在创建线程里了，我说怎么一直没启动 以此作为提醒
                connectThread.start();
*/
            });
            connectThread.start();
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
     * Connects to the test server, using interruptible I/O. 不好使
     */
    public void connectInterruptibly() throws IOException {
        messages.append("Interruptible:\n");
        //创建套接字 通道
        try(SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8189))){
            //创建扫描仪
            in = new Scanner(channel, "UTF-8");
            //校验线程是否被中断, 当前方法不会清除中断状态
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
                blockingButton.setEnabled(true);
            });
        }
    }
    public void connectBlocking() throws IOException {
        messages.append("Blocking:\n");
        try (Socket sock = new Socket("127.0.0.1", 8189)) {
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
                messages.append("\nTestServer.run:" + e);
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
                try {
                    OutputStream outputStream = incoming.getOutputStream();
                    PrintWriter out = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true);
                    while(counter < 100) {
                        counter++;
                        if (counter <= 10)
                            out.println(counter);
                        Thread.sleep(100);
                    }
                }finally {
                    incoming.close();
                    messages.append("closing server\n");
                }
            }
            catch (Exception e) {
                messages.append("\nTestServerHandler.run:" + e);
                throw new RuntimeException(e);
            }
        }
    }
}
