package w050119;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SocketTest {
    public static void main(String[] args) {
        try {
            //套接字,创建链接的套接字
            Socket s = new Socket("time-a.nist.gov",13);
            //创建未连接的套接字
            Socket s1 = new Socket();
            Scanner scanner = new Scanner(s.getInputStream(), "UTF-8");
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
