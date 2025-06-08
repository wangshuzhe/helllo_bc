package effective.chapter2.item6;

import java.util.regex.Pattern;

/**
 * 罗马数字.java
 * 释放昂贵的对象以获得更好的性能
 * Resuing expensive object for improved performance (Pages 22 and 23)
 */
public class RomanNumerals {

    // Performance can be greatly(极大地) improved! (Page 22)
    static boolean isRomanNumeralSlow(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
                + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }
    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})"
                + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static boolean isRomanNumeralFast(String s) {
        return ROMAN.matcher(s).matches();
    }

    public static void main(String[] args) {
        int numSets = Integer.parseInt(args[0]);
        int numReps = Integer.parseInt(args[1]);
        boolean b = false;
        for (int i = 0; i < numSets; i++) {
            long start = System.nanoTime();
            for (int j = 0; j < numReps; j++) {
                //慢
//                b ^= isRomanNumeralSlow("MCMLXXVI");
                //快
                b^= isRomanNumeralFast("MCMLXXVI");
            }
            long end = System.nanoTime();
            System.out.println("time: " + ((end - start) / (1_000. * numReps)) + " μs.");
        }
        if (!b) {
            System.out.println();
        }
    }
}
