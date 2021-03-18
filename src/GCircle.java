import java.awt.*;

public class GCircle extends GLine{
    public GCircle(GPoint point1, GPoint point2){
        super(point1, point2);
    }

    @Override
    protected void draw(Graphics gr) {

    }

    private int getRadius(){
        return 1;
    }
}
