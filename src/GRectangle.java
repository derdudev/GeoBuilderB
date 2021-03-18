import java.awt.*;

public class GRectangle extends GLine{
    public GRectangle(GPoint point1, GPoint point2){
        super(point1, point2);
    }

    @Override
    protected void draw(Graphics gr) {
        int height, width, x, y;
        height = point2.getY() - point1.getY();
        width = point2.getX() - point1.getX();
        x = point1.getX();
        y = point1.getY();
        if(height < 0){
            y = point2.getY();
            x = point1.getX();
        }
        if(width < 0){
            x = point2.getX();
            y = point1.getY();
        }
        if((width < 0) && (height < 0)){
            x = point2.getX();
            y = point2.getY();
        }

        gr.drawRect(x, y, Math.abs(width), Math.abs(height));
    }
}
