package org.destrier.joust;

import java.util.List;
import java.util.Stack;

/**
 * Douglas-Peucker algorithm-based Generalizer.
 *
 * Non-recursive implementation.
 */
public final class DouglasPeuckerGeneralizer implements Generalizer {
    private final double epsilon;

    public DouglasPeuckerGeneralizer(double epsilon) {
        this.epsilon = epsilon;
    }

    protected List<Point> simplify(List<Point> polyline, double epsilon) {
        Stack<List<Point>> callStack = new Stack<>();

        callStack.push(polyline);

        while (!callStack.isEmpty()) {
            List<Point> points = callStack.pop();

            double maxDistance = 0;
            int index = 0;
            int end = points.size() - 1;

            for (int i = 0; i < end - 1; i++) {
                double distance = GeometryUtils.perpendecularDistance(points.get(0), points.get(end), points.get(i));
                if (distance > maxDistance) {
                    index = i;
                    maxDistance = distance;
                }
            }

            if (maxDistance > epsilon) {
                callStack.push(points.subList(0, index));
                callStack.push(points.subList(index, end));


            } else {

            }
        }

        return null;
    }

    @Override
    public List<Point> generalize(List<Point> points) {
        return simplify(points, epsilon);
    }
}
