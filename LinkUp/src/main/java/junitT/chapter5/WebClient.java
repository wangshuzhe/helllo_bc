package junitT.chapter5;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class WebClient {
    public String getContent(URL url) {
        StringBuffer content = new StringBuffer();
        try {
            URLConnection connection = url.openConnection();
            connection.setDoInput(true);
            InputStream inputStream = connection.getInputStream();
            byte[] buffer = new byte[2048];
            int count;
            while (-1 != (count = inputStream.read(buffer))) {
                content.append(new String(buffer, 0, count));
            }
        } catch (IOException e) {
            return null;
        }
        return content.toString();
    }
}
