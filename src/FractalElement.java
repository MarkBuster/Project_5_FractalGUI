import java.awt.*;

/**
 * Fractal element that can draw itself
 */
public interface FractalElement{
        /**
         *Draw method with parameter
         * @param g graphics parameter
         */
        public void draw(Graphics g);

        /**
         * draw method without parameter
         */
        void draw();
}

