package temp.rubiks.cube.ui;

import temp.rubiks.cube.model.Engine;

import java.awt.*;

public class SideProjection implements Drawable {

    private static final Stroke STROKE = new BasicStroke(1);

    private final Point center;
    private final Point textPoint;
    private final String label;

    private final ImageCoordinatesHolder coordinatesHolder;

    public SideProjection(String label, Point center, Point textPoint, ImageCoordinatesHolder coordinatesHolder) {
        this.label = label;
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
            if (i!=1) {
                int r = coordinatesHolder.getRadius() - i * coordinatesHolder.getRadiusStep();
                g2.drawOval(center.x - r, center.y - r, r * 2, r * 2);
            }
        }

        g2.drawString( label, textPoint.x, textPoint.y);
    }
}
