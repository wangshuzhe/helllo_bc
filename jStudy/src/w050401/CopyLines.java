package w050401;

import java.io.*;

/**
 * 字符流，一次读取一行，写入一行
 *
 */
public class CopyLines {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;
        //使用 I/O缓冲, 缓冲字符流
        bufferedReader = new BufferedReader(new FileReader("/Users/wangshuzhe/project/ym_project/project_szw/jStudy/src/w050401/123.txt"));
        printWriter = new PrintWriter(new File("/Users/wangshuzhe/project/ym_project/project_szw/jStudy/src/w050401/456.txt"));
        //缓冲字节流
//        bufferedReader = new BufferedInputStream();
//        printWriter = new BufferedOutputStream();
        String s = null;
        while ((s = bufferedReader.readLine()) != null) {
            //加入 ln 换行，不加 ln 在当前行后追加
            printWriter.println(s);
        }
        if (bufferedReader != null) {
            bufferedReader.close();
        }
        if (printWriter != null) {
            printWriter.close();
        }
    }
}
