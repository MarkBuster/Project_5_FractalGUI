import java.awt.*;

/**
 * Circle record
 * @param xCenter   x-coordinate
 * @param yCenter   y-coordinate
 * @param color     color from color picker
 * @param radius    radius measurement of circle
 */
public record Circle(int xCenter, int yCenter, Color color, int radius) implements FractalElement{

    /**
     * draw method for circle
     * @param g graphics parameter
     */
    @Override
    public void draw(Graphics g) {

        g.setColor(color);
        g.drawOval(xCenter - (radius / 2),yCenter + (radius/2), radius, radius) ;
    }

    /**
     * draw method with now params
     */
    @Override
    public void draw() {
    }
}
