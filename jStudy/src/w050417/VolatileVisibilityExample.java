package w050417;

/**
 * 学习 volatile 修饰符
 */
public class VolatileVisibilityExample {
    private static volatile boolean flag = false;
    private static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()-> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            flag = true;
            count = 11;
        });
        Thread thread1 = new Thread(()-> {
            while (!flag){
                System.out.println("count:" + count);
                count++;
            }
            System.out.println("检测到 flag设置为 true 了!");
            System.out.println("count=" + count);
        });
        thread1.start();
        thread.start();

        thread1.join();
        thread.join();

    }
}
