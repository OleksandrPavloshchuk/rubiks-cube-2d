package temp.rubiks.cube.single.ui;

import java.awt.*;

public record FacetDrawer(Point center, int color) implements Drawable {
    private static final int POINT_RADIUS = 14;

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(getColor());

        final Polygon p = new Polygon(
                new int[] {
                        center.x - POINT_RADIUS,
                        center.x + POINT_RADIUS,
                        center.x + POINT_RADIUS,
                        center.x - POINT_RADIUS
                },
                new int[] {
                        center.y - POINT_RADIUS,
                        center.y - POINT_RADIUS,
                        center.y + POINT_RADIUS,
                        center.y + POINT_RADIUS
                },
            4
        );

        g2.fillPolygon(p);
        //g2.setColor(Color.darkGray);
        //g2.setStroke(new BasicStroke(1));
        //g2.drawPolygon(p);
        g2.setColor(Color.black);
        g2.drawString("" + this.color, center.x - POINT_RADIUS, center.y - POINT_RADIUS);
    }

    private Color getColor() {
        return switch (color) {
            case 0 -> new Color(255, 128, 128);
            case 1 -> new Color(128, 255, 128);
            case 2 -> new Color(128, 128, 255);
            case 3 -> new Color(255, 255, 200);
            case 4 -> new Color(200, 255, 255);
            default -> new Color(255, 200, 255);
        };
    }

}
