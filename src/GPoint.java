/**
 *
 * Description
 *
 * @version 1.0 from 03/03/2021
 * @author
 */
import java.awt.Color;
import java.awt.Graphics;

public class GPoint {

    // start attributes
    private int x;
    private int y;
    private Color color;
    private final Color DEFAULT_COLOR = Color.BLACK;
    // end attributes

    public GPoint(int x, int y) {
        this.x = x;
        this.y = y;
        this.color = DEFAULT_COLOR;
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

    public void setColor(Color colorNew) {
        color = colorNew;
    }

    public void draw(Graphics gr) {
        // TODO add your code here
        gr.setColor(this.getColor());
        gr.drawRect(x-2,y-2,5,5);
    }

    public double distanceTo(int mx, int my){
        double dx, dy, d;
        dx = (double) mx - this.x;
        dy = (double) my - this.y;
        d = Math.sqrt(dx * dx + dy * dy);
        return d;
    }

    // end methods
} // end of GPoint
