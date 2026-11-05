package temp.rubiks.cube.single.ui;

import javax.swing.*;
import java.awt.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ControlPanel extends JPanel {

    public ControlPanel(Canvas canvas) {
        setLayout(new GridLayout(3, 4));

        for (final Axis axis : Axis.values()) {
                add(createButton(canvas, axis, "left", -1, axis.rotateLeft));
                add(createButton(canvas, axis, "right", -1, axis.rotateRight));
            add(createButton(canvas, axis, "left", 1, axis.rotateLeft));
            add(createButton(canvas, axis, "right", 1, axis.rotateRight));
        }
    }

    private JButton createButton(Canvas canvas, Axis axis, String label, int i, BiConsumer<Canvas, Integer> rotate) {
        final JButton result = new JButton(axis.name() + " " + label + ": " + i);
        result.addActionListener(event -> rotate.accept(canvas, i));
        return result;
    }

    private enum Axis {
        X(Canvas::rotateLeftX, Canvas::rotateRightX),
        Y(Canvas::rotateLeftY, Canvas::rotateRightY),
        Z(Canvas::rotateLeftZ, Canvas::rotateRightZ);

        private final BiConsumer<Canvas, Integer> rotateLeft;
        private final BiConsumer<Canvas, Integer> rotateRight;

        Axis(BiConsumer<Canvas, Integer> rotateLeft, BiConsumer<Canvas, Integer> rotateRight) {
            this.rotateLeft = rotateLeft;
            this.rotateRight = rotateRight;
        }
    }

}
