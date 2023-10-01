import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Fractal drawing class, extends JFrame, Implements FractalObserver
 */
public class FractalDrawing extends JFrame implements FractalObserver{
    /**
     * global fractal subject variable
     */
    FractalSubject subject;
    /**
     * arrayList of Fractal elements
     */
    ArrayList<FractalElement> elements;


    /**
     *Fractal drawing constructor
     * @param subject subject to the observer
     */
    public FractalDrawing(FractalSubject subject) {
        subject.attach(this);
        this.subject = subject;
        setSize(520,500);
        setBackground(Color.BLACK);

    }

    /**
     * Update method that updates all the observers
     */
    @Override
    public void update() {
        System.out.println("FD: I got an update");
        elements = subject.getData();
        System.out.println("FD: I got the data");

        DrawPanel dp = new DrawPanel();
        getContentPane().add(dp);
        dp.repaint();// Pretty please call paint component
        setVisible(true);
    }


    /**
     * DrawPanel inner class that hosts the ability(paintComponent) to draw the fractals
     */
    private class DrawPanel extends JPanel{
        /**
         * paintComponent to enable drawings
         * @param g the <code>Graphics</code> object to protect
         */
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.fillRect(0,0,520,500);

           // if()
            for (int i = 0; i < elements.size(); i++) {
                elements.get(i).draw(g);
            }
        }
    }
}
