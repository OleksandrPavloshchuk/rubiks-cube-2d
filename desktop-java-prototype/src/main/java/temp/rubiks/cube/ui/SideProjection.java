package temp.rubiks.cube.ui;

import java.awt.*;

public class SideProjection implements Drawable {

    private static final Stroke STROKE = new BasicStroke(1);

    private final int baseRadius;
    private final Point center;

    public SideProjection(Point center, int baseRadius) {
        this.center = center;
        this.baseRadius = baseRadius;
    }

    @Override
    public void draw(Graphics2D g2) {
        drawCircle(g2, center, baseRadius);
    }

    private void drawCircle(Graphics2D g2, Point center, int radius) {
        g2.setColor(Color.darkGray);
        g2.setStroke(STROKE);
        g2.drawOval(center.x - radius, center.y - radius,
                radius * 2, radius * 2);
    }
}
