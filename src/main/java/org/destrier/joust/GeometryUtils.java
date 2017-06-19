package org.destrier.joust;

/**
 * Created by Mikhail Aksenov.
 * 2017-06-16
 * org.destrier.joust
 */
public class GeometryUtils {
    /**
     * Calculates Euclidean distance between two points
     *
     * @param a first point
     * @param b second point
     * @return Euclidean distance
     */
    public static double euclideanDistance(Point a, Point b) {
        if (a == null || b == null)
            throw new IllegalArgumentException("One of arguments is null.");

        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }

    /**
     * Calculates perpendicular distance between point t and the line defined by points p1 and p2.
     *
     * @param t  target point
     * @param p1 first point of line
     * @param p2 second point of line
     * @return perpendicular distance between point and line
     */
    public static double perpendicularDistance(Point t, Point p1, Point p2) {
        if (p1 == null || p2 == null || p1.equals(p2))
            throw new IllegalArgumentException("One of line points is null or the same.");

        if (t == null)
            throw new IllegalArgumentException("Target point is null");

        double y1 = p1.getY();
        double y2 = p2.getY();
        double x1 = p1.getX();
        double x2 = p2.getX();
        double x0 = t.getX();
        double y0 = t.getY();

        return Math.abs((y2 - y1) * x0 - (x2 - x1) * y0 + x2 * y1 - y2 * x1) / euclideanDistance(p1, p2);
    }
}
