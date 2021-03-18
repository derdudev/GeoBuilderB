import java.awt.*;

public abstract class GeoObject {
    protected Color color;

    public GeoObject(){
        super();
        this.color = new Color(0, 0, 0);
    }

    protected abstract void draw(Graphics gr);
}
