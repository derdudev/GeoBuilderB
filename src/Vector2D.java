public class Vector2D {
    private double x;
    private double y;
    private double length;

    public Vector2D(GPoint point1, GPoint point2){
        x = point2.getX() - point1.getX();
        y = point2.getY() - point1.getY();
        length = getVectorLength();
    }

    private double getVectorLength(){
        double result;
        result = Math.sqrt(x*x + y*y);
        return result;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double getLength() {
        return length;
    }
}
