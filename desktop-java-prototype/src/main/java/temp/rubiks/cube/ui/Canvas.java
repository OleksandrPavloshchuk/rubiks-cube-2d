package temp.rubiks.cube.ui;

import temp.rubiks.cube.model.ColorIndex;
import temp.rubiks.cube.model.ElementPosition;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Canvas extends JPanel {

    private final int RADIUS = 240;
    private final int RADIUS_STEP = 25;
    private final int POINT_RADIUS = 10;

    private BufferedImage image;

    private final ImageCoordinatesHolder imageCoordinatesHolder =
            new ImageCoordinatesHolder(getCenter(), RADIUS, RADIUS_STEP);

    private final Drawable projection = new CubeProjection(RADIUS, imageCoordinatesHolder);

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
            g2.setColor(Color.white);
            g2.fillRect(0, 0, image.getWidth(), image.getHeight());

            projection.draw(g2);

            drawPoints(g2);

        } finally {
            g2.dispose();
        }

    }

    private void drawPoints(Graphics2D g2) {
        imageCoordinatesHolder.getPoints().keySet().forEach(pos -> drawPoint(g2, pos));
    }

    private void drawPoint(Graphics2D g2, ElementPosition pos) {
        final ColorIndex colorIndex = imageCoordinatesHolder.getColors().get(pos);
        g2.setColor(getColor(colorIndex));
        final Point p = imageCoordinatesHolder.getPoints().get(pos);
        g2.fillOval(p.x - POINT_RADIUS, p.y - POINT_RADIUS, POINT_RADIUS * 2, POINT_RADIUS * 2);
    }

    private static Point getCenter() {
        return new Point(MainWindow.WIDTH / 2, MainWindow.HEIGHT / 2);
    }

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


}
