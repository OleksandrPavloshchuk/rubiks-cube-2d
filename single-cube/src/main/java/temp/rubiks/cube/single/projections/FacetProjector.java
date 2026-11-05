package temp.rubiks.cube.single.projections;

import temp.rubiks.cube.engine.model.Cube;
import temp.rubiks.cube.engine.model.CubeOrientation;
import temp.rubiks.cube.engine.model.CubePosition;

import java.awt.*;
import java.util.Map;

public enum FacetProjector implements FacetProjectionDrawer {
    X0 {
        @Override
        public void draw(Graphics2D g2, Point topLeft, int cellSize, Map<CubePosition, Cube> cubes) {
            final Point tl = new Point(topLeft.x, topLeft.y + cellSize);
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    final CubeOrientation o = cubes.get(new CubePosition(-1, y, z)).getOrientation();
                    new FacetCellProjection(getCellTopLeft(tl, y, z, cellSize), o.x0(), cellSize).draw(g2);
                }
            }
        }
    },
    X1 {
        @Override
        public void draw(Graphics2D g2, Point topLeft, int cellSize, Map<CubePosition, Cube> cubes) {
            final Point tl = new Point(topLeft.x + 2 * cellSize, topLeft.y + cellSize);
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    final CubeOrientation o = cubes.get(new CubePosition(1, y, z)).getOrientation();
                    new FacetCellProjection(getCellTopLeft(tl, y, z, cellSize), o.x1(), cellSize).draw(g2);
                }
            }
        }
    },
    Y0 {
        @Override
        public void draw(Graphics2D g2, Point topLeft, int cellSize, Map<CubePosition, Cube> cubes) {
            final Point tl = new Point(topLeft.x + cellSize, topLeft.y + 2 * cellSize);
            for (int x = -1; x <= 1; x++) {
                for (int z = -1; z <= 1; z++) {
                    final CubeOrientation o = cubes.get(new CubePosition(x, -1, z)).getOrientation();
                    new FacetCellProjection(getCellTopLeft(tl, x, z, cellSize), o.y0(), cellSize).draw(g2);
                }
            }
        }
    },
    Y1 {
        @Override
        public void draw(Graphics2D g2, Point topLeft, int cellSize, Map<CubePosition, Cube> cubes) {
            final Point tl = new Point(topLeft.x + cellSize, topLeft.y);
            for (int x = -1; x <= 1; x++) {
                for (int z = -1; z <= 1; z++) {
                    final CubeOrientation o = cubes.get(new CubePosition(x, 1, z)).getOrientation();
                    new FacetCellProjection(getCellTopLeft(tl, x, z, cellSize), o.y1(), cellSize).draw(g2);
                }
            }
        }
    },
    Z0 {
        @Override
        public void draw(Graphics2D g2, Point topLeft, int cellSize, Map<CubePosition, Cube> cubes) {
            final Point tl = new Point(topLeft.x + cellSize, topLeft.y + 3 * cellSize);
            for (int x = -1; x <= 1; x++) {
                for (int y = -1; y <= 1; y++) {
                    final CubeOrientation o = cubes.get(new CubePosition(x, y, -1)).getOrientation();
                    new FacetCellProjection(getCellTopLeft(tl, x, y, cellSize), o.z0(), cellSize).draw(g2);
                }
            }
        }
    },
    Z1 {
        @Override
        public void draw(Graphics2D g2, Point topLeft, int cellSize, Map<CubePosition, Cube> cubes) {
            final Point tl = new Point(topLeft.x + cellSize, topLeft.y + cellSize);
            for (int x = -1; x <= 1; x++) {
                for (int y = -1; y <= 1; y++) {
                    final CubeOrientation o = cubes.get(new CubePosition(x, y, 1)).getOrientation();
                    new FacetCellProjection(getCellTopLeft(tl, x, y, cellSize), o.z1(), cellSize).draw(g2);
                }
            }
        }
    }
    ;

    private static Point getCellTopLeft(Point topLeft, int x, int y, int cellSize) {
        return new Point(
                topLeft.x + (1 + x) * cellSize,
                topLeft.y + (1 - y) * cellSize
        );
    }


}
