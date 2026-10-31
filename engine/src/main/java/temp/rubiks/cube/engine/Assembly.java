package temp.rubiks.cube.engine;

import java.util.ArrayList;
import java.util.List;

public class Assembly {

    private final List<Cube> cubes = new ArrayList<>();

    public Assembly() {
        init();
    }


    private Cube getCube(CubePosition position) {
        return cubes.stream()
                .filter(c -> c.getPosition().equals(position))
                .findAny()
                .orElse(null);
    }


    private void init() {
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    cubes.add(new Cube(new CubePosition(x, y, z)));
                }
            }
        }
    }

    @Override
    public String toString() {
        return cubes.toString();
    }

}
