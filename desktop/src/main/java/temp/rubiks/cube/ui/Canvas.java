package temp.rubiks.cube.ui;

import temp.rubiks.cube.engine.model.Assembly;
import temp.rubiks.cube.engine.rotators.AssemblyRotator;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Canvas extends JPanel {

    private final int RADIUS = 210;
    private final int RADIUS_STEP = 35;
    private final int POINT_RADIUS = 12;

    private BufferedImage image;

    private final CoordinatesHolder coordinatesHolder =
            new CoordinatesHolder(getCenter(), RADIUS, RADIUS_STEP);

    private final Assembly assembly = new Assembly();

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
        coordinatesHolder.projectAssembly(assembly);

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
        coordinatesHolder.getPoints().keySet().forEach(f -> drawPoint(g2, f));
    }

    private void drawPoint(Graphics2D g2, CoordinatesHolder.CubeFacet f) {
        g2.setColor(getColor(f.facet()));
        final Point p = coordinatesHolder.getPoints().get(f);
        g2.fillOval(p.x - POINT_RADIUS, p.y - POINT_RADIUS, POINT_RADIUS * 2, POINT_RADIUS * 2);
        g2.setColor(Color.gray);
        g2.drawOval(p.x - POINT_RADIUS, p.y - POINT_RADIUS, POINT_RADIUS * 2, POINT_RADIUS * 2);

        // TODO remove trace
        g2.setColor(Color.black);
        final String str = "" + f.x() + "," + f.y() + "," + f.z();
        g2.drawString(str, p.x, p.y );
    }

    private static Point getCenter() {
        return new Point(MainWindow.WIDTH / 2, MainWindow.HEIGHT / 2 - 60);
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
