package temp.rubiks.cube.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static temp.rubiks.cube.model.ColorIndex.*;
import static temp.rubiks.cube.model.AxisIndex.*;
import static temp.rubiks.cube.model.RadiusIndex.*;

public class Cube {
    private final List<Element> elements = new ArrayList<>(54);

    public Cube() {
        init();
    }

    public List<Element> getElements() {
        return elements;
    }

    public Optional<Element> find(ElementPosition position) {
        return elements.stream()
                .filter(e -> e.getPosition().equals(position))
                .findAny();
    }

    private void init() {
        elements.add(new Element(C1, new ElementPosition(A1, A2, R1)));
        elements.add(new Element(C2, new ElementPosition(A2, A1, R1)));
        elements.add(new Element(C3, new ElementPosition(A1, A3, R1)));
        elements.add(new Element(C4, new ElementPosition(A3, A1, R1)));
        elements.add(new Element(C5, new ElementPosition(A2, A3, R1)));
        elements.add(new Element(C6, new ElementPosition(A3, A2, R1)));
    }

}
