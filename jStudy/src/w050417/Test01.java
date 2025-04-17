package w050417;

public class Test01 {
    //currentTimeMillis() 获取的是毫秒值，  一分钟有60000毫秒 。  当前方法是计算当前时间的分钟数。
    private static volatile long minTime = System.currentTimeMillis()/ 60000;
    /**
     * 注意事项
     *
     * InheritableThreadLocal extends ThreadLocal
     * 主要用途: 子线程能够继承父线程中变量的值
     * 值的拷贝：子线程继承的是父线程中 InheritableThreadLocal 变量的值的副本，而不是引用。这意味着子线程对该值的修改不会影响父线程中的值，反之亦然。
     * 线程池场景问题：在使用线程池时，由于线程池中的线程是复用的，子线程可能不会每次都继承父线程的 InheritableThreadLocal 值。在这种情况下，可以考虑使用第三方库，如 TransmittableThreadLocal 来解决这个问题。
     *
     * 原理:
     * ThreadLocal 提供了线程局部变量，每个使用该变量的线程都有自己独立的副本，线程之间对该变量的操作互不影响。
     * InheritableThreadLocal 的扩展：InheritableThreadLocal 在此基础上做了扩展，当创建子线程时，子线程会继承父线程中 InheritableThreadLocal 变量的初始值。这是因为在 Thread 类的构造函数中，会检查父线程是否有 InheritableThreadLocal 变量，如果有，就会将这些变量的值复制到子线程中。
     */
    private static InheritableThreadLocal<Long> contextThread = new InheritableThreadLocal<>();
    public static void main(String[] args) {
        System.out.println(minTime);
        for (int i =0; i <10; i++){
            minTime = System.currentTimeMillis()/ 60000;
            System.out.println(minTime);
        }
        contextThread.set(2L);
        System.out.println("main 线程获取 TreadLocal=" + contextThread.get());
        Thread thread = new Thread(() -> {
            System.out.println("子线程获取TreadLocal=" + contextThread.get());
            contextThread.set(1L);
            System.out.println("子线程获取TreadLocal=" + contextThread.get());
        });
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("main 线程获取 TreadLocal=" + contextThread.get());
    }
}
