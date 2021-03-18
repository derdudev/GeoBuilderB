import java.awt.*;

public class GCircle extends GLine{
    public GCircle(GPoint point1, GPoint point2){
        super(point1, point2);
    }

    @Override
    protected void draw(Graphics gr) {
        gr.drawOval(point1.getX()-getRadius(), point1.getY()-getRadius(), getRadius()*2, getRadius()*2);
    }

    private int getRadius(){
        return (int) point1.distanceTo(point2.getX(), point2.getY());
    }
}
