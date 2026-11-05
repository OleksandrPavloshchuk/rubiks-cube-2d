package temp.rubiks.cube.single;

import temp.rubiks.cube.single.ui.MainWindow;

import javax.swing.*;

public class Application {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        SwingUtilities.invokeLater(() -> new MainWindow().setVisible(true));
    }
}
