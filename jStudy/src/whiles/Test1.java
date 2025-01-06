package whiles;

import java.util.Stack;

public class Test1 {
    public static void main(String[] args) {
//        System.out.println(sum(10, 0));
        System.out.println(forLoopRecur(10));
    }


    /**
     * 尾递归求 1 -> n 的和
     */
    public static int sum(int n, int sum) {
        if (n == 0) {
            return sum;
        }
        return sum(n - 1, sum + n);
    }

    public static int forLoopRecur(int n) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = n; i > 0; i--) {
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    /**
     * O(1)
     */
    static int constant(int n) {
        int count = 0;
        int size = 1000000;
        for (int i = 0; i < size; i++) {
            count++;
        }
        return count;
    }
}
