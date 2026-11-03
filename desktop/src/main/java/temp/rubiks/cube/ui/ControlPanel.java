package temp.rubiks.cube.ui;

import temp.rubiks.cube.model.AxisIndex;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {

    public ControlPanel(Canvas canvas) {
        setLayout(new GridLayout(AxisIndex.values().length, 2 * ImageCoordinatesHolder.STEPS));

        JButton button = new JButton("X" + "left" + ":" + -1);
        button.addActionListener(event -> canvas.rotateLeftX(-1));
        add(button);

        button = new JButton("X" + "right" + ":" + -1);
        button.addActionListener(event -> canvas.rotateRightX(-1));
        add(button);

        button = new JButton("X" + " " + "letf" + ":" + 1);
        button.addActionListener(event -> canvas.rotateLeftX(1));
        add(button);

        button = new JButton("X" + " " + "right" + ":" + 1);
        button.addActionListener(event -> canvas.rotateRightX(1));
        add(button);

        button = new JButton("Y" + " " + "left" + ":" + -1);
        button.addActionListener(event -> canvas.rotateLeftY(-1));
        add(button);

        button = new JButton("Y" + " " + "right" + ":" + -1);
        button.addActionListener(event -> canvas.rotateRightY(-1));
        add(button);

        button = new JButton("Y" + " " + "left" + ":" + 1);
        button.addActionListener(event -> canvas.rotateLeftY(1));
        add(button);

        button = new JButton("Y" + " " + "right" + ":" + 1);
        button.addActionListener(event -> canvas.rotateRightY(1));
        add(button);

        button = new JButton("Z" + " " + "left" + ":" + -1);
        button.addActionListener(event -> canvas.rotateLeftZ(-1));
        add(button);

        button = new JButton("Z" + " " + "right" + ":" + -1);
        button.addActionListener(event -> canvas.rotateRightZ(-1));
        add(button);

        button = new JButton("Z" + " " + "left" + ":" + 1);
        button.addActionListener(event -> canvas.rotateLeftZ(1));
        add(button);

        button = new JButton("Z" + "right" + ":" + 1);
        button.addActionListener(event -> canvas.rotateRightZ(1));
        add(button);

    }

}
