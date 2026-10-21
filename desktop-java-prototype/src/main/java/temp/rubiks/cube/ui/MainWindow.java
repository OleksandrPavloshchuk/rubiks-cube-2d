package temp.rubiks.cube.ui;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 1000;

    private final JButton buttonRefresh = new JButton("Refresh");
    private final JButton button1 = new JButton("1");
    private final JButton button2 = new JButton("2");
    private final JButton button3 = new JButton("3");
    private final JButton button4 = new JButton("4");

    private final temp.rubiks.cube.ui.Canvas canvas = new Canvas();

    public MainWindow() {
        super("Rubiks Cube 2D (prototype)");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(WIDTH, HEIGHT);

        buttonRefresh.addActionListener(event -> canvas.refresh());
        button1.addActionListener(event -> canvas.rotate1());
        button2.addActionListener(event -> canvas.rotate2());
        button3.addActionListener(event -> canvas.rotate3());
        button4.addActionListener(event -> canvas.rotate4());

        JRootPane rootPanel = getRootPane();
        rootPanel.setLayout(new BorderLayout());

        final JPanel controlPanel = new JPanel();
        controlPanel.add(button1);
        controlPanel.add(button2);
        controlPanel.add(button3);
        controlPanel.add(button4);
        rootPanel.add(controlPanel, BorderLayout.NORTH);

        rootPanel.add(canvas, BorderLayout.CENTER);

        rootPanel.add(buttonRefresh, BorderLayout.SOUTH);



    }


}
