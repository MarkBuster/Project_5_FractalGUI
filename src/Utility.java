/**
 * Utility class used for referencing fractal height and width
 */
public class Utility {
    /**
     * width global variable
     */
    private static int sideLength = 500;
    /**
     * height global variable
     * 1.04719755 is the radian value for 60 degrees
     */
    private static double height = 500 * Math.sin(1.04719755);

    /**
     * get width method
     * @return returns width
     */
    public static int getSideLength(){
    return sideLength;
}
    /**
     * get height method
     * @return returns height
     */
    public static double getHeight(){
    return height;
    }

    /**
     * Converting cartesian coordinates to graphics coordinates
     * @param cartesianX    Takes in a cartesian style coordinate
     * @param drawAreaWidth width of fractals
     * @return  returns a graphics coordinate
     */
    public static double cartesianXToGraphicsX(double cartesianX, int drawAreaWidth) {
        double graphicsX = cartesianX + (drawAreaWidth/2);
        return graphicsX;
    }

    /**
     * Converting cartesian coordinates to graphics coordinates
     * @param cartesianY    Takes in a cartesian style coordinate
     * @param drawAreaheight height of fractals
     * @return  returns a graphics coordinate
     */
    public static double cartesianYToGraphicsY(double cartesianY, int drawAreaheight) {
        double graphicsY = (drawAreaheight /2) - cartesianY;
        return graphicsY;
    }
}
