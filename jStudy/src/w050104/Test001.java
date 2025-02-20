package w050104;

import java.util.Arrays;

public class Test001 {
    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        for (int i = 0; i < 10; i++) {
            queue.push(i);
        }
        System.out.println(queue.size());
        queue.pop();
        System.out.println(queue.peek());
        System.out.println(Arrays.toString(queue.toArray()));
    }
}
