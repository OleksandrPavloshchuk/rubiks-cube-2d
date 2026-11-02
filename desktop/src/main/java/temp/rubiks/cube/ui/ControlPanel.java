package temp.rubiks.cube.ui;

import temp.rubiks.cube.model.AxisIndex;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {

    public ControlPanel(Canvas canvas) {
        setLayout(new GridLayout(AxisIndex.values().length, 2 * ImageCoordinatesHolder.STEPS));

        for (final AxisIndex axisIndex : AxisIndex.values()) {
            for( int i=0; i<ImageCoordinatesHolder.STEPS; i++ ) {
                final int c = i;

                final JButton buttonLeft = new JButton("⬅" + axisIndex + ":" + c);
                buttonLeft.addActionListener(event -> canvas.rotateLeft(axisIndex, c));
                add(buttonLeft);

                final JButton buttonRight = new JButton(axisIndex + ":" + c + "➡");
                buttonRight.addActionListener(event -> canvas.rotateRight(axisIndex, c));
                add(buttonRight);
            }
        }
    }

}
