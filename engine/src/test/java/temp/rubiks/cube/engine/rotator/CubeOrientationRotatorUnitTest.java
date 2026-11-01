package temp.rubiks.cube.engine.rotator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import temp.rubiks.cube.engine.model.CubeOrientation;
import temp.rubiks.cube.engine.rotators.CubeOrientationRotator;

import java.util.function.Function;

public class CubeOrientationRotatorUnitTest {

    @Test
    void doAndUndo() {
        doAndUndo(CubeOrientationRotator::leftX, CubeOrientationRotator::rightX);
        doAndUndo(CubeOrientationRotator::leftY, CubeOrientationRotator::rightY);
        doAndUndo(CubeOrientationRotator::leftZ, CubeOrientationRotator::rightZ);
        doAndUndo(CubeOrientationRotator::rightX, CubeOrientationRotator::leftX);
        doAndUndo(CubeOrientationRotator::rightY, CubeOrientationRotator::leftY);
        doAndUndo(CubeOrientationRotator::rightZ, CubeOrientationRotator::leftZ);
    }

    @Test
    void circle() {
        circle(CubeOrientationRotator::leftX);
        circle(CubeOrientationRotator::rightX);
        circle(CubeOrientationRotator::leftY);
        circle(CubeOrientationRotator::rightY);
        circle(CubeOrientationRotator::leftZ);
        circle(CubeOrientationRotator::rightZ);
    }

    private void doAndUndo(
            Function<CubeOrientation, CubeOrientation> l,
            Function<CubeOrientation, CubeOrientation> r) {
        final CubeOrientation expected = new CubeOrientation();
        Assertions.assertEquals(expected, l.apply(r.apply(expected)));
    }

    private void circle(
            Function<CubeOrientation, CubeOrientation> f) {
        final CubeOrientation expected = new CubeOrientation();
        Assertions.assertEquals(expected, f.apply(f.apply(f.apply(f.apply(expected)))));
    }
}
