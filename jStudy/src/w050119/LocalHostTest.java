package w050119;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class LocalHostTest {
    public static void main(String[] args) {
        try {
            //获取域名对应的所有IP地址
            InetAddress[] allByName = InetAddress.getAllByName("github.com");
            for (InetAddress name : allByName) {
                System.out.println(name);
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
