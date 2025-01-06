package w050104;

import config.ListNode;

/**
 * 实现链表逆着来更方便一点
 * 现在  a -> b -> c  以下代码是吧 a 当做 in ，c 当做 out
 * 做删除操作的时候会麻烦一点。
 *
 * @TODO  后面优化一下 把   a当做out  c 当做 in
 */
public class LinkedListQueue {
    private ListNode out;
    private ListNode in;
    int queSize;
    public LinkedListQueue() {
        this.out = null;
        this.in = null;
    }
    public int size() {
        return queSize;
    }
    public boolean isEmpty(){
        return size() == 0;
    }

    /**
     * 入栈
     */
    public void push(int num) {
        ListNode node = new ListNode();
        node.setVal(num);
        node.setNext(in);
        in = node;
        queSize++;
        if (null == out) {
            out = node;
        }
    }

    /**
     * 出栈
     */
    public void pop() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        ListNode head = in;
        while (head.getNext().getNext() != null) {
            out = head.getNext();
            head = head.getNext();
        }
        out.setNext(null);
        queSize--;

    }

    /**
     * 访问队首元素
     */
    public int peek() {
        return in.getVal();
    }

    /**
     * 将链表转换为Array并返回
     */
    public int[] toArray(){
        ListNode node = in;
        int[] arr = new int[queSize];
        int count = 0;
        while (node != null) {
            arr[count++] = node.getVal();
            node = node.getNext();
        }
        return arr;
    }

}
