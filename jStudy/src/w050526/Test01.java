package w050526;

public class Test01 {
    public static void main(String[] args) {
        byte a = (byte) ((2 * 2 * 2 * 2 * 2 * 2 * 2) - 1);
        int b = 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2;
        System.out.println(b);
        System.out.println(a);
        //1 byte = 8 bit
        String byteStr = "00000000";
        String maxByteStr = "11111111";
        //1 int = 4 byte
        String maxIntStr = "11111111 11111111 11111111 11111111";
    }
}
