package temp.rubiks.cube.single.ui;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class ControlPanel extends JPanel {

    public ControlPanel(Canvas canvas) {
        setLayout(new GridLayout(3, 2));

        for (final Axis axis : Axis.values()) {
                add(createButton(canvas, axis, "left", axis.rotateLeft));
                add(createButton(canvas, axis, "right", axis.rotateRight));
        }
    }

    private JButton createButton(Canvas canvas, Axis axis, String label, Consumer<Canvas> rotate) {
        final JButton result = new JButton(axis.name() + " " + label);
        result.addActionListener(event -> rotate.accept(canvas));
        return result;
    }

    private enum Axis {
        X(Canvas::rotateLeftX, Canvas::rotateRightX),
        Y(Canvas::rotateLeftY, Canvas::rotateRightY),
        Z(Canvas::rotateLeftZ, Canvas::rotateRightZ);

        private final Consumer<Canvas> rotateLeft;
        private final Consumer<Canvas> rotateRight;

        Axis(Consumer<Canvas> rotateLeft, Consumer<Canvas> rotateRight) {
            this.rotateLeft = rotateLeft;
            this.rotateRight = rotateRight;
        }
    }

}
