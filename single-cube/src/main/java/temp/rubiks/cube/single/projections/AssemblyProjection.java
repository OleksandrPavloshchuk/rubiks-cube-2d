package temp.rubiks.cube.single.projections;

import temp.rubiks.cube.engine.model.Assembly;

import java.awt.*;

public class AssemblyProjection implements Drawable {

    private final Point leftTop;
    private final int cellSize;
    private final Assembly assembly;

    public AssemblyProjection(Point leftTop, int cellSize, Assembly assembly) {
        this.cellSize = cellSize;
        this.leftTop = leftTop;
        this.assembly = assembly;
    }

    @Override
    public void draw(Graphics2D g2) {

        new FacetProjection(
                getFacetTopLeft(0, 0),
                cellSize,
                0,
                FacetExtractor.X0.apply(assembly)
        ).draw(g2);

        new FacetProjection(
                getFacetTopLeft(1, 0),
                cellSize,
                1,
                FacetExtractor.Y0.apply(assembly)
        ).draw(g2);

        new FacetProjection(
                getFacetTopLeft(2, 0),
                cellSize,
                2,
                FacetExtractor.Z0.apply(assembly)
        ).draw(g2);

        new FacetProjection(
                getFacetTopLeft(0, 1),
                cellSize,
                3,
                FacetExtractor.X1.apply(assembly)
        ).draw(g2);

        new FacetProjection(
                getFacetTopLeft(1, 1),
                cellSize,
                4,
                FacetExtractor.Y1.apply(assembly)
        ).draw(g2);

        new FacetProjection(
                getFacetTopLeft(2, 1),
                cellSize,
                5,
                FacetExtractor.Z1.apply(assembly)
        ).draw(g2);
    }

    private Point getFacetTopLeft(int x, int y) {
        return new Point(
                leftTop.x + 4 * cellSize * x,
                leftTop.y + 4 * cellSize * y
        );
    }

}
