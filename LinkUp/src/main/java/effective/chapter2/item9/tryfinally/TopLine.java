package effective.chapter2.item9.tryfinally;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TopLine {
    // try-finally - No longer the best way to close resources! (page 34)
    static String firstLineOfFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            br.close();
        }
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
