import java.awt.*;
import java.util.ArrayList;

public class GPolygon extends GeoObject{
    private ArrayList<GLine> lines = new ArrayList<GLine>();

    public GPolygon(ArrayList<GPoint> points){
        int i=0;
        for(GPoint p: points){
            if(!(i >= points.size()-1)){
                lines.add(new GLine(points.get(i), points.get(i+1)));
            } else {
                lines.add(new GLine(points.get(i), points.get(0)));
            }
            i++;
        }
    }

    @Override
    protected void draw(Graphics gr) {
        for(GLine line: lines){
            line.draw(gr);
        }
    }
}
