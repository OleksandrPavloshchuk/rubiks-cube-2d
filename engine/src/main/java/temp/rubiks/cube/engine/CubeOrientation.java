package temp.rubiks.cube.engine;

public record CubeOrientation(int x0, int y0, int z0, int x1, int y1, int z1) {

    public CubeOrientation() {
       this(-1, -1, -1, 1, 1, 1);
    }
}
