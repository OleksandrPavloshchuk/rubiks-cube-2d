package temp.rubiks.cube.ui;

import java.awt.*;
import java.util.List;

public class CubeProjection implements Drawable {

    private final List<SideProjection> sides;

    public CubeProjection(Point center, int sideRadius) {
        sides = List.of(
                new SideProjection(center, sideRadius),
                new SideProjection(new Point(
                        center.x, center.y - sideRadius
                ), sideRadius)
        );
    }

    @Override
    public void draw(Graphics2D g2) {
        sides.forEach(side -> side.draw(g2));
    }
}
