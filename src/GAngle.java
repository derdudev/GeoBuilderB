import java.awt.*;

public class GAngle extends GeoObject{
    private Vector2D vector1;
    private Vector2D vector2;
    private GPoint pointO;
    private GPoint pointB;

    public GAngle(GPoint point1, GPoint point2, GPoint point3){
        this.vector1 = new Vector2D(point2, point1);
        this.vector2 = new Vector2D(point2, point3);
        pointO = point2;
        pointB = point3;
    }

    // formula: https://onlinemschool.com/math/library/vector/angl/
    public double getAngle(){
        double result, dotProduct, vectorLength;
        dotProduct = dotProduct(vector1, vector2);
        vectorLength = vector1.getLength() * vector2.getLength();
        result = (Math.acos((dotProduct / vectorLength))/(2*Math.PI))*360;
        return result;
    }

    private double getStartAngle(){
        GPoint pointD = new GPoint(pointB.getX(), pointO.getY());
        Vector2D vectorBD = new Vector2D(pointB, pointD);
        Vector2D vectorAD = new Vector2D(pointO, pointD);
        double result;
        result = Math.atan(((vectorBD.getLength()/vectorAD.getLength()))/(2*Math.PI))*360; // TODO: not working
        return result;
    }

    public double dotProduct(Vector2D vector1, Vector2D vector2){
        double result;
        result = vector1.getX() * vector2.getX() + vector1.getY() * vector2.getY();
        return result;
    }

    @Override
    protected void draw(Graphics gr) {
        System.out.println(getAngle());
        gr.drawString(String.valueOf(Math.round(getAngle())), pointO.getX()-10,  pointO.getY()-10);
        gr.drawArc(pointO.getX()-20,  pointO.getY()-20, 40, 40, (int) Math.round(getStartAngle()), (int) Math.round(getAngle()));
    }
}
