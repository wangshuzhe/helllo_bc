package effective.chapter4.item16;

/**
 * 通过f昂稳方法和 mutators 封装数据 Page78
 */
// Encapsulation of data by accessor methods and mutators  (Page 78)
public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
