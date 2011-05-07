
import java.awt.*;


public class ComponentStub extends Component {

	static final long serialVersionUID = 1;
    int x;
    int y;
    Dimension dim;
    Point point;

    /** Creates a ComponentStub instance and initializes it */
    public ComponentStub(int xLoc, int yLoc, int width, int height) {
    	this.x = xLoc;
    	this.y = yLoc;
    	this.dim = new Dimension(width, height);
    	point = new Point(xLoc, yLoc);
    	this.setLocation(point);
    	this.setSize(dim);
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
   
    