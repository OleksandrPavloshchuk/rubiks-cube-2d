package temp.rubiks.cube.single.ui;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.List;

public class CubeGuidesProjection implements Drawable {

    private final List<FacetGuidesProjection> sides;

    public CubeGuidesProjection(CoordinatesHolder coordinatesHolder) {
        final int TEXT_OFFSET = 60;

        final Point cz = coordinatesHolder.getCenterZ();
        final Point cx = coordinatesHolder.getCenterX();
        final Point cy = coordinatesHolder.getCenterY();

        sides = List.of(
                new FacetGuidesProjection("Z", cz,
                        new Point(cz.x, cz.y - TEXT_OFFSET),
                        coordinatesHolder),
                new FacetGuidesProjection( "X", cx,
                        new Point(cx.x - TEXT_OFFSET, cx.y + TEXT_OFFSET),
                        coordinatesHolder),
                new FacetGuidesProjection("Y", cy,
                        new Point(cy.x + TEXT_OFFSET, cy.y + TEXT_OFFSET),
                        coordinatesHolder)
        );
    }

    @Override
    public void draw(Graphics2D g2) {
        sides.forEach(side -> side.draw(g2));
    }
}
