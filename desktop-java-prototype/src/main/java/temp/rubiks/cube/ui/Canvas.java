package temp.rubiks.cube.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Canvas extends JPanel {

    private BufferedImage image;

    private final Drawable projection = new CubeProjection(
            new Point(MainWindow.WIDTH / 2, MainWindow.HEIGHT / 2),
            240
    );

    public Canvas() {
        redrawContent();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(image, 0, 0, this);
    }

    public void refresh() {
        JOptionPane.showMessageDialog(this, "TODO refresh");
        redrawContent();
    }

    public void rotate1() {
        JOptionPane.showMessageDialog(this, "TODO rotate 1");
        redrawContent();
    }

    public void rotate2() {
        JOptionPane.showMessageDialog(this, "TODO rotate 2");
        redrawContent();
    }

    public void rotate3() {
        JOptionPane.showMessageDialog(this, "TODO rotate 3");
        redrawContent();
    }

    private void redrawContent() {
        image = new BufferedImage(MainWindow.WIDTH, MainWindow.HEIGHT,
                BufferedImage.TYPE_INT_RGB);
        final Graphics2D g2 = image.createGraphics();
        try {
            g2.setColor(Color.lightGray);
            g2.fillRect(0, 0, image.getWidth(), image.getHeight());

            projection.draw(g2);

        } finally {
            g2.dispose();
        }

    }


}
