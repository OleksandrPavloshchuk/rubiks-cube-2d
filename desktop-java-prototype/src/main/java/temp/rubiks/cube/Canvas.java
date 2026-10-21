package temp.rubiks.cube;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Canvas extends JPanel {

    private BufferedImage image;

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

    public void rotate4() {
        JOptionPane.showMessageDialog(this, "TODO rotate 4");
        redrawContent();
    }

    private void redrawContent() {
        image = new BufferedImage(MainWindow.WIDTH, MainWindow.HEIGHT,
                BufferedImage.TYPE_INT_RGB);
        final Graphics2D g2 = image.createGraphics();
        try {
            g2.setColor(Color.lightGray);
            g2.fillRect(0, 0, image.getWidth(), image.getHeight());

            g2.setColor(Color.BLUE);
            g2.fillOval(50, 50, 100, 100);

            g2.setColor(Color.RED);
            g2.setStroke(new BasicStroke(3));
            g2.drawLine(0, 0, 400, 300);
        } finally {
            g2.dispose();
        }

    }



}
