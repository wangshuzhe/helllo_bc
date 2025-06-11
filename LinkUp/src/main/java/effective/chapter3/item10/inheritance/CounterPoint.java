package effective.chapter3.item10.inheritance;

import effective.chapter3.item10.Point;

import java.util.concurrent.atomic.AtomicInteger;

// Trivial subclass of Point - doesn't add a value component (Page 43)

/**
 * Point 的平凡子类，不添加值组件
 */
public class CounterPoint extends Point {
    private static final AtomicInteger counter =
            new AtomicInteger();
    public CounterPoint(int x, int y) {
        super(x, y);
        counter.incrementAndGet();
    }

    public static int numberCreated() {
        return counter.get();
    }
}
