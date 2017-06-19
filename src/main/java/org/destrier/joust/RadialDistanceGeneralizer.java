package org.destrier.joust;

import java.util.ArrayList;
import java.util.List;

/**
 * Radial distance generalizer.
 * <p>
 * It reduces successive points that are placed in the tolerance range.
 */
public final class RadialDistanceGeneralizer implements Generalizer {
    private final double tolerance;

    public RadialDistanceGeneralizer(double tolerance) {
        this.tolerance = tolerance;
    }

    private static List<Point> simplify(List<Point> polyline, double tolerance) {
        if (polyline.size() < 3)
            return polyline;

        List<Point> result = new ArrayList<>();
        Point key = polyline.get(0);

        for (int i = 1; i < polyline.size(); i++) {
            Point keyCandidate = polyline.get(i);

            double distance = GeometryUtils.euclideanDistance(key, keyCandidate);

            if (distance > tolerance) {
                result.add(key);
                key = keyCandidate;
            }
        }

        result.add(polyline.get(polyline.size() - 1));

        return result;
    }

    @Override
    public List<Point> generalize(List<Point> points) {
        return simplify(points, tolerance);
    }
}
