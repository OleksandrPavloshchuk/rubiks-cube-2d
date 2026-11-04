package temp.rubiks.cube.ui;

import temp.rubiks.cube.engine.model.Assembly;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class CoordinatesHolder {

    private static final double SIN60 = Math.sqrt(3) / 2.0;

    private final Point center;
    private final int radius;
    private final int radiusStep;

    private final Map<CubeFacet, Point> points = new HashMap<>();

    public CoordinatesHolder(Point center, int radius, int radiusStep) {
        this.center = center;
        this.radius = radius;
        this.radiusStep = radiusStep;

        reset();
    }

    public Map<CubeFacet, Point> getPoints() {
        return points;
    }

    public int getRadiusStep() {
        return radiusStep;
    }

    public int getRadius() {
        return radius;
    }

    public Point getCenterZ() {
        return new Point(center.x, center.y - radius / 2);
    }

    public Point getCenterX() {
        return new Point(center.x - radius / 2, (int) (center.y + radius * (SIN60 - 0.5)));
    }

    public Point getCenterY() {
        return new Point(center.x + radius / 2, (int) (center.y + radius * (SIN60 - 0.5)));
    }

    public void projectAssembly(Assembly assembly) {
        // TODO implement this
    }

    @Deprecated
    public void reset() {
        resetZ(0, 3);
        resetX(1, 4);
        resetY(2, 5);
    }

    public void resetZ(int facet1, int facet2) {
        final Point cx = getCenterX();
        final Point cy = getCenterY();
        for (int x = -1; x <= 1; x++) {
            final double rx = radius + x * radiusStep;
            for (int y = -1; y <= 1; y++) {
                final double ry = radius + y * radiusStep;

                final Intersections intersections = getIntersections(cx, rx, cy, ry);
                points.put(new CubeFacet(x, y, -1, facet1), intersections.p1());
                points.put(new CubeFacet(x, y, 1, facet2), intersections.p2());
            }
        }
    }

    public void resetX(int facet1, int facet2) {
        final Point cz = getCenterZ();
        final Point cy = getCenterY();
        for (int z = -1; z <= 1; z++) {
            final double rz = radius + z * radiusStep;
            for (int y = -1; y <= 1; y++) {
                final double ry = radius + y * radiusStep;

                final Intersections intersections = getIntersections(cz, rz, cy, ry);
                points.put(new CubeFacet(-1, y, z, facet1), intersections.p1());
                points.put(new CubeFacet(1, y, z, facet2), intersections.p2());
            }
        }
    }

    public void resetY(int facet1, int facet2) {
        final Point cz = getCenterZ();
        final Point cx = getCenterX();
        for (int z = -1; z <= 1; z++) {
            final double rz = radius + z * radiusStep;
            for (int x = -1; x <= 1; x++) {
                final double rx = radius + x * radiusStep;

                final Intersections intersections = getIntersections(cz, rz, cx, rx);
                points.put(new CubeFacet(x, -1, z, facet1), intersections.p1());
                points.put(new CubeFacet(x, 1, z, facet2), intersections.p2());
            }
        }
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

    public record CubeFacet(int x, int y, int z, int facet) {
    }

    private record Intersections(Point p1, Point p2) {
    }

}