package temp.rubiks.cube.ui;

import java.awt.*;
import java.util.Map;

public class CubeProjection implements Drawable {

    private final Map<Integer, SideProjection> sides;

    public CubeProjection(Point center, int sideRadius) {
        int yOffset = (int) (Math.sqrt(3) * sideRadius / 2) - sideRadius / 2;
        final int TEXT_OFFSET = 20;
        sides = Map.of(
                1,
                new SideProjection(1,
                        new Point(center.x, center.y - sideRadius / 2),
                        new Point(center.x, center.y - sideRadius / 2 - TEXT_OFFSET)
                        , sideRadius),
                2,
                new SideProjection(2,
                        new Point(center.x - sideRadius / 2, center.y + yOffset),
                        new Point(center.x - sideRadius / 2 - TEXT_OFFSET, center.y + yOffset + TEXT_OFFSET),
                        sideRadius),
                3,
                new SideProjection(3,
                        new Point(center.x + sideRadius / 2, center.y + yOffset),
                        new Point(center.x + sideRadius / 2 + TEXT_OFFSET, center.y + yOffset + TEXT_OFFSET),
                        sideRadius)
        );
    }

    @Override
    public void draw(Graphics2D g2) {
        sides.values().forEach(side -> side.draw(g2));
    }
}
