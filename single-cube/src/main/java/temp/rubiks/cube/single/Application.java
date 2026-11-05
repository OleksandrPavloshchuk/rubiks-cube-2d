package temp.rubiks.cube.single;

import com.formdev.flatlaf.FlatIntelliJLaf;
import temp.rubiks.cube.single.ui.MainWindow;

import javax.swing.*;

public class Application {

    public static void main(String[] args) {
        FlatIntelliJLaf.setup();
        SwingUtilities.invokeLater(() -> new MainWindow().setVisible(true));
    }
}
