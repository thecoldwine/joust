package org.destrier.joust;

/**
 * Created by Mikhail Aksenov.
 * 2017-06-16
 * org.destrier.joust
 */
public class GeometryUtils {
    public static double euclidianDistance(Point a, Point b) {
        if (a == null || b == null)
            throw new IllegalArgumentException("One of arguments is null.");

        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }

    public static double perpendecularDistance(Point p1, Point p2, Point t) {
        if (p1 == null || p2 == null || p1.equals(p2))
            throw new IllegalArgumentException("Points must be not null and different");

        double y1 = p1.getY();
        double y2 = p2.getY();
        double x1 = p1.getX();
        double x2 = p2.getX();
        double x0 = t.getX();
        double y0 = t.getY();

        return Math.abs((y2 - y1) * x0 - (x2 - x1) * y0 + x2 * y1 - y2 * x1) /
                euclidianDistance(p1, p2);
    }
}
