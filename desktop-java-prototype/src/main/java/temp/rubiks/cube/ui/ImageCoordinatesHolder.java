package temp.rubiks.cube.ui;

import temp.rubiks.cube.model.Element;
import temp.rubiks.cube.model.ElementPosition;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static temp.rubiks.cube.model.AxisIndex.*;
import static temp.rubiks.cube.model.RadiusIndex.*;

public class ImageCoordinatesHolder {

    private static final double SIN60 = Math.sqrt(3) / 2.0;

    private final Point center;
    private final int radius;
    private final int radiusStep;
    private final List<Element> elements;

    private Map<ElementPosition, Point> points = new HashMap<>();

    public ImageCoordinatesHolder(Point center, int radius, int radiusStep, List<Element> elements) {
        this.center = center;
        this.radius = radius;
        this.elements = elements;
        this.radiusStep = radiusStep;

        init();
    }

    public Map<ElementPosition, Point> getPoints() {
        return points;
    }

    public Point getCenter1() {
        return new Point(center.x, center.y - radius / 2);
    }

    public Point getCenter2() {
        return new Point(center.x - radius / 2, (int) (center.y + radius * (SIN60 - 0.5)));
    }

    public Point getCenter3() {
        return new Point(center.x + radius / 2, (int) (center.y + radius * (SIN60 - 0.5)));
    }

    private void init() {

        // Calculate axis coordinates:
        final Point c1 = getCenter1();
        final Point c2 = getCenter2();
        final Point c3 = getCenter3();

        Intersections i = getIntersections(c1, radius, c2, radius);
        points.put( new ElementPosition(A1, A2, R1), i.p1);
        points.put( new ElementPosition(A2, A1, R1), i.p2);
        i = getIntersections(c2, radius, c3, radius);
        points.put( new ElementPosition(A2, A3, R1), i.p1);
        points.put( new ElementPosition(A3, A2, R1), i.p2);
        i = getIntersections(c3, radius, c1, radius);
        points.put( new ElementPosition(A3, A1, R1), i.p1);
        points.put( new ElementPosition(A1, A3, R1), i.p2);
    }

    private Intersections getIntersections(Point c1, double r1, Point c2, double r2) {
        final double d = Math.sqrt((c1.x - c2.x) * (c1.x - c2.x) + (c1.y - c2.y) * (c1.y - c2.y));
        final double a = (r1 * r1 - r2 * r2 + d * d) / (2 * d);
        final double h = Math.sqrt(r1 * r1 - a * a);
        final double ux = (c2.x - c1.x) / d;
        final double uy = (c2.y - c1.y) / d;
        final double px = c1.x + a * ux;
        final double py = c1.y + a * uy;

        final double xP = px - h * uy;
        final double yP = py + h * ux;

        final double xM = px + h * uy;
        final double yM = py - h * ux;

        // TODO use more precise calculations
        return new Intersections(
                new Point((int) xP, (int) yP),
                new Point((int) xM, (int) yM)
        );
    }

    private record Intersections(Point p1, Point p2) {
    }

}