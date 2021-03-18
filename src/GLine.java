import java.awt.*;

public class GLine extends GeoObject{

    protected GPoint point1;
    protected GPoint point2;

    // public GLine(){super();}

    public GLine(GPoint point1, GPoint point2){
        super();
        this.point1 = point1;
        this.point2 = point2;
    }

    @Override
    protected void draw(Graphics gr) {
        gr.drawLine(point1.getX(), point1.getY(), point2.getX(), point2.getY());
    }
}
