package demo;

import config.MyStack;

public class Stack225 {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        for (int i = 1; i <= 2; i++) {
            stack.push(i);
        }
        for (int i = 1; i <= 2; i++) {
            System.out.println(stack.top());

        }

        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}
