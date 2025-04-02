package w050401;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/*
字节流 最小单位。
 */
public class TestIO {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            System.out.println("当前工作目录:" + System.getProperty("user.dir"));
            //以下是绝对路径
            inputStream = new FileInputStream("/Users/wangshuzhe/project/ym_project/project_szw/jStudy/src/w050401/123.txt");
            outputStream = new FileOutputStream("/Users/wangshuzhe/project/ym_project/project_szw/jStudy/src/w050401/456.txt");
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
