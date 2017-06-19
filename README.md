# joust
Polyline simplification library.

This library is targeted to provide different methods of polyline generalization algorithms implemented in friendly way with a BSD license.

The problem of line generalization (or simplification if you wish) is a 

The first implementation presented in this library is a [Douglas-Peucker algorithm](https://en.wikipedia.org/wiki/Ramer%E2%80%93Douglas%E2%80%93Peucker_algorithm).

## Usage

```java
    List<Point> points = ... // initialize the list of points somehow.
    Generalizer g = new DouglasPeuckerGeneralizer(0.5 /* algorithm sensitivity */);
    g.generalize(points); // enjoy you line!
```

## Roadmap

* 0.5 - Douglas-Peucker algorithm.
* 0.6 - Radial distance algorithm.
* 0.7 - Visvalingam–Whyatt algorithm.
* 0.8 - Reumann–Witkam algorithm.
* 0.9 - Opheim algorithm.
* 1.0 - Release with comments, documents and visual examples.
