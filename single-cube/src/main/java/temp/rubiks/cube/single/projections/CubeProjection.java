package temp.rubiks.cube.single.projections;

import temp.rubiks.cube.engine.model.Cube;
import temp.rubiks.cube.single.ui.Drawable;

import java.awt.*;

public record CubeProjection(
    Point leftTopCorner,
    Cube cube,
    int facetSize
) implements Drawable {

    @Override
    public void draw(Graphics2D g2) {
        Point p = new Point( leftTopCorner.x, leftTopCorner.y + facetSize);
        new FacetCellProjection(p, cube.getOrientation().x0(), facetSize).draw(g2);

        p = new Point( leftTopCorner.x + facetSize, leftTopCorner.y + 2 * facetSize);
        new FacetCellProjection(p, cube.getOrientation().y0(), facetSize).draw(g2);

        p = new Point( leftTopCorner.x + facetSize, leftTopCorner.y + 3 * facetSize);
        new FacetCellProjection(p, cube.getOrientation().z0(), facetSize).draw(g2);

        p = new Point( leftTopCorner.x + 2 * facetSize, leftTopCorner.y + facetSize);
        new FacetCellProjection(p, cube.getOrientation().x1(), facetSize).draw(g2);

        p = new Point( leftTopCorner.x + facetSize, leftTopCorner.y);
        new FacetCellProjection(p, cube.getOrientation().y1(), facetSize).draw(g2);

        p = new Point( leftTopCorner.x + facetSize, leftTopCorner.y + facetSize);
        new FacetCellProjection(p, cube.getOrientation().z1(), facetSize).draw(g2);
    }
}
