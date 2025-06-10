package effective.chapter2.item9.trywithresources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TopLine {
    //最好的关闭资源的方式
    static String firstLineOfFile(String path) throws IOException {
        String str = null;
        try (BufferedReader bu = new BufferedReader(new FileReader(path))) {
            str = bu.readLine();
        }
        return str;
    }
    public static void main(String[] args) {
        String path = "/Users/wangshuzhe/Downloads/发票/a.txt";
        try {
            System.out.println(firstLineOfFile(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
