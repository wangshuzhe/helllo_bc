package w050119;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ThreadedEchoServer {
    public static void main(String[] args) {
        try (ServerSocket s = new ServerSocket(8189)) {
            int i = 1;
            while (true) {
                Socket incoming = s.accept();
                System.out.println("Spawing:" + i);
                Runnable r = new ThreadedEchoHandler(incoming);
                Thread thread = new Thread(r);
                thread.start();
                i++;
            }
        } catch (IOException e) {

        }
    }

}
class ThreadedEchoHandler implements Runnable{
    private Socket incoming;
    public ThreadedEchoHandler(Socket incoming) {
        this.incoming = incoming;
    }
    @Override
    public void run() {
        try(InputStream inStream = incoming.getInputStream();
            OutputStream outputStream = incoming.getOutputStream();
        ) {
            Scanner scanner = new Scanner(inStream, "UTF-8");
            PrintWriter out = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true);
            out.println("Hello! Enter BYE to exit");
            boolean done = false;
            while (!done && scanner.hasNextLine()) {
                String line = scanner.nextLine();
                out.println("Echo:" + line);
                if (line.trim().equals("BYE")) {
                    done = true;
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
