package org.destrier.joust;

import java.util.ArrayList;
import java.util.Arrays;
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
        boolean[] keep = new boolean[polyline.size()];
        Arrays.fill(keep, true);

        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        stack.push(Pair.create(0, polyline.size() - 1)); // put border indices of list on stack.

        while (!stack.isEmpty()) {
            int startIndex = stack.peek().getFirst();
            int endIndex = stack.peek().getSecond();
            stack.pop();

            double maxDistance = 0;
            int index = startIndex;

            for (int i = startIndex + 1; i < endIndex; i++) {
                if (keep[i]) {
                    Point p1 = polyline.get(startIndex);
                    Point p2 = polyline.get(endIndex);

                    double d = GeometryUtils.perpendicularDistance(polyline.get(i), p1, p2);

                    if (d > maxDistance) {
                        index = i;
                        maxDistance = d;
                    }
                }
            }

            if (maxDistance >= epsilon) {
                stack.push(Pair.create(startIndex, index));
                stack.push(Pair.create(index, endIndex));
            } else {
                for (int i = startIndex + 1; i < endIndex; i++) {
                    keep[i] = false;
                }
            }
        }

        List<Point> result = new ArrayList<>();

        for (int i = 0; i < keep.length; i++) {
            if (keep[i])
                result.add(polyline.get(i));
        }

        return result;
    }

    @Override
    public List<Point> generalize(List<Point> points) {
        return simplify(points, epsilon);
    }
}
