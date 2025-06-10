package effective.chapter2.item9.trywithresources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TopLineWithDefault {
    // try-with-resources with a catch clause  (Page 36)
    //try-with-resources 带有一个catch 子局
    static String firstLineOfFile(String path, String defaultVal)throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        } catch (IOException e) {
            return defaultVal;
        }
    }

    public static void main(String[] args) {
        String path = "";
        try {
            System.out.println(firstLineOfFile(path, "defaultVal"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
