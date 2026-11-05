package temp.rubiks.cube.single.ui;

import temp.rubiks.cube.engine.model.Cube;
import temp.rubiks.cube.engine.model.CubeOrientation;
import temp.rubiks.cube.engine.model.CubePosition;
import temp.rubiks.cube.engine.rotators.CubeOrientationRotator;
import temp.rubiks.cube.single.projections.CubeProjection;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Canvas extends JPanel {

    private BufferedImage image;

    private final Cube cube = new Cube(
        new CubePosition(-1, -1, -1)
    );

    public Canvas() {
        refresh();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }

    public void refresh() {
        cube.setOrientation(new CubeOrientation(0, 1, 2, 3, 4, 5));
        redrawContent();
    }

    public void rotateLeftX() {
        CubeOrientation orientation = cube.getOrientation();
        orientation = CubeOrientationRotator.leftX(orientation);
        cube.setOrientation(orientation);
        redrawContent();
    }

    public void rotateRightX() {
        CubeOrientation orientation = cube.getOrientation();
        orientation = CubeOrientationRotator.rightX(orientation);
        cube.setOrientation(orientation);
        redrawContent();
    }

    public void rotateLeftY() {
        CubeOrientation orientation = cube.getOrientation();
        orientation = CubeOrientationRotator.leftY(orientation);
        cube.setOrientation(orientation);
        redrawContent();
    }

    public void rotateRightY() {
        CubeOrientation orientation = cube.getOrientation();
        orientation = CubeOrientationRotator.rightY(orientation);
        cube.setOrientation(orientation);
        redrawContent();
    }

    public void rotateLeftZ() {
        CubeOrientation orientation = cube.getOrientation();
        orientation = CubeOrientationRotator.leftZ(orientation);
        cube.setOrientation(orientation);
        redrawContent();
    }

    public void rotateRightZ() {
        CubeOrientation orientation = cube.getOrientation();
        orientation = CubeOrientationRotator.rightZ(orientation);
        cube.setOrientation(orientation);
        redrawContent();
    }

    private void redrawContent() {

        image = new BufferedImage(MainWindow.WIDTH, MainWindow.HEIGHT,
                BufferedImage.TYPE_INT_RGB);
        final Graphics2D g2 = image.createGraphics();
        try {
            drawBackground(g2);
            drawCube(g2);
        } finally {
            g2.dispose();
        }
        repaint();
    }

    private void drawBackground(Graphics2D g2) {
        g2.setColor(Color.white);
        g2.fillRect(0, 0, image.getWidth(), image.getHeight());
    }

    private void drawCube(Graphics2D g2) {
        new CubeProjection(
                new Point (160, 50),
                cube,
                160
        ).draw(g2);
    }

}
