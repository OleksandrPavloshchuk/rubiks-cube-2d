package temp.rubiks.cube.single.ui;

import temp.rubiks.cube.engine.model.Assembly;
import temp.rubiks.cube.engine.rotators.AssemblyRotator;
import temp.rubiks.cube.single.projections.AssemblyProjection;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Canvas extends JPanel {

    private BufferedImage image;

    private final Assembly assembly = new Assembly();

    public Canvas() {
        refresh();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }

    public void refresh() {
        assembly.reset();
        redrawContent();
    }

    public void rotateLeftX(int x) {
        AssemblyRotator.rotateLeftX(assembly, x);
        redrawContent();
    }

    public void rotateRightX(int x) {
        AssemblyRotator.rotateRightX(assembly, x);
        redrawContent();
    }

    public void rotateLeftY(int y) {
        AssemblyRotator.rotateLeftY(assembly, y);
        redrawContent();
    }

    public void rotateRightY(int y) {
        AssemblyRotator.rotateRightY(assembly, y);
        redrawContent();
    }

    public void rotateLeftZ(int z) {
        AssemblyRotator.rotateLeftZ(assembly, z);
        redrawContent();
    }

    public void rotateRightZ(int z) {
        AssemblyRotator.rotateRightZ(assembly, z);
        redrawContent();
    }

    private void redrawContent() {

        image = new BufferedImage(MainWindow.WIDTH, MainWindow.HEIGHT,
                BufferedImage.TYPE_INT_RGB);
        final Graphics2D g2 = image.createGraphics();
        try {
            drawBackground(g2);
            drawAssembly(g2);
        } finally {
            g2.dispose();
        }
        repaint();
    }

    private void drawBackground(Graphics2D g2) {
        g2.setColor(Color.white);
        g2.fillRect(0, 0, image.getWidth(), image.getHeight());
    }

    private void drawAssembly(Graphics2D g2) {
        new AssemblyProjection(new Point (160, 50), 50, assembly).draw(g2);
    }

}
