package temp.rubiks.cube.engine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CubePositionRotatorUnitTest {

    @ParameterizedTest
    @CsvSource({
            "0, 1, -1, 0",
            "0, -1, 1, 0",
            "1, 0, 0, 1",
            "-1, 0, 0, -1",
            "-1, -1, 1, -1",
            "1, -1, 1, 1",
            "1, 1, -1, 1",
            "-1, 1, -1, -1"
    })
    void left(int x, int y, int resX, int resY) {
        Assertions.assertEquals(new CubePositionRotator.Pair(resX, resY), CubePositionRotator.left(x, y));
    }

    @ParameterizedTest
    @CsvSource({
            "0, 1, 1, 0",
            "0, -1, -1, 0",
            "1, 0, 0, -1",
            "-1, 0, 0, 1",
            "-1, -1, -1, 1",
            "1, -1, -1, -1",
            "1, 1, 1, -1",
            "-1, 1, 1, 1"
    })
    void right(int x, int y, int resX, int resY) {
        Assertions.assertEquals(new CubePositionRotator.Pair(resX, resY), CubePositionRotator.right(x, y));
    }

}
