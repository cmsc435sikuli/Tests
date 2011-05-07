
import java.awt.*;
import javax.swing.*;


public class JRadioButtonMenuItemStub extends JRadioButtonMenuItem {

	static final long serialVersionUID = 1;
    int x;
    int y;
    Dimension dim;
    Point point;
    boolean isSelected;

    /** Creates a JRadioButtonMenuItem instance and initializes it */
    public JRadioButtonMenuItemStub(int xLoc, int yLoc, int width, int height) {
    	this.x = xLoc;
    	this.y = yLoc;
    	this.dim = new Dimension(width, height);
    	point = new Point(xLoc, yLoc);
    }
    
    public Dimension getSize(){
    	return dim;
    }
    
    public Point getLocationOnScreen(){
    	return point;
    }
    
    public int getX(){
    	return x;
    }
    
    public int getY(){
    	return y;
    }
    
}
   
    