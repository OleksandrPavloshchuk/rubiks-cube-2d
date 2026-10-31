package temp.rubiks.cube.engine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Assembly {

    private final Map<CubePosition, Cube> cubes = new HashMap<>();

    public Assembly() {
        init();
    }

    public List<Cube> getLayerX(int x) {
        return getLayer(pos -> pos.x() == x);
    }

    public List<Cube> getLayerY(int y) {
        return getLayer(pos -> pos.y() == y);
    }

    public List<Cube> getLayerZ(int z) {
        return getLayer(pos -> pos.z() == z);
    }

    public void putCube(Cube cube) {
        cubes.put(cube.getPosition(), cube);
    }

    private List<Cube> getLayer(Predicate<CubePosition> positionPredicate) {
        final List<Cube> result = cubes.values().stream()
                .filter(c -> positionPredicate.test(c.getPosition()))
                .toList();
        result.forEach( cube -> cubes.remove(cube.getPosition()));
        return result;
    }

    private void init() {
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    putCube(new Cube(new CubePosition(x, y, z)));
                }
            }
        }
    }

    @Override
    public String toString() {
        return cubes.toString();
    }

}
