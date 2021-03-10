public class Testen_GPoint {
    private GPoint p;
    private int x, y;

    public Testen_GPoint(){
        this.x = 2;
        this.y = 2;
        p = new GPoint(x, y);
    }

    public void test() throws Exception {
        if(!(p.abstandZu(4, 4) == this.distanceTo(4, 4))) throw new Exception();
    }

    public double distanceTo(int mx, int my){
        double dx, dy, d;
        dx = (double) mx - this.x;
        dy = (double) my - this.y;
        d = Math.sqrt(dx * dx + dy * dy);
        return d;
    }
}
