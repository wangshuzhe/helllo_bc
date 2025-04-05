package w050404;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 上传文件，上传一个 3.5m的图片需要 7 秒中的时间
 */
public class ReadFile {
    public static void main(String[] args) throws IOException {
        String file = "/Raycast.dmg";
        String filePath= "/Users/wangshuzhe/Downloads" + file;
        String uploadPathStr = "/Users/wangshuzhe/Downloads/upload" + file;
        Path path = Paths.get(filePath);
        Path uploadPath = Paths.get(uploadPathStr);
        /**
         * 一个 10.4MB大小的 PDF 文件，使用第一种方法耗时 21000 ms，第二种方法耗时 18ms.
         * 读取 89,4MB 耗时 92ms
         */
//        fileRead(path, uploadPath);
        bufferRead(path, uploadPath);
    }

    public static void bufferRead(Path path, Path uploadPath) throws IOException {
        InputStream inputStream = new BufferedInputStream(Files.newInputStream(path));
        OutputStream outputStream = new BufferedOutputStream(Files.newOutputStream(uploadPath));
        long time = System.currentTimeMillis();
        byte[] buffer = new byte[1024];
        while (inputStream.read(buffer) != -1)
        {
            outputStream.write(buffer);
        }
        inputStream.close();
        outputStream.close();
        long end  = System.currentTimeMillis();
        System.out.println("time: " + (end - time));
    }

    public static void fileRead(Path path, Path uploadPath) throws IOException {
        FileInputStream inputStream = new FileInputStream(String.valueOf(path));
        FileOutputStream outputStream = new FileOutputStream(String.valueOf(uploadPath));
        long start = System.currentTimeMillis();
        int c;
        while ((c = inputStream.read()) != -1) {
            outputStream.write(c);
        }
        inputStream.close();
        outputStream.close();
        long end = System.currentTimeMillis();
        System.out.println("time: " + (end - start));
    }
}
