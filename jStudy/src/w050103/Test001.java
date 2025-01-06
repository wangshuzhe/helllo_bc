package w050103;

public class Test001 {
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        for (int i = 5; i < 18; i++) {
            stack.push(i);
            if (i == 9) {
                stack.pop();
            }
        }
        int[] array = stack.toArray();
        for (int i : array) {
            System.out.println(i);
        }
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
    }
}
