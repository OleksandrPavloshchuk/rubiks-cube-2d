package temp.rubiks.cube.single.projections;

import temp.rubiks.cube.engine.model.Assembly;
import temp.rubiks.cube.single.ui.Drawable;

import java.awt.*;

public class AssemblyProjection implements Drawable {

    private final Point leftTopCorner;
    private final int cellSize;
    private final Assembly assembly;

    public AssemblyProjection(Point leftTopCorner, int cellSize, Assembly assembly) {
        this.cellSize = cellSize;
        this.leftTopCorner = leftTopCorner;
        this.assembly = assembly;
    }

    @Override
    public void draw(Graphics2D g2) {
        for( final FacetProjector projector : FacetProjector.values()) {
            projector.draw(g2, leftTopCorner, cellSize, assembly.getCubes());
        }
    }
}
