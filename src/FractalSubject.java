import java.awt.*;
import java.util.ArrayList;

/**
 *Interface declaration
 */
public interface FractalSubject{
 /**
  * Attach method
  * @param observer observer as a parameter
  */
 public void attach(FractalObserver observer);

 /**
  * detach method
  * @param observer observer as parameter
  */
 public void detach(FractalObserver observer);

 /**
  * Notify observers method
  */
 public void notifyObservers();

 /**
  * getData method is the most complicated of the program
  * @return returns an arrayList of fractal elements
  */
 public ArrayList<FractalElement> getData();


 /**
  * setData method that is used to communicate widget actions
  * @param recursionDepth    recursion depth int value
  * @param circleOpacity     circle opacity int value
  * @param color             color Color value
  */
 void setData(int recursionDepth, int circleOpacity, Color color);
}
