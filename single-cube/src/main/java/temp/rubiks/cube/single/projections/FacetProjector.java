package temp.rubiks.cube.single.projections;

import temp.rubiks.cube.engine.model.Cube;
import temp.rubiks.cube.engine.model.CubeOrientation;
import temp.rubiks.cube.engine.model.CubePosition;

import java.awt.*;
import java.util.Map;

@Deprecated
public enum FacetProjector implements FacetProjectionDrawer {
    X0 {
        @Override
        public void draw(Graphics2D g2, Point topLeft, int cellSize, Map<CubePosition, Cube> cubes) {
            final Point tl = new Point(topLeft.x, topLeft.y + 3 * cellSize);
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    final CubeOrientation o = cubes.get(new CubePosition(-1, y, z)).getOrientation();
                    new FacetCellProjection(getCellTopLeft(tl, translateToPane(y, z), cellSize), o.x0(), cellSize).draw(g2);
                }
            }
        }

        @Override
        public Point translateToPane(int x, int y) {
            return new Point(x, y);
        }
    },
    X1 {
        @Override
        public void draw(Graphics2D g2, Point topLeft, int cellSize, Map<CubePosition, Cube> cubes) {
            final Point tl = new Point(topLeft.x + 6 * cellSize, topLeft.y + 3 * cellSize);
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    final CubeOrientation o = cubes.get(new CubePosition(1, y, z)).getOrientation();
                    new FacetCellProjection(getCellTopLeft(tl, translateToPane(y, z), cellSize), o.x1(), cellSize).draw(g2);
                }
            }
        }
        @Override
        public Point translateToPane(int x, int y) {
            return new Point(x, y);
        }
    },
    Y0 {
        @Override
        public void draw(Graphics2D g2, Point topLeft, int cellSize, Map<CubePosition, Cube> cubes) {
            final Point tl = new Point(topLeft.x + 3 * cellSize, topLeft.y + 6 * cellSize);
            for (int x = -1; x <= 1; x++) {
                for (int z = -1; z <= 1; z++) {
                    final CubeOrientation o = cubes.get(new CubePosition(x, -1, z)).getOrientation();
                    new FacetCellProjection(getCellTopLeft(tl, translateToPane(x, z), cellSize), o.y0(), cellSize).draw(g2);
                }
            }
        }

        @Override
        public Point translateToPane(int x, int y) {
            return new Point(y, x);
        }

    },
    Y1 {
        @Override
        public void draw(Graphics2D g2, Point topLeft, int cellSize, Map<CubePosition, Cube> cubes) {
            final Point tl = new Point(topLeft.x + 3 * cellSize, topLeft.y);
            for (int x = -1; x <= 1; x++) {
                for (int z = -1; z <= 1; z++) {
                    final CubeOrientation o = cubes.get(new CubePosition(x, 1, z)).getOrientation();
                    new FacetCellProjection(getCellTopLeft(tl, translateToPane(x, z), cellSize), o.y1(), cellSize).draw(g2);
                }
            }
        }

        @Override
        public Point translateToPane(int x, int y) {
            return new Point(y, x);
        }
    },
    Z0 {
        @Override
        public void draw(Graphics2D g2, Point topLeft, int cellSize, Map<CubePosition, Cube> cubes) {
            final Point tl = new Point(topLeft.x + 3 * cellSize, topLeft.y + 9 * cellSize);
            for (int x = -1; x <= 1; x++) {
                for (int y = -1; y <= 1; y++) {
                    final CubeOrientation o = cubes.get(new CubePosition(x, y, -1)).getOrientation();
                    new FacetCellProjection(getCellTopLeft(tl, translateToPane(x, y), cellSize), o.z0(), cellSize).draw(g2);
                }
            }
        }

        @Override
        public Point translateToPane(int x, int y) {
            return new Point(x, y);
        }

    },
    Z1 {
        @Override
        public void draw(Graphics2D g2, Point topLeft, int cellSize, Map<CubePosition, Cube> cubes) {
            final Point tl = new Point(topLeft.x + 3 * cellSize, topLeft.y + 3 * cellSize);
            for (int x = -1; x <= 1; x++) {
                for (int y = -1; y <= 1; y++) {
                    final CubeOrientation o = cubes.get(new CubePosition(x, y, 1)).getOrientation();
                    new FacetCellProjection(getCellTopLeft(tl, translateToPane(x, y), cellSize), o.z1(), cellSize).draw(g2);
                }
            }
        }

        @Override
        public Point translateToPane(int x, int y) {
            return new Point(x, y);
        }
    }
    ;

    private static Point getCellTopLeft(Point topLeft, Point p, int cellSize) {
        return new Point(
                topLeft.x + (1 + p.x) * cellSize,
                topLeft.y + (1 - p.y) * cellSize
        );
    }


}
