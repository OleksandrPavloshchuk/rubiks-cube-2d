package temp.rubiks.cube.model;

import java.util.HashMap;
import java.util.Map;

import static temp.rubiks.cube.model.AxisIndex.*;

public class Engine {

    private final int steps;
    private final Map<ElementPosition, ColorIndex> colors = new HashMap<>();

    public Engine(int steps) {
        this.steps = steps;
        reset();
    }

    public Map<ElementPosition, ColorIndex> getColors() {
        return colors;
    }

    public void reset() {
        for( int i=0; i<steps; i++ ) {
            for( int j=0; j<steps; j++ ) {
                colors.put(new ElementPosition(A1, A2, i, j), ColorIndex.C1);
                colors.put(new ElementPosition(A2, A1, i, j), ColorIndex.C2);
                colors.put(new ElementPosition(A2, A3, i, j), ColorIndex.C3);
                colors.put(new ElementPosition(A3, A2, i, j), ColorIndex.C4);
                colors.put(new ElementPosition(A3, A1, i, j), ColorIndex.C5);
                colors.put(new ElementPosition(A1, A3, i, j), ColorIndex.C6);
            }
        }
    }

    public void rotateLeft(AxisIndex axis, int radius) {
        // TODO
    }

    public void rotateRight(AxisIndex axis, int radius) {
        // TODO
    }

}
