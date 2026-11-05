package temp.rubiks.cube.single.projections;

import temp.rubiks.cube.single.ui.Drawable;

import java.awt.*;

public record FacetProjection(
        Point leftTopCorner,
        int color,
        int size
) implements Drawable {

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(getColor());
        g2.fillRect(leftTopCorner.x, leftTopCorner.y, size, size);
        // TODO remove trace
        g2.setColor(Color.darkGray);
        g2.drawString("" + color, leftTopCorner.x + 20, leftTopCorner.y + 20);
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
