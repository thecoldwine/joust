package org.destrier.joust;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DouglasPeuckerGeneralizerTest {
    private Point[] sourceLine = new Point[]{
            new Point(3.5, 21.25),
            new Point(7.3, 12.0),
            new Point(23.2, 3.1),
            new Point(37.2, 12.07),
            new Point(54.6, 18.15),
            new Point(62.2, 16.45),
            new Point(71.5, 9.7),
            new Point(101.3, 21.),
    };

    private Point[] targetLine = new Point[]{
            new Point(3.5, 21.25),
            new Point(23.2, 3.1),
            new Point(54.6, 18.15),
            new Point(71.5, 9.7),
            new Point(101.3, 21.),
    };

    @Test
    public void generalize() throws Exception {
        List<Point> sourceList = Arrays.asList(sourceLine);
        List<Point> targetList = Arrays.asList(targetLine);

        Generalizer generalizer = new DouglasPeuckerGeneralizer(5);

        List<Point> simplified = generalizer.generalize(sourceList);

        Assert.assertArrayEquals(targetList.toArray(), simplified.toArray());
    }
}