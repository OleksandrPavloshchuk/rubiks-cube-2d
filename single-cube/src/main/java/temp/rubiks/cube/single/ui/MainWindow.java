package temp.rubiks.cube.single.ui;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 1000;

    private final Canvas canvas = new Canvas();

    public MainWindow() {
        super("SINGLE CUBE (test)");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(WIDTH, HEIGHT);

        final JButton buttonRefresh = new JButton("Refresh");
        buttonRefresh.addActionListener(event -> canvas.refresh());

        JRootPane rootPanel = getRootPane();
        rootPanel.setLayout(new BorderLayout());

        final JPanel controlPanel = new ControlPanel(canvas);
        rootPanel.add(controlPanel, BorderLayout.NORTH);
        rootPanel.add(canvas, BorderLayout.CENTER);
        rootPanel.add(buttonRefresh, BorderLayout.SOUTH);

    }


}
