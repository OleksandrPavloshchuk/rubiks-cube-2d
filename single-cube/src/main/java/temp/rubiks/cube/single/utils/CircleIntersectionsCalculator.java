package temp.rubiks.cube.single.utils;

import java.awt.*;

public class CircleIntersectionsCalculator {

    public static Point[] getIntersections(Point c1, double r1, Point c2, double r2) {
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
        return new Point[]{
                new Point((int) xP, (int) yP),
                new Point((int) xM, (int) yM)
        };
    }

}
