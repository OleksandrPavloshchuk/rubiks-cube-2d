package temp.rubiks.cube.ui;

import java.awt.*;
import java.util.Map;

public class CubeProjection implements Drawable {

    private final Map<Integer, GuidesProjection> sides;

    public CubeProjection(ImageCoordinatesHolder coordinatesHolder) {
        final int TEXT_OFFSET = 60;

        final Point cz = coordinatesHolder.getCenterZ();
        final Point cx = coordinatesHolder.getCenterX();
        final Point cy = coordinatesHolder.getCenterY();

        sides = Map.of(
                1,
                new GuidesProjection("Z", cz,
                        new Point(cz.x, cz.y - TEXT_OFFSET),
                        coordinatesHolder),
                2,
                new GuidesProjection( "X", cx,
                        new Point(cx.x - TEXT_OFFSET, cx.y + TEXT_OFFSET),
                        coordinatesHolder),
                3,
                new GuidesProjection("Y", cy,
                        new Point(cy.x + TEXT_OFFSET, cy.y + TEXT_OFFSET),
                        coordinatesHolder)
        );
    }

    @Override
    public void draw(Graphics2D g2) {
        sides.values().forEach(side -> side.draw(g2));
    }
}
