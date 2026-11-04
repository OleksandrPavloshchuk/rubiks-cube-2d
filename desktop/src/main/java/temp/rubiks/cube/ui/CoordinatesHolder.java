package temp.rubiks.cube.ui;

import temp.rubiks.cube.engine.model.Assembly;
import temp.rubiks.cube.engine.model.CubeOrientation;
import temp.rubiks.cube.utils.CircleIntersectionsCalculator;

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
        projectAssemblyX(assembly);
        projectAssemblyZ(assembly);
        // TODO implement this
    }

    public void projectAssemblyZ(Assembly assembly) {
        final Point cx = getCenterX();
        final Point cy = getCenterY();
        for (int x = -1; x <= 1; x++) {
            final double rx = radius + x * radiusStep;
            for (int y = -1; y <= 1; y++) {
                final double ry = radius + y * radiusStep;
                final Point[] intersections = CircleIntersectionsCalculator.getIntersections(cx, rx, cy, ry);

                CubeOrientation orientation = assembly.getCubeOrientation(x, y, -1);
                points.put(new CubeFacet(x, y, -1, orientation.z0()), intersections[0]);
                orientation = assembly.getCubeOrientation(x, y, 1);
                points.put(new CubeFacet(x, y, 1, orientation.z1()), intersections[1]);
            }
        }
    }

    public void projectAssemblyX(Assembly assembly) {
        final Point cz = getCenterZ();
        final Point cy = getCenterY();
        for (int z = -1; z <= 1; z++) {
            final double rz = radius + z * radiusStep;
            for (int y = -1; y <= 1; y++) {
                final double ry = radius + y * radiusStep;
                final Point[] intersections = CircleIntersectionsCalculator.getIntersections(cz, rz, cy, ry);

                CubeOrientation orientation = assembly.getCubeOrientation(-1, y, z);
                points.put(new CubeFacet(-1, y, z, orientation.x0()), intersections[0]);
                orientation = assembly.getCubeOrientation(1, y, z);
                points.put(new CubeFacet(1, y, z, orientation.x1()), intersections[1]);
            }
        }
    }


    @Deprecated
    public void reset() {
        resetZ(0, 3);
        resetX(1, 4);
        resetY(2, 5);
    }

    @Deprecated
    public void resetZ(int facet1, int facet2) {
        final Point cx = getCenterX();
        final Point cy = getCenterY();
        for (int x = -1; x <= 1; x++) {
            final double rx = radius + x * radiusStep;
            for (int y = -1; y <= 1; y++) {
                final double ry = radius + y * radiusStep;

                final Point[] intersections = CircleIntersectionsCalculator.getIntersections(cx, rx, cy, ry);
                points.put(new CubeFacet(x, y, -1, facet1), intersections[0]);
                points.put(new CubeFacet(x, y, 1, facet2), intersections[1]);
            }
        }
    }

    @Deprecated
    public void resetX(int facet1, int facet2) {
        final Point cz = getCenterZ();
        final Point cy = getCenterY();
        for (int z = -1; z <= 1; z++) {
            final double rz = radius + z * radiusStep;
            for (int y = -1; y <= 1; y++) {
                final double ry = radius + y * radiusStep;

                final Point[] intersections = CircleIntersectionsCalculator.getIntersections(cz, rz, cy, ry);
                points.put(new CubeFacet(-1, y, z, facet1), intersections[0]);
                points.put(new CubeFacet(1, y, z, facet2), intersections[1]);
            }
        }
    }

    @Deprecated
    public void resetY(int facet1, int facet2) {
        final Point cz = getCenterZ();
        final Point cx = getCenterX();
        for (int z = -1; z <= 1; z++) {
            final double rz = radius + z * radiusStep;
            for (int x = -1; x <= 1; x++) {
                final double rx = radius + x * radiusStep;

                final Point[] intersections = CircleIntersectionsCalculator.getIntersections(cz, rz, cx, rx);
                points.put(new CubeFacet(x, -1, z, facet1), intersections[0]);
                points.put(new CubeFacet(x, 1, z, facet2), intersections[1]);
            }
        }
    }

    public record CubeFacet(int x, int y, int z, int facet) {
    }

}