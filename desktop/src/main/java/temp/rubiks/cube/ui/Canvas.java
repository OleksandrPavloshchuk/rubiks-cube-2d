package temp.rubiks.cube.ui;

import temp.rubiks.cube.engine.model.Assembly;
import temp.rubiks.cube.engine.model.Cube;
import temp.rubiks.cube.engine.rotators.AssemblyRotator;
import temp.rubiks.cube.model.AxisIndex;
import temp.rubiks.cube.model.ColorIndex;
import temp.rubiks.cube.model.ElementPosition;
import temp.rubiks.cube.model.Engine;

import javax.swing.*;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.List;

public class Canvas extends JPanel {

    private final int RADIUS = 240;
    private final int RADIUS_STEP = 25;
    private final int POINT_RADIUS = 12;

    private BufferedImage image;

    private final ImageCoordinatesHolder imageCoordinatesHolder =
            new ImageCoordinatesHolder(getCenter(), RADIUS, RADIUS_STEP);

    // TODO substitute it by the new engine from separate module
    @Deprecated
    private final Engine engine_OLD = new Engine(ImageCoordinatesHolder.STEPS);

    private final Assembly assembly = new Assembly();

    private final Drawable projection = new CubeProjection(imageCoordinatesHolder);

    public Canvas() {
        redrawContent();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(image, 0, 0, this);
    }

    public void refresh() {
        imageCoordinatesHolder.reset();
        assembly.reset();
        redrawContent();
    }

    public void rotateLeftX(int x) {
        AssemblyRotator.rotateLeftX(assembly, x);
        final List<Cube> cubes = assembly.getLayerX(x);
        // TODO

    }

    public void rotateRightX(int x) {
        AssemblyRotator.rotateRightX(assembly, x);
        final List<Cube> cubes = assembly.getLayerX(x);
        // TODO

    }

    public void rotateLeftY(int y) {
        AssemblyRotator.rotateLeftY(assembly, y);
        final List<Cube> cubes = assembly.getLayerY(y);
        // TODO
    }

    public void rotateRightY(int y) {
        AssemblyRotator.rotateRightY(assembly, y);
        final List<Cube> cubes = assembly.getLayerY(y);
        // TODO
    }

    public void rotateLeftZ(int z) {
        AssemblyRotator.rotateLeftZ(assembly, z);
        final List<Cube> cubes = assembly.getLayerZ(z);
        // TODO
    }

    public void rotateRightZ(int z) {
        AssemblyRotator.rotateRightZ(assembly, z);
        final List<Cube> cubes = assembly.getLayerZ(z);
        // TODO
    }

    @Deprecated
    public void rotateLeft(AxisIndex axis, int radius) {
        engine_OLD.rotateLeft(axis, radius);
        redrawContent();
    }

    @Deprecated
    public void rotateRight(AxisIndex axis, int radius) {
        engine_OLD.rotateRight(axis, radius);
        redrawContent();
    }

    private void redrawContent() {
        image = new BufferedImage(MainWindow.WIDTH, MainWindow.HEIGHT,
                BufferedImage.TYPE_INT_RGB);
        final Graphics2D g2 = image.createGraphics();
        try {
            g2.setColor(Color.white);
            g2.fillRect(0, 0, image.getWidth(), image.getHeight());

            projection.draw(g2);

            drawPoints(g2);

        } finally {
            g2.dispose();
        }
        repaint();
    }

    private void drawPoints(Graphics2D g2) {
        imageCoordinatesHolder.getPoints().keySet().forEach(pos -> drawPoint(g2, pos));
    }

    private void drawPoint(Graphics2D g2, ElementPosition pos) {
        final ColorIndex colorIndex = engine_OLD.getColors().get(pos);
        g2.setColor(getColor(colorIndex));
        final Point p = imageCoordinatesHolder.getPoints().get(pos);
        g2.fillOval(p.x - POINT_RADIUS, p.y - POINT_RADIUS, POINT_RADIUS * 2, POINT_RADIUS * 2);
        g2.setColor(Color.gray);
        g2.drawOval(p.x - POINT_RADIUS, p.y - POINT_RADIUS, POINT_RADIUS * 2, POINT_RADIUS * 2);
    }

    private static Point getCenter() {
        return new Point(MainWindow.WIDTH / 2, MainWindow.HEIGHT / 2);
    }

    @Deprecated
    private static Color getColor(ColorIndex idx) {
        return switch (idx) {
            case C1 -> Color.blue;
            case C2 -> Color.green;
            case C3 -> Color.magenta;
            case C4 -> Color.cyan;
            case C5 -> Color.red;
            case C6 -> Color.yellow;
        };
    }

    private static Color getColor(int idx) {
        return switch (idx) {
            case 0 -> Color.blue;
            case 1 -> Color.green;
            case 2 -> Color.magenta;
            case 3 -> Color.cyan;
            case 4 -> Color.red;
            default -> Color.yellow;
        };
    }

}
