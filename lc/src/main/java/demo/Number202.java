package demo;

public class Number202 {
    public static void main(String[] args) {
        int x =  19;
        System.out.println(isHappy(x));
    }
    public static boolean isHappy(int n) {
        int slow = n, fast = squareSum(n);
        while (slow != fast) {
            slow = squareSum(slow);
            fast = squareSum(fast);
        }
        return slow == 1;
    }
    public static int squareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
