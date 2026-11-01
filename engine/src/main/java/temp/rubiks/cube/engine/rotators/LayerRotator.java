package temp.rubiks.cube.engine.rotators;

import temp.rubiks.cube.engine.model.Cube;
import temp.rubiks.cube.engine.model.CubeOrientation;
import temp.rubiks.cube.engine.model.CubePosition;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class LayerRotator {

    public static List<Cube> rotateLeftX(List<Cube> src) {
        return rotateX(src, CubeOrientationRotator::leftX, CubePositionRotator::left);
    }

    public static List<Cube> rotateRightX(List<Cube> src) {
        return rotateX(src, CubeOrientationRotator::rightX, CubePositionRotator::right);
    }

    public static List<Cube> rotateLeftY(List<Cube> src) {
        return rotateY(src, CubeOrientationRotator::leftY, CubePositionRotator::left);
    }

    public static List<Cube> rotateRightY(List<Cube> src) {
        return rotateY(src, CubeOrientationRotator::rightY, CubePositionRotator::right);
    }

    public static List<Cube> rotateLeftZ(List<Cube> src) {
        return rotateZ(src, CubeOrientationRotator::leftZ, CubePositionRotator::left);
    }

    public static List<Cube> rotateRightZ(List<Cube> src) {
        return rotateZ(src, CubeOrientationRotator::rightZ, CubePositionRotator::right);
    }

    private static List<Cube> rotateX(
            List<Cube> src,
            Function<CubeOrientation, CubeOrientation> orientationTransformer,
            BiFunction<Integer, Integer, CubePositionRotator.Pair> posTransformer) {
        return src.stream()
                .map(cube -> {
                    final CubePosition pos = cube.getPosition();
                    final int x = pos.x();
                    final CubeOrientation newOrientation = orientationTransformer.apply(cube.getOrientation());
                    final CubePositionRotator.Pair newPos = posTransformer.apply(pos.y(), pos.z());
                    cube.setOrientation(newOrientation);
                    cube.setPosition(new CubePosition(x, newPos.x(), newPos.y()));
                    return cube;
                })
                .toList();
    }

    private static List<Cube> rotateY(
            List<Cube> src,
            Function<CubeOrientation, CubeOrientation> orientationTransformer,
            BiFunction<Integer, Integer, CubePositionRotator.Pair> posTransformer) {
        return src.stream()
                .map(cube -> {
                    final CubePosition pos = cube.getPosition();
                    final int y = pos.y();
                    final CubeOrientation newOrientation = orientationTransformer.apply(cube.getOrientation());
                    final CubePositionRotator.Pair newPos = posTransformer.apply(pos.x(), pos.z());
                    cube.setOrientation(newOrientation);
                    cube.setPosition(new CubePosition(newPos.x(), y, newPos.y()));
                    return cube;
                })
                .toList();
    }

    private static List<Cube> rotateZ(
            List<Cube> src,
            Function<CubeOrientation, CubeOrientation> orientationTransformer,
            BiFunction<Integer, Integer, CubePositionRotator.Pair> posTransformer) {
        return src.stream()
                .map(cube -> {
                    final CubePosition pos = cube.getPosition();
                    final int z = pos.z();
                    final CubeOrientation newOrientation = orientationTransformer.apply(cube.getOrientation());
                    final CubePositionRotator.Pair newPos = posTransformer.apply(pos.x(), pos.y());
                    cube.setOrientation(newOrientation);
                    cube.setPosition(new CubePosition(newPos.x(), newPos.y(), z));
                    return cube;
                })
                .toList();
    }
}
