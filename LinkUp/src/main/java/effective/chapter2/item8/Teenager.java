package effective.chapter2.item8;

//Ill-behaved client of resource with cleaner safety-net (Page 33)

/**
 * 行为不端的资源客户与更清洁的安全网（第33页）
 */
public class Teenager {
    public static void main(String[] args) {
        new Room(99);
        System.out.println("Peace out");
        // Uncomment next line and retest behavior, but note that you MUST NOT depend on this behavior!
        //取消下一行的注释并重新测试行为，但注意你不能依赖于这个行为！
        System.gc();
    }
}
