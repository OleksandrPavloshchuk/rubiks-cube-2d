package temp.rubiks.cube.single.projections;

import temp.rubiks.cube.engine.model.Assembly;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public enum FacetExtractor
        implements Function<Assembly, Map<Point, Integer>> {

    X0 {
        @Override
        public Map<Point, Integer> apply(Assembly assembly) {
            final Map<Point, Integer> result = new HashMap<>();
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    final int color = assembly.getCubeOrientation( -1, y, z).x0();
                    result.put(new Point(y, z), color);
                }
            }
            return result;
        }
    },
    X1 {
        @Override
        public Map<Point, Integer> apply(Assembly assembly) {
            final Map<Point, Integer> result = new HashMap<>();
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    final int color = assembly.getCubeOrientation( 1, y, z).x1();
                    result.put(new Point(y, z), color);
                }
            }
            return result;
        }
    },
    Y0 {
        @Override
        public Map<Point, Integer> apply(Assembly assembly) {
            final Map<Point, Integer> result = new HashMap<>();
            for (int x = -1; x <= 1; x++) {
                for (int z = -1; z <= 1; z++) {
                    final int color = assembly.getCubeOrientation(x, -1, z).y0();
                    result.put(new Point(x, z), color);
                }
            }
            return result;
        }
    },
    Y1 {
        @Override
        public Map<Point, Integer> apply(Assembly assembly) {
            final Map<Point, Integer> result = new HashMap<>();
            for (int x = -1; x <= 1; x++) {
                for (int z = -1; z <= 1; z++) {
                    final int color = assembly.getCubeOrientation(x, 1, z).y1();
                    result.put(new Point(x, z), color);
                }
            }
            return result;
        }
    },
    Z0 {
        @Override
        public Map<Point, Integer> apply(Assembly assembly) {
            final Map<Point, Integer> result = new HashMap<>();
            for (int x = -1; x <= 1; x++) {
                for (int y = -1; y <= 1; y++) {
                    final int color = assembly.getCubeOrientation(x, y, -1).z0();
                    result.put(new Point(x, y), color);
                }
            }
            return result;
        }
    },
    Z1 {
        @Override
        public Map<Point, Integer> apply(Assembly assembly) {
            final Map<Point, Integer> result = new HashMap<>();
            for (int x = -1; x <= 1; x++) {
                for (int y = -1; y <= 1; y++) {
                    final int color = assembly.getCubeOrientation(x, y, 1).z1();
                    result.put(new Point(x, y), color);
                }
            }
            return result;
        }
    }


}
