package w050119;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class URLConnectionTest {
    public static void main(String[] args) {
        try {
            String urlName = "http://baidu.com";
            URL url = new URL(urlName);
            // 返回一个 URLConnection 对象， 该对象负责管理与资源之间的连接
            URLConnection connection = url.openConnection();
            connection.connect();
            Map<String, List<String>> header = connection.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : header.entrySet()) {
                String key = entry.getKey();
                for (String value : entry.getValue())
                    System.out.println("key: " + value);

            }
            System.out.println("----------");
            System.out.println("getContentType: " + connection.getContentType());
            System.out.println("getContentLength: " + connection.getContentLength());
            System.out.println("getContentEncoding: " + connection.getContentEncoding());
            System.out.println("getData: " + connection.getDate());
            System.out.println("getExpiration: " + connection.getExpiration());
            System.out.println("getLastModifed: " + connection.getLastModified());
            System.out.println("-----------");
            String encoding = connection.getContentEncoding();
            if (encoding == null)
                encoding = "UTF-8";
            try (Scanner in = new Scanner(connection.getInputStream(), encoding)) {
                for (int n = 1; in.hasNextLine() && n <= 10; n++) {
                    System.out.println(in.nextLine());
                    if (in.hasNextLine())
                        System.out.println(". . .");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
