import java.awt.*;



public record Triangle(Point Point1, Point Point2, Point Point3, Color colorParam, int circleOpacity) implements FractalElement {


    @Override
    public void draw(Graphics g) {

        Polygon triangle = new Polygon();
        triangle.addPoint(Point1.x,Point1.y);
        triangle.addPoint(Point2.x,Point2.y);
        triangle.addPoint(Point3.x,Point3.y);
        g.setColor(colorParam);

        g.drawPolygon(triangle);
    }


    /**
     * draw method for triangle with no parameters
     */
    @Override
    public void draw() {

    }
}
