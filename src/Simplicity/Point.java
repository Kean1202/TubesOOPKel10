package Simplicity;

public class Point {
    private int x;
    private int y;

    public Point() {
        x = 0;
        y = 0;
    }
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public double distance(Point otherPoint) {
        double dx = otherPoint.getX() - this.getX();
        double dy = otherPoint.getY() - this.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }
}
