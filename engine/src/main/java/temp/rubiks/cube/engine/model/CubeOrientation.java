package temp.rubiks.cube.engine.model;

public record CubeOrientation(int x0, int y0, int z0, int x1, int y1, int z1) {

    public CubeOrientation() {
       this(0, 1, 2, 3, 4, 5);
    }
}
