package w050105;

public class Test0105 {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(10);
        for (int i = 0; i < 10; i++) {
            queue.push(i);
        }
        System.out.println(queue.size());
        System.out.println("---------");
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            System.out.println(queue.peek());
            queue.pop();
        }
    }
}
