package temp.rubiks.cube.model;

import java.util.List;

import static temp.rubiks.cube.model.AxisIndex.*;

public class OrderHolder {

    public static List<ElementPosition> getOrder(AxisIndex axis, int radius) {
        return switch (axis) {
            case A1 -> getOrderA1(radius);
            case A2 -> getOrderA2(radius);
            case A3 -> getOrderA3(radius);
        };
    }

    private static List<ElementPosition> getOrderA1(int r) {
        return List.of(
                new ElementPosition(A3, A1, 0, r),
                new ElementPosition(A3, A1, 1, r),
                new ElementPosition(A3, A1, 2, r),
                new ElementPosition(A2, A1, r, 0),
                new ElementPosition(A2, A1, r, 1),
                new ElementPosition(A2, A1, r, 2),
                new ElementPosition(A1, A3, 2, r),
                new ElementPosition(A1, A3, 1, r),
                new ElementPosition(A1, A3, 0, r),
                new ElementPosition(A1, A2, r, 2),
                new ElementPosition(A1, A2, r, 1),
                new ElementPosition(A1, A2, r, 0)
        );
    }

    private static List<ElementPosition> getOrderA2(int r) {
        return List.of(
                new ElementPosition(A1, A2, 0, r),
                new ElementPosition(A1, A2, 1, r),
                new ElementPosition(A1, A2, 2, r),
                new ElementPosition(A3, A2, r, 0),
                new ElementPosition(A3, A2, r, 1),
                new ElementPosition(A3, A2, r, 2),
                new ElementPosition(A2, A1, 2, r),
                new ElementPosition(A2, A1, 1, r),
                new ElementPosition(A2, A1, 0, r),
                new ElementPosition(A2, A3, r, 2),
                new ElementPosition(A2, A3, r, 1),
                new ElementPosition(A2, A3, r, 0)
        );
    }

    private static List<ElementPosition> getOrderA3(int r) {
        return List.of(
                new ElementPosition(A2, A3, 0, r),
                new ElementPosition(A2, A3, 1, r),
                new ElementPosition(A2, A3, 2, r),
                new ElementPosition(A1, A3, r, 0),
                new ElementPosition(A1, A3, r, 1),
                new ElementPosition(A1, A3, r, 2),
                new ElementPosition(A3, A2, 2, r),
                new ElementPosition(A3, A2, 1, r),
                new ElementPosition(A3, A2, 0, r),
                new ElementPosition(A3, A1, r, 2),
                new ElementPosition(A3, A1, r, 1),
                new ElementPosition(A3, A1, r, 0)
        );
    }

}
