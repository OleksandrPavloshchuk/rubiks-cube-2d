package temp.rubiks.cube.ui;

import temp.rubiks.cube.model.AxisIndex;
import temp.rubiks.cube.model.ElementPosition;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static temp.rubiks.cube.model.AxisIndex.*;

public class ImageCoordinatesHolder {

    public static final int STEPS = 3;

    private static final double SIN60 = Math.sqrt(3) / 2.0;

    private final Point center;
    private final int radius;
    private final int radiusStep;

    private final Map<ElementPosition, Point> points = new HashMap<>();

    public ImageCoordinatesHolder(Point center, int radius, int radiusStep) {
        this.center = center;
        this.radius = radius;
        this.radiusStep = radiusStep;

        reset();
    }

    public Map<ElementPosition, Point> getPoints() {
        return points;
    }

    public int getRadiusStep() {
        return radiusStep;
    }

    public int getRadius() {
        return radius;
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

    public void reset() {

        final Point c1 = getCenter1();
        final Point c2 = getCenter2();
        final Point c3 = getCenter3();

        for (int i = 0; i < STEPS; i++) {
            final int r1 = radius - radiusStep * i;
            for (int j = 0; j < STEPS; j++) {
                final int r2 = radius - radiusStep * j;

                addPoints(i, j, getIntersections(c1, r1, c2, r2), A1, A2);
                addPoints(i, j, getIntersections(c2, r1, c3, r2), A2, A3);
                addPoints(i, j, getIntersections(c3, r1, c1, r2), A3, A1);
            }
        }

    }

    private void addPoints(int i, int j, Intersections intersections, AxisIndex idx1, AxisIndex idx2) {
        points.put(new ElementPosition(idx1, idx2, i, j), intersections.p1);
        points.put(new ElementPosition(idx2, idx1, i, j), intersections.p2);
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