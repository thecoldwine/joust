package org.destrier.joust;

/**
 * Created by Mikhail Aksenov.
 * 2017-06-21
 * org.destrier.joust
 */
public class Point2d implements Point {
    private final double x;
    private final double y;

    public Point2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point2d point2d = (Point2d) o;

        if (Double.compare(point2d.x, x) != 0) return false;
        return Double.compare(point2d.y, y) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public double[] getCoordinates() {
        return new double[] { x, y };
    }
}
