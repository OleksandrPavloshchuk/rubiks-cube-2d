package temp.rubiks.cube.engine.rotators;

import temp.rubiks.cube.engine.model.CubeOrientation;

public class CubeOrientationRotator {

    public static CubeOrientation leftX(CubeOrientation src) {
        return new CubeOrientation(src.x0(), src.z1(), src.y0(), src.x1(), src.z0(), src.y1());
    }

    public static CubeOrientation rightX(CubeOrientation src) {
        return new CubeOrientation(src.x0(), src.z0(), src.y1(), src.x1(), src.z1(), src.y0());
    }

    public static CubeOrientation leftY(CubeOrientation src) {
        return new CubeOrientation(src.z1(), src.y0(), src.x0(), src.z0(), src.y1(), src.x1());
    }

    public static CubeOrientation rightY(CubeOrientation src) {
        return new CubeOrientation(src.z0(), src.y0(), src.x1(), src.z1(), src.y1(), src.x0());
    }

    public static CubeOrientation leftZ(CubeOrientation src) {
        return new CubeOrientation(src.y1(), src.x0(), src.z0(), src.y0(), src.x1(), src.z1());
    }

    public static CubeOrientation rightZ(CubeOrientation src) {
        return new CubeOrientation(src.y0(), src.x1(), src.z0(), src.y1(), src.x0(), src.z1());
    }

}
