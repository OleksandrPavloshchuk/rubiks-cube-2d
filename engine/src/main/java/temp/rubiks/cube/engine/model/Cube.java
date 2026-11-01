package temp.rubiks.cube.engine.model;

public class Cube {

    private CubePosition position;
    private CubeOrientation orientation;

    public Cube(
            CubePosition position
    ) {
        setPosition(position);
        setOrientation(new CubeOrientation());
    }

    public CubePosition getPosition() {
        return position;
    }

    public void setPosition(CubePosition position) {
        this.position = position;
    }

    public CubeOrientation getOrientation() {
        return orientation;
    }

    public void setOrientation(CubeOrientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public String toString() {
        return "P: " + position + ", O: " + orientation;
    }
}
