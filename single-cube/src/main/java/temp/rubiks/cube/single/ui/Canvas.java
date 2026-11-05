package temp.rubiks.cube.single.ui;

import temp.rubiks.cube.engine.model.Cube;
import temp.rubiks.cube.engine.model.CubeOrientation;
import temp.rubiks.cube.engine.model.CubePosition;
import temp.rubiks.cube.engine.rotators.CubeOrientationRotator;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Canvas extends JPanel {

    private final int RADIUS = 210;
    private final int RADIUS_STEP = 35;

    private BufferedImage image;

    private final CoordinatesHolder coordinatesHolder =
            new CoordinatesHolder(getCenter(), RADIUS, RADIUS_STEP);

    private final Cube cube = new Cube(
        new CubePosition(-1, -1, -1)
    );

    private final Drawable guidesProjection = new CubeGuidesProjection(coordinatesHolder);

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

        // TODO remove trace
        System.out.println("before: " + orientation);

        orientation = CubeOrientationRotator.leftZ(orientation);

        // TODO remove trace
        System.out.println("after: " + orientation);

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
        coordinatesHolder.projectCube(cube);

        image = new BufferedImage(MainWindow.WIDTH, MainWindow.HEIGHT,
                BufferedImage.TYPE_INT_RGB);
        final Graphics2D g2 = image.createGraphics();
        try {
            drawBackground(g2);
            guidesProjection.draw(g2);
            drawPoints(g2);
        } finally {
            g2.dispose();
        }
        repaint();
    }

    private void drawBackground(Graphics2D g2) {
        g2.setColor(Color.white);
        g2.fillRect(0, 0, image.getWidth(), image.getHeight());
    }

    private void drawPoints(Graphics2D g2) {
        coordinatesHolder.getPoints().keySet().forEach(
                f -> new FacetDrawer(coordinatesHolder.getPoints().get(f), f.facet()).draw(g2)
        );
    }

    private static Point getCenter() {
        return new Point(MainWindow.WIDTH / 2, MainWindow.HEIGHT / 2 - 60);
    }
}
