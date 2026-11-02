package temp.rubiks.cube;

import temp.rubiks.cube.ui.MainWindow;

import javax.swing.*;

public class Application {

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        SwingUtilities.invokeLater(() -> {
            new MainWindow().setVisible(true);
        });

    }
}
