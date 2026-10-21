package temp.rubiks.cube.ui;

import java.awt.*;

public class SideProjection implements Drawable {

    private static final int COUNT = 1;
    private static final int STEP = 30;
    private static final Stroke STROKE = new BasicStroke(1);

    private final int baseRadius;
    private final Point center;
    private final Point textPoint;
    private final int index;

    public SideProjection(int index, Point center, Point textPoint, int baseRadius) {
        this.index = index;
        this.center = center;
        this.textPoint = textPoint;
        this.baseRadius = baseRadius;
    }

    @Override
    public void draw(Graphics2D g2) {
        drawCircle(g2, center, baseRadius);
    }

    private void drawCircle(Graphics2D g2, Point center, int radius) {
        g2.setColor(Color.lightGray);
        g2.setStroke(STROKE);

        for( int i=0; i<COUNT; i++ ) {
            int r = radius - i * STEP;
            g2.drawOval(center.x - r, center.y - r, r * 2, r * 2);
        }

        g2.drawString( Integer.toString(index), textPoint.x, textPoint.y);
    }
}
