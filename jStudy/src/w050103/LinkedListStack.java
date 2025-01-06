package w050103;

import config.ListNode;

public class LinkedListStack {
    private ListNode stackPeek;
    private int sizeStk;

    /**
     * 构造方法
     */
     public  LinkedListStack(){
         this.stackPeek = null;
     }

    /**
     * 入栈
     */
    public void push(int num) {
        ListNode node = new ListNode(num);
        node.setNext(stackPeek);
        stackPeek = node;
        sizeStk++;
    }

    /*
    出栈
     */
    public void pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        stackPeek = stackPeek.getNext();
        sizeStk--;
    }

    /**
     * 访问栈顶元素
     */
    public int peek(){
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        return stackPeek.getVal();
    }

    /**
     * 判断栈是否为空
     */
    public boolean isEmpty() {
        if (stackPeek == null) {
            return true;
        }
        return false;
    }

    /**
     * 将List 转换为数组 并返回
     */
    public int[] toArray() {
        int[] arr = new int[sizeStk];
        ListNode node = stackPeek;
        int i = 0;
        while (null != node) {
            arr[i] = node.getVal();
            i++;
            node = node.getNext();
        }
        return arr;
    }

}
