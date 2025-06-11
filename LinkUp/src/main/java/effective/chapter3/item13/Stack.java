package effective.chapter3.item13;

import java.util.Arrays;

public class Stack implements Cloneable {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    private void ensureCapcity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
    public void push(Object o) {
        ensureCapcity();
        elements[size++] = o;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object o = elements[--size];
        elements[size] = null;
        return o;
    }

    /**
     * 引用可变状态的类的克隆方法
     * @return
     */
    @Override
    public Stack clone() {
        try {
            Stack stack = (Stack) super.clone();
            stack.elements = elements.clone();
            return stack;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        Stack stack = new  Stack();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        Stack stack1 = stack.clone();
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println("--------");
        while (!stack1.isEmpty()) {
            System.out.println(stack1.pop());
        }
    }
}
