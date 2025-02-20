public class ysfTest {
    public static void main(String[] args) {
        int x = 0b010110;
        int y = 0b001000;
        System.out.println(0b011110);
        ysf(x,y);
    }

    public static void ysf(int x, int y) {
        int z = x | y;
        System.out.println(z);
    }
}
