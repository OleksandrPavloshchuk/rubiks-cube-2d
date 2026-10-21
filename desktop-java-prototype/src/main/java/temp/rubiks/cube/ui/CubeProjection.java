package temp.rubiks.cube.ui;

import java.awt.*;
import java.util.Map;

public class CubeProjection implements Drawable {

    private final Map<Integer, SideProjection> sides;

    public CubeProjection(int sideRadius, ImageCoordinatesHolder coordinatesHolder) {
        final int TEXT_OFFSET = 20;

        final Point c1 = coordinatesHolder.getCenter1();
        final Point c2 = coordinatesHolder.getCenter2();
        final Point c3 = coordinatesHolder.getCenter3();

        sides = Map.of(
                1,
                new SideProjection(1, c1,
                        new Point(c1.x, c1.y - TEXT_OFFSET),
                        coordinatesHolder),
                2,
                new SideProjection(2, c2,
                        new Point(c2.x - TEXT_OFFSET, c2.y + TEXT_OFFSET),
                        coordinatesHolder),
                3,
                new SideProjection(3, c3,
                        new Point(c3.x + TEXT_OFFSET, c3.y + TEXT_OFFSET),
                        coordinatesHolder)
        );
    }

    @Override
    public void draw(Graphics2D g2) {
        sides.values().forEach(side -> side.draw(g2));
    }
}
