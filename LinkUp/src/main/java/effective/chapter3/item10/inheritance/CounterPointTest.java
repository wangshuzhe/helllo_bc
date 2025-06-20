package effective.chapter3.item10.inheritance;

import effective.chapter3.item10.Point;

import java.util.Set;

public class CounterPointTest {
    // Initialize unitCircle to contain all Points on the unit circle  (Page 43)
    private static final Set<Point> unitCircle = Set.of(
            new Point(1,0), new Point(0, 1),
            new Point(-1,0), new Point(0,-1));

    public static boolean onUnitCircle(Point point) {
        return unitCircle.contains(point);
    }

    public static void main(String[] args) {
        Point p1 = new Point(1, 0);
        Point p2 = new CounterPoint(1, 0);
        System.out.println(onUnitCircle(p1));
        // Should print true, but doesn't if Point uses getClass-based equals
        System.out.println(onUnitCircle(p2));
    }
}
