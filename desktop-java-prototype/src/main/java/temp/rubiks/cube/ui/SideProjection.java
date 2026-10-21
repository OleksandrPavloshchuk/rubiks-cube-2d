package temp.rubiks.cube.ui;

import java.awt.*;

public class SideProjection implements Drawable {

    private static final Stroke STROKE = new BasicStroke(1);

    private final Point center;
    private final Point textPoint;
    private final int index;

    private ImageCoordinatesHolder coordinatesHolder;

    public SideProjection(int index, Point center, Point textPoint, ImageCoordinatesHolder coordinatesHolder) {
        this.index = index;
        this.center = center;
        this.textPoint = textPoint;
        this.coordinatesHolder = coordinatesHolder;
    }

    @Override
    public void draw(Graphics2D g2) {
        drawCircle(g2);
    }

    private void drawCircle(Graphics2D g2) {
        g2.setColor(Color.lightGray);
        g2.setStroke(STROKE);

        for( int i=0; i<ImageCoordinatesHolder.STEPS; i++ ) {
            int r = coordinatesHolder.getRadius() - i * coordinatesHolder.getRadiusStep();
            g2.drawOval(center.x - r, center.y - r, r * 2, r * 2);
        }

        g2.drawString( Integer.toString(index), textPoint.x, textPoint.y);
    }
}
