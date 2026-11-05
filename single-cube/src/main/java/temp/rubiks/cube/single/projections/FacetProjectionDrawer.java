package temp.rubiks.cube.single.projections;

import temp.rubiks.cube.engine.model.Cube;
import temp.rubiks.cube.engine.model.CubePosition;

import java.awt.*;
import java.util.Map;

public interface FacetProjectionDrawer {
    void draw(
            Graphics2D g2,
            Point topLeft,
            int cellSize,
            Map<CubePosition, Cube> cubes
    );
}
