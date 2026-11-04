package temp.rubiks.cube;

import com.formdev.flatlaf.FlatIntelliJLaf;
import temp.rubiks.cube.ui.MainWindow;

import javax.swing.*;

public class Application {

    public static void main(String[] args) {
        FlatIntelliJLaf.setup();
        SwingUtilities.invokeLater(() -> new MainWindow().setVisible(true));
    }
}
