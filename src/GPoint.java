/**
 *
 * Description
 *
 * @version 1.0 from 03/03/2021
 * @author
 */
import java.awt.Color;
import java.awt.Graphics;

public class GPoint extends GeoObject{

    // start attributes
    private int x;
    private int y;
    private final Color DEFAULT_COLOR = Color.BLACK;
    private boolean selected;
    // end attributes

    public GPoint(int x, int y) {
        super();
        this.x = x;
        this.y = y;
        this.color = DEFAULT_COLOR;
        this.selected = false;
    }

    // start methods
    public int getX() {
        return x;
    }

    public void setX(int xNew) {
        x = xNew;
    }

    public int getY() {
        return y;
    }

    public void setY(int yNew) {
        y = yNew;
    }

    public Color getColor() {
        return color;
    }

    public void setXY(int xnew, int ynew){
        this.setX(xnew);
        this.setY(ynew);
    }

    public void setColor(Color colorNew) {
        color = colorNew;
    }

    public void draw(Graphics gr) {
        // TODO add your code here
        gr.setColor(this.getColor());
        if(!this.selected){
            gr.drawRect(x-2,y-2,1,1);
        } else {
            gr.fillRect(x-2,y-2,5,5);
        }
    }

    public double distanceTo(int mx, int my){
        double dx, dy, d;
        dx = (double) mx - this.x;
        dy = (double) my - this.y;
        d = Math.sqrt(dx * dx + dy * dy);
        return d;
    }
    public double abstandZu(int mx, int my){
        double dx, dy, d;
        dx = (double) mx - this.x;
        dy = (double) my - this.y;
        d = Math.sqrt(dx * dx + dy * dy);
        return d;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean hasSameXY(GPoint point){
        return ((x == point.getX()) && (y == point.getY()));
    }

    public boolean hasSameXY(int x, int y){
        return ((this.x == x) && (this.y == y));
    }

    // end methods
} // end of GPoint
