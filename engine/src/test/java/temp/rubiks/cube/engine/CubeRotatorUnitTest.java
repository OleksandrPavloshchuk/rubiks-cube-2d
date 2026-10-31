package temp.rubiks.cube.engine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

public class CubeRotatorUnitTest {

    @Test
    void doAndUndo() {
        doAndUndo(CubeRotator::leftX, CubeRotator::rightX);
        doAndUndo(CubeRotator::leftY, CubeRotator::rightY);
        doAndUndo(CubeRotator::leftZ, CubeRotator::rightZ);
        doAndUndo(CubeRotator::rightX, CubeRotator::leftX);
        doAndUndo(CubeRotator::rightY, CubeRotator::leftY);
        doAndUndo(CubeRotator::rightZ, CubeRotator::leftZ);
    }

    @Test
    void circle() {
        circle(CubeRotator::leftX);
        circle(CubeRotator::rightX);
        circle(CubeRotator::leftY);
        circle(CubeRotator::rightY);
        circle(CubeRotator::leftZ);
        circle(CubeRotator::rightZ);
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
