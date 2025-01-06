package config;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 后入先出
 */
public class MyStack {
    private Queue<Integer> queue;
    public MyStack() {
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.add(x);
        if (!empty()) {
            int size = queue.size() - 1;
            for (int i = 0; i < size; i++) {
                Integer peek = queue.peek();
                queue.add(peek);
                queue.remove();
            }
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
