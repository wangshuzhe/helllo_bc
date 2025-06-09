package effective.chapter2.item7;

import java.util.Arrays;

// Can you spot the "memory leak"?  (Pages 26-27)

/**
 * 你能发现内存泄露吗
 */
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    private void ensureCapcity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
    public void push(Object object) {
        ensureCapcity();
        elements[size++] = object;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return elements[--size];
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        for (String arg : args) {
            stack.push(arg);
        }
        while (true) {
            System.err.println(stack.pop());
        }
    }

}
