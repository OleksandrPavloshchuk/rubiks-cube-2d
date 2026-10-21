package temp.rubiks.cube.model;

public class Element {

    private final ColorIndex colorIndex;
    private ElementPosition position;

    public Element(ColorIndex colorIndex, ElementPosition position) {
        this.colorIndex = colorIndex;
        this.position = position;
    }

    public ColorIndex getColorIndex() {
        return colorIndex;
    }

    public ElementPosition getPosition() {
        return position;
    }

    public void setPosition(ElementPosition position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "[" + position + "]=" + colorIndex;
    }
}
