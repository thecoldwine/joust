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

        double[] aCoordinates = a.getCoordinates(),
                 bCoordinates = b.getCoordinates();

        assert aCoordinates.length == bCoordinates.length;

        double acc = 0;

        for (int i = 0; i < aCoordinates.length; i++) {
            acc += Math.pow(aCoordinates[i] - bCoordinates[i], 2);
        }

        return Math.sqrt(acc);
    }

    public static double perpendecularDistance(Point p1, Point p2, Point t) {
        if (p1 == null || p2 == null || p1.equals(p2))
            throw new IllegalArgumentException("Points must be not null and different");

        double[] a = p1.getCoordinates(),
                 b = p2.getCoordinates(),
                 p = t.getCoordinates();

        double euclideanDistance = euclidianDistance(p1, p2);
        double lambda = dotProduct(subtractVectors(p, a), subtractVectors(b, a)) / euclideanDistance;
        double[] v = sumVectors(a, multiplyVectorByNumber(subtractVectors(b, a), lambda));

        return l2Norm(subtractVectors(v, p));
    }

    public static double dotProduct(double[] v1, double[] v2) {
        assert v1.length == v2.length;

        double result = 0;

        for (int i = 0; i < v1.length; i++) {
            result += v1[i] * v2[i];
        }

        return result;
    }

    public static double[] subtractVectors(double[] v1, double[] v2) {
        assert v1.length == v2.length;

        double[] result = new double[v1.length];

        for (int i = 0; i < v1.length; i++) {
            result[i] = v1[i] - v2[i];
        }

        return result;
    }

    public static double[] sumVectors(double[] v1, double[] v2) {
        assert v1.length == v2.length;

        double[] result = new double[v1.length];

        for (int i = 0; i < v1.length; i++) {
            result[i] = v1[i] + v2[i];
        }

        return result;
    }

    public static double[] multiplyVectorByNumber(double[] v, double number) {
        double[] result = new double[v.length];

        for (int i = 0; i < v.length; i++) {
            result[i] = v[i] * number;
        }

        return result;
    }

    public static double l2Norm(double[] v) {
        double result = 0;

        for (double c: v) {
            result += c;
        }

        return Math.sqrt(result);
    }
}
