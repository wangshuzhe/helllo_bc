package effective.chapter2.item9.tryfinally;

import javax.imageio.IIOException;
import java.io.*;

public class Copy {
    private static final int BUFFER_SIZE = 1024 * 8;

    //try-finally is ugly when used with more than one resource! (page34)
    static void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[BUFFER_SIZE];
                int n;
                while ((n = in.read(buf)) >= 0) {
                    out.write(buf, 0, n);
                }
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }

    public static void main(String[] args) {
        String src = "/Users/wangshuzhe/Downloads/发票/a.txt";
        String dst = "";
//        String dst = "/Users/wangshuzhe/Downloads/发票/b.txt";
        try {
            copy(src, dst);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
