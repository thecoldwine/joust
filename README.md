# joust
Polyline simplification library.

This library is targeted to provide different methods of polyline generalization algorithms implemented in friendly way with a BSD license.

Generalization is a process of reducing the number of points in a geometry feature with preserving
common properties of this feature. It is usable when the source data is oversampled, for example 
straight forward way with sample rate 200m.

The first implementation presented in this library is a [Douglas-Peucker algorithm](https://en.wikipedia.org/wiki/Ramer%E2%80%93Douglas%E2%80%93Peucker_algorithm).

### Warning

The library is not released yet. Please await for version 1.0 when API will be stable and
documentation will be good enough to anyone not only to guys who ready to read source code.

## Usage

```java
    List<Point> simplifyPolyline(List<Point> polyline) {
        Generalizer g = new DouglasPeuckerGeneralizer(0.5 /* algorithm sensitivity */);
        return g.generalize(polyline);
    }
    
```

## Roadmap

* 0.5 - Douglas-Peucker algorithm.
* 0.6 - Radial distance algorithm.
* 0.7 - Visvalingam–Whyatt algorithm.
* 0.8 - Reumann–Witkam algorithm.
* 0.9 - Opheim algorithm.
* 1.0 - Release with comments, documents and visual examples.
