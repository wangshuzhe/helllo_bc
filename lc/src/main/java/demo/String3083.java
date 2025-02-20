package demo;

public class String3083 {
    public static void main(String[] args) {
        String s = "";
        /**
         *
         3 的二进制数    0011
         8 的二进制数    1000
         二进制进行或运算 1011
         结果为        1*2^3+0*2^2+1*2^1+1*2^1
                    11
         */
        System.out.println(isSubstringPresent("lpetcode"));


    }
    public static boolean isSubstringPresent(String s) {
        int[] h = new int[26];
        for (int i = 0; i + 1 < s.length(); i++) {
            int x = s.charAt(i) - 'a';
            int y = s.charAt(i + 1) - 'a';
            h[x] |= 1 << y;
            if ((h[y] >> x & 1) != 0) {
                return true;
            }
        }
        return false;
    }
}

