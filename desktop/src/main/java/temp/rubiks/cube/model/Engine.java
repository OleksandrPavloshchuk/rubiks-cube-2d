package temp.rubiks.cube.model;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

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
        for (int i = 0; i < steps; i++) {
            for (int j = 0; j < steps; j++) {
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
        rotateLeft(OrderHolder.getOrder(axis, radius));
    }

    private void rotateLeft(List<ElementPosition> positions) {
        ColorIndex i1 = colors.get(positions.getFirst());
        ColorIndex i2 = colors.get(positions.get(1));
        ColorIndex i3 = colors.get(positions.get(2));

        for (int i = 0; i < positions.size() - 3; i++) {
            colors.put(positions.get(i), colors.get(positions.get(i + 3)));
        }

        colors.put(positions.get(positions.size()-3), i1);
        colors.put(positions.get(positions.size()-2), i2);
        colors.put(positions.getLast(), i3);
    }

    public void rotateRight(AxisIndex axis, int radius) {
        rotateRight(OrderHolder.getOrder(axis, radius));
    }

    private void rotateRight(List<ElementPosition> positions) {
        ColorIndex i1 = colors.get(positions.getLast());
        ColorIndex i2 = colors.get(positions.get(positions.size()-2));
        ColorIndex i3 = colors.get(positions.get(positions.size()-3));

        for (int i = positions.size()-1; i>=3; i--) {
            colors.put(positions.get(i), colors.get(positions.get(i - 3)));
        }

        colors.put(positions.get(2), i1);
        colors.put(positions.get(1), i2);
        colors.put(positions.getFirst(), i3);
    }

}
