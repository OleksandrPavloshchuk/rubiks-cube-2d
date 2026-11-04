package temp.rubiks.cube.ui;

import javax.swing.*;
import java.awt.*;
import java.util.function.BiConsumer;

public class ControlPanel extends JPanel {

    public ControlPanel(Canvas canvas) {
        setLayout(new GridLayout(3, 6));

        for (final Axis axis : Axis.values()) {
            for( final Offset offset: Offset.values()) {
                add(createButton(canvas, axis, offset, "left", axis.rotateLeft));
                add(createButton(canvas, axis, offset, "right", axis.rotateRight));
            }
        }
    }

    private JButton createButton(Canvas canvas, Axis axis, Offset offset, String label, BiConsumer<Canvas, Integer> rotate) {
        final JButton result = new JButton(axis.name() + " " + label + ":" + offset.val);
        result.addActionListener(event -> rotate.accept(canvas, offset.val));
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

    private enum Offset {
        Low(-1), High(1);

        private final int val;

        Offset(int val) {
            this.val = val;
        }
    }

}
