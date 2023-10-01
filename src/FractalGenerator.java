import java.awt.*;
import java.util.ArrayList;

/**
 * FractalGenerator class that implements Fractal Subject
 */
public class FractalGenerator implements FractalSubject {


    /**
     * global arrayList of FractalElements
     */
    ArrayList<FractalElement> elements;
    /**
     * arrayList of Fractal Observers
     */
    private ArrayList<FractalObserver> observers = new ArrayList<>();
    /**
     * global variable to hold recursionDepth widget value
     */
    private int recursionDepth = 0;
    /**
     * global variable that hold circleOpacity widget value
     */
    private int circleOpacity = 0;
    /**
     * global color to use for GUI assignment to fractals
     */
    private Color color = Color.CYAN;

    /**
     * Positive x bound graphis coordinate
     */
    private final double posXBound = Utility.cartesianXToGraphicsX(250, Utility.getSideLength());
    /**
     * X center graphics coordinate
     */
    private final double xCenter = Utility.cartesianXToGraphicsX(0, Utility.getSideLength());
    /**
     * Negative x bound in graphic coordinates
     */
    private final double negXBound = Utility.cartesianXToGraphicsX(-250, Utility.getSideLength());
    /**
     * Positive y bound graphis coordinate
     */
    private final double posYbound = Utility.cartesianYToGraphicsY(216.50635, (int) Utility.getHeight());
    /**
     * Y center graphics coordinate
     */
    private final double yCenter = Utility.cartesianYToGraphicsY(0, (int) Utility.getHeight());
    /**
     * Negative y bound in graphic coordinates
     */
    private final double negYbound = Utility.cartesianYToGraphicsY(-216.50635, (int) Utility.getHeight());

    /**
     * attach method to add observers
     *
     * @param observer observer as a parameter
     */
    @Override
    public void attach(FractalObserver observer) {
        observers.add(observer);
    }

    /**
     * detach method to remove observers
     *
     * @param observer observer as parameter
     */
    @Override
    public void detach(FractalObserver observer) {
    }

    /**
     * NotifyObservers method to update all observsers when an action happens
     */
    @Override
    public void notifyObservers() {
        for (FractalObserver observer : observers) {
            observer.update();
        }
    }

    /**
     * getData method that feeds another getData method for recursion
     *
     * @return returns an arrayList of fractal elements
     */
    @Override
    public ArrayList<FractalElement> getData() {
        elements = new ArrayList<>();

        //Triangle points
        Point p1 = new Point((int) negXBound, (int) Utility.getHeight());
        Point p2 = new Point(Utility.getSideLength() / 2, (int) posYbound);
        Point p3 = new Point(Utility.getSideLength(), (int) Utility.getHeight());


        //  elements.add(baseTriangle);
        return getData(recursionDepth, elements, p1, p2, p3);
    }

    /**
     * Private getData handles the lazy pull of info to be delivered to observers.
     *
     * @param recursionDepth recursion depth selected in GUI
     * @param elem           arraylist called elem short for elements
     * @param p1             Point 1 passed in from public getData
     * @param p2             Point 2 passed in from public getData
     * @param p3             Point 3 passed in from public getData
     * @return returns the array of fractal elements called elem
     */
    private ArrayList<FractalElement> getData(int recursionDepth, ArrayList<FractalElement> elem, Point p1, Point p2, Point p3) {

        // Midpoints for triangle children
        Point halfwayP1_2 = midPointOf(p1, p2);
        Point halfwayP2_3 = midPointOf(p2, p3);
        Point halfwayP3_1 = midPointOf(p1, p3);
        Point superHalfPoint = midPointOf(halfwayP1_2, halfwayP2_3);

        //Circle Math
        int xcircleCenter = (((Utility.getSideLength()) * p1.x) + ((Utility.getSideLength()) * p2.x) +
                ((Utility.getSideLength()) * p3.x)) / (Utility.getSideLength() * 3);
        int ycircleCenter = (((Utility.getSideLength()) * p1.y) + ((Utility.getSideLength()) * p2.y) +
                ((Utility.getSideLength()) * p3.y)) / (Utility.getSideLength() * 3);


        double circleRadius = Math.sqrt(Math.pow(xcircleCenter - superHalfPoint.x, 2) +
                Math.pow(ycircleCenter - superHalfPoint.y, 2)) * 2;

        // Fractal shapes
        Triangle recursedTriangle = new Triangle(p1, p2, p3, this.color, circleOpacity);
        Circle recusredCircle = new Circle((int) xCenter, (int) yCenter, Color.green, (int) circleRadius);

        // add Shapes to arrayList
        elem.add(recursedTriangle);
        elem.add(recusredCircle);

        //recursion of fractals
        if (recursionDepth > 0) {
            getData(recursionDepth - 1, elem, p1, halfwayP1_2, halfwayP3_1);
            getData(recursionDepth - 1, elem, halfwayP1_2, p2, halfwayP2_3);
            getData(recursionDepth - 1, elem, halfwayP3_1, halfwayP2_3, p3);

        }
        return elem;
    }

    /**
     * Helper method to find new triangle bounds using midpoints of larger triangle
     *
     * @param p1 original point 1
     * @param p2 original point 2
     * @return New midpoint to act as triangle bound
     */
    public static Point midPointOf(Point p1, Point p2) {
        Point midpoint = new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
        return midpoint;
    }

    /**
     * setData= method that sends actions from all the widgets to the notifyObservers method.
     */
    @Override
    public void setData(int recursionDepth, int circleOpacity, Color color) {
        this.recursionDepth = recursionDepth;
        this.circleOpacity = circleOpacity;
        this.color = color;
        notifyObservers();
    }
}

