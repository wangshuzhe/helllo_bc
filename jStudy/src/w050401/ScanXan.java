package w050401;

import w050330.Pizza;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ScanXan {
    public static void main(String[] args) throws IOException {
        Scanner s = null;
        s = new Scanner(new BufferedReader(new FileReader("/Users/wangshuzhe/project/ym_project/project_szw/jStudy/src/w050401/123.txt")));
        while (s.hasNext()) {
            System.out.println(s.next());
        }
        if (s != null) {
            s.close();
        }
    }
}
