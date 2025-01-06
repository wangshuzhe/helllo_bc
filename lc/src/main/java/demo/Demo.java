package demo;

public class Demo {
    public static void main(String[] args) {
        int i = 2147483647;
        int m = 26;
        int c = 0;
        while (i > m) {
            i = i / m;
            c ++;
            System.out.println(i);
        }
    }

}
