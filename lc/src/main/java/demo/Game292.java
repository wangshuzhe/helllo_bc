package demo;

public class Game292 {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(canWinNim(n));
    }
    public static boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
