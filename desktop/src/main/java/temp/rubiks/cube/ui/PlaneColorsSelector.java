package temp.rubiks.cube.ui;

import temp.rubiks.cube.engine.model.Cube;
import temp.rubiks.cube.engine.model.CubeOrientation;
import temp.rubiks.cube.engine.model.CubePosition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Translation of layer of cubes to list of colors on specified direction
 */
public class PlaneColorsSelector {

    public static Map<Point, Integer> getColorsX(List<Cube> cubes, int x) {
        return getColors(cubes, x,
                CubeOrientation::x0,
                CubeOrientation::x1,
                p -> new Point(p.y(), p.z()));
    }


    public static Map<Point, Integer> getColorsY(List<Cube> cubes, int y) {
        return getColors(cubes, y,
                CubeOrientation::y0,
                CubeOrientation::y1,
                p -> new Point(p.x(), p.z()));
    }

    public static Map<Point, Integer> getColorsZ(List<Cube> cubes, int z) {
        return getColors(cubes, z,
                CubeOrientation::z0,
                CubeOrientation::z1,
                 p -> new Point(p.x(), p.y()));
    }

    private static Map<Point, Integer> getColors(
            List<Cube> cubes,
            int n,
            Function<CubeOrientation, Integer> colorSelectorDown,
            Function<CubeOrientation, Integer> colorSelectorUp,
            Function<CubePosition, Point> translatorToPoint) {
        final Map<Point, Integer> result = new HashMap<>();
        cubes.forEach(cube -> {
            final Function<CubeOrientation, Integer> colorSelector = n == -1
                    ? colorSelectorDown
                    : colorSelectorUp;
            result.put(
                    translatorToPoint.apply(cube.getPosition()),
                    colorSelector.apply(cube.getOrientation())
            );
        });
        return result;
    }

    public record Point(int x, int y) {
    }

}
