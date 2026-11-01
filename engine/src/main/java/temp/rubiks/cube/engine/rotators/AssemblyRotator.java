package temp.rubiks.cube.engine.rotators;

import temp.rubiks.cube.engine.LayerRotator;
import temp.rubiks.cube.engine.model.Assembly;
import temp.rubiks.cube.engine.model.Cube;

import java.util.List;
import java.util.function.Function;

public class AssemblyRotator {

    public static void rotateLeftX(Assembly assembly, int x) {
        doRotate(assembly, assembly.getLayerX(x), LayerRotator::rotateLeftX);
    }

    public static void rotateRightX(Assembly assembly, int x) {
        doRotate(assembly, assembly.getLayerX(x), LayerRotator::rotateRightX);
    }

    public static void rotateLeftY(Assembly assembly, int y) {
        doRotate(assembly, assembly.getLayerY(y), LayerRotator::rotateLeftY);
    }

    public static void rotateRightY(Assembly assembly, int y) {
        doRotate(assembly, assembly.getLayerY(y), LayerRotator::rotateRightY);
    }

    public static void rotateLeftZ(Assembly assembly, int z) {
        doRotate(assembly, assembly.getLayerZ(z), LayerRotator::rotateLeftZ);
    }

    public static void rotateRightZ(Assembly assembly, int z) {
        doRotate(assembly, assembly.getLayerZ(z), LayerRotator::rotateRightZ);
    }

    private static void doRotate(
            Assembly assembly,
            List<Cube> src,
            Function<List<Cube>, List<Cube>> layerRotator) {
        layerRotator.apply(src).forEach(assembly::putCube);
    }

}
