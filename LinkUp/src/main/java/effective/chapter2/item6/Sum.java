package effective.chapter2.item6;

/**
 * 程序慢的吓人！你能发现对象的创建吗
 */
// Hideously slow program! Can you spot the object creation? (Page 24)
public class Sum {
    private static long sum() {
        long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int numSets = Integer.parseInt(args[0]);
        long x = 0;
        for (int i = 0; i < numSets; i++) {
            long start = System.nanoTime();
            x += sum();
            long end = System.nanoTime();
            System.out.println("time: " + ((end - start) / (1_000_000.)) + " ms.");
        }
        if (x == 42) {
            System.out.println();
        }
    }
}
