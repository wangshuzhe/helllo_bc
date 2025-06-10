package effective.chapter3.item10.composition;

// Adds a value component without violating the equals contract (page 44)

import effective.chapter3.item10.Color;
import effective.chapter3.item10.Point;

/**
 * 在不违反equals契约的情况下添加一个 value 组件
 *
 */
public class ColorPoint {
    private final Point point;
    private final Color color;

    public ColorPoint(Point point, Color color) {
        this.point = point;
        this.color = color;
    }

    /**
     * Returns the point-view of this color point.
     * 返回该颜色的视角
     */
    public Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPoint)) {
            return false;
        }
        ColorPoint c = (ColorPoint) o;
        return c.point == point && c.color == color;
    }

    @Override
    public int hashCode() {
        return 31 * point.hashCode() + color.hashCode();
    }
}
