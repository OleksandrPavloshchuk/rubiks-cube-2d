package temp.rubiks.cube.engine;

public record CubePosition(int x, int y, int z) {

    @Override
    public String toString() {
        return "(" + x + "," + y + "," + z + ")";
    }
}
