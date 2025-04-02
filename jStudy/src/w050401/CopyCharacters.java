package w050401;

import java.io.*;

/**
 * 使用字节流的字符流
 */
public class CopyCharacters {
    public static void main(String[] args) throws IOException {
        FileReader inputStream = null;
        FileWriter outputStream = null;
        try {
            inputStream = new FileReader("/Users/wangshuzhe/project/ym_project/project_szw/jStudy/src/w050401/123.txt");
            outputStream = new FileWriter("/Users/wangshuzhe/project/ym_project/project_szw/jStudy/src/w050401/456.txt");
            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
