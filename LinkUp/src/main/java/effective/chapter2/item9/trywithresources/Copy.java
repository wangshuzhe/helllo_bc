package effective.chapter2.item9.trywithresources;

import java.io.*;

public class Copy {
    private static final int BUFFER_SIZE = 8* 1024;

    //try-with-resources on multiple resources - page 35

    /**
     * 在 try-with-resources中声明对象，如果对象抛出异常首先会隐式自动关闭对象（关闭逻辑由 Java 编译器生成的字节码隐式完成,不需要手动编写 finally 块处理），然后抛出异常。
     * @param src
     * @param dst
     * @throws IOException
     */
    static void copy(String src, String dst) throws IOException {
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0) {
                out.write(buf, 0, n);
            }
        }
    }

    public static void main(String[] args) {
        String src = "";
        String dst = "";
        try {
            copy(src, dst);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
