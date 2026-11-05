package temp.rubiks.cube.single.ui;

import temp.rubiks.cube.engine.model.Cube;
import temp.rubiks.cube.engine.model.CubeOrientation;
import temp.rubiks.cube.engine.model.CubePosition;
import temp.rubiks.cube.single.utils.CircleIntersectionsCalculator;

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

    public void projectCube(Cube cube) {
        projectCubeX(cube);
        projectCubeY(cube);
        projectCubeZ(cube);
    }

    public void projectCubeX(Cube cube) {
        final Point cy = getCenterY();
        final Point cz = getCenterZ();

        final CubePosition pos = cube.getPosition();
        final int y = pos.y();
        final int z = pos.z();

        final double ry = radius + y * radiusStep;
        final double rz = radius + z * radiusStep;
        final Point[] intersections = CircleIntersectionsCalculator.getIntersections(cy, ry, cz, rz);

        final CubeOrientation orientation = cube.getOrientation();
        points.put(new CubeFacet( -1, y, z, orientation.x0()), intersections[0]);
        points.put(new CubeFacet( 1, y, z, orientation.x1()), intersections[1]);
    }

    public void projectCubeY(Cube cube) {
        final Point cx = getCenterX();
        final Point cz = getCenterZ();

        final CubePosition pos = cube.getPosition();
        final int x = pos.x();
        final int z = pos.z();

        final double rx = radius + x * radiusStep;
        final double rz = radius + z * radiusStep;
        final Point[] intersections = CircleIntersectionsCalculator.getIntersections(cx, rx, cz, rz);

        final CubeOrientation orientation = cube.getOrientation();
        points.put(new CubeFacet(x, -1, z, orientation.y0()), intersections[0]);
        points.put(new CubeFacet(x, 1, z, orientation.y1()), intersections[1]);
    }

    public void projectCubeZ(Cube cube) {
        final Point cx = getCenterX();
        final Point cy = getCenterY();

        final CubePosition pos = cube.getPosition();
        final int x = pos.x();
        final int y = pos.y();

        final double rx = radius + x * radiusStep;
        final double ry = radius + y * radiusStep;
        final Point[] intersections = CircleIntersectionsCalculator.getIntersections(cx, rx, cy, ry);

        final CubeOrientation orientation = cube.getOrientation();
        points.put(new CubeFacet(x, y, -1, orientation.z0()), intersections[0]);
        points.put(new CubeFacet(x, y, 1, orientation.z1()), intersections[1]);
    }

    public record CubeFacet(int x, int y, int z, int facet) {
    }

}