package temp.rubiks.cube.single.projections;

import temp.rubiks.cube.engine.model.Assembly;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public enum FacetExtractor
        implements BiFunction<Assembly, Integer, Map<Point, Integer>> {

    Z0 {
        @Override
        public Map<Point, Integer> apply(Assembly assembly, Integer integer) {
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
        public Map<Point, Integer> apply(Assembly assembly, Integer integer) {
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
