package w050105;

/**
 * 队首是出的，队尾是入的
 */
public class ArrayQueue {
    private int [] nums;
    private int front;
    private int queSize;

    public ArrayQueue(int size) {
        nums = new int[size];
        front = 0;
        queSize = 0;
    }

    /**
     * 获取队列容量
     *
     * @return
     */
    public int capacity() {
        return nums.length;
    }

    /**
     * 获取队列的元素个数
     * @return
     */
    public int size() {
        return queSize;
    }

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    private int index(int i) {
        return (i + capacity()) % capacity();
    }

    public void push(int num) {
        if (size() == capacity()) {
            System.out.println("队列已满!");
            return;
        }
        int rear = (front + queSize) % capacity();
        nums[rear] = num;
        queSize++;
    }

    /**
     * 队首入队
     * @param num
     */
    public void pushFirst(int num) {
        if (queSize == capacity()) {
            System.out.println("双向队列已满!");
            return;
        }
        front = index(front - 1);
        nums[front] = num;
        queSize++;
    }

    /**
     * 队尾入队
     */
    public void pushLast(int num) {
        if (queSize == capacity()) {
            System.out.println("双向队列已满!");
            return;
        }
        int rear = index(front + queSize);
        nums[rear] = num;
        queSize++;
    }

    /**
     * 队首出队
     * @return
     */
    public int popFirst() {
        int num = peekFirst();
        front = index(front + 1);
        queSize--;
        return num;
    }

    /**
     * 队尾出队
     */
    public int popLast() {
        int num = peekLast();
        queSize--;
        return num;
    }

    /**
     * 访问队首元素
     */
    public int peekFirst() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return nums[front];
    }
    /**
     * 访问队尾元素
     */
    public int peekLast() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int rear = index(front + queSize - 1);
        return nums[rear];
    }

    /**
     * 出列
     */
    public int pop() {
        int num = peek();
        front = (front + 1) % capacity();
        queSize--;
        return num;
    }

    /**
     * 访问队首元素
     */
    public int peek() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return nums[front];
    }

    /**
     * 返回数组
     */
    public int[] toArray() {
        int[] res = new int[queSize];
        for (int i = 0, j = front; i < queSize; i++,j++) {
            res[i] = nums[j % capacity()];
        }
        return res;
    }

}
