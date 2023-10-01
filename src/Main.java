/**
 * Mark Buster, Final Project (5), Fractal GUI Project, 2023/3/22, CSC143

 * Main Class
 */
public class Main {
    /**
     * Main method
     * @param args normal arguments of a standard main method, String[] args
     */
    public static void main(String[] args) {
       FractalGenerator fg = new FractalGenerator();
       FractalGui gui = new FractalGui(fg);
       FractalDrawing fd = new FractalDrawing(fg);
    }
}