package temp.rubiks.cube.single.projections;

import java.awt.*;
import java.util.Map;

public record FacetProjection(
        Point topLeft,
        int cellSize,
        int index,
        Map<Point, Integer> facet
) implements Drawable {

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(Color.darkGray);
        g2.drawString("" + index, topLeft.x - 20, topLeft.y - 20 );

        facet.forEach((point, color) ->
                new FacetCellProjection(
                        translateToPlane(point),
                        color,
                        cellSize
                ).draw(g2)
        );
    }

    private Point translateToPlane(Point src) {
        return new Point(
                topLeft.x + (src.x + 1) * cellSize,
                topLeft.y + (1 - src.y) * cellSize
        );
    }

}
