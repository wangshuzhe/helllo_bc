package w050401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) {
        try(Socket socket = new Socket("10.10.15.31", 12345);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()
            ))) {
            out.println("Hello, world!");
            out.print("你是");
            String response = in.readLine();
            System.out.println("服务器响应: " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
