/**
 * Zeichenfläche für geometrische Objekte;
 * verwaltet sowohl die Objektliste als
 * auch die Liste der selektierten Objekte
 * sowie die Reaktionen auf Mausklicks und
 * -bewegungen im Zeichenbereich.
 *
 * @version 1.1 vom 21.07.2012
 * @author Tom Schaller, Roland Mechling
 */
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class Board extends JPanel implements MouseListener, MouseMotionListener {

    // Anfang Attribute
    private ArrayList<GeoObject> geoObjects = new ArrayList<GeoObject>();
    private GPoint dragPoint = null;
    private ArrayList<GPoint> selectedPoints = new ArrayList<GPoint>();
    // Ende Attribute

    // Konstruktor
    public Board() {
        super();
        addMouseListener(this);
        addMouseMotionListener(this);
        drawSinWave();
    }

    public void drawSinWave(){
        double x, y;
        int width = 550;
        for(double i=0; i<width; i=i+0.01){
            x = i;
            y = (int) (Math.round((Math.sin(x*0.1) * 40)) * (-1)) + 200;
            GPoint point = new GPoint((int) Math.round(x), (int) Math.round(y));
            geoObjects.add(point);
        }
        repaint();
    }

    // MouseListener

    public void mousePressed(MouseEvent e) {
        dragPoint = null;
        for (GeoObject go : geoObjects) {
            if(go instanceof GPoint){
                GPoint point = (GPoint) go;
                double distance = point.distanceTo(e.getX(), e.getY());
                if (distance < 5) {
                    this.dragPoint = point;
                }
            }
        }
        if(dragPoint == null) {
            if(!doesPointWithCoordsExist(e.getX(), e.getY())){
                this.geoObjects.add(new GPoint(e.getX(), e.getY()));
            }
        } else {
            if((e.getModifiersEx() & e.SHIFT_DOWN_MASK) > 0){
                if(this.dragPoint.isSelected()){
                    this.dragPoint.setSelected(false);
                    selectedPoints.remove(this.dragPoint);
                } else {
                    this.dragPoint.setSelected(true);
                    selectedPoints.add(this.dragPoint);
                }
            }
        }
        this.repaint();
    }

    private boolean doesPointExist(GPoint point){
        for(GeoObject go: geoObjects){
            if(go instanceof GPoint){
                if(((GPoint) go).hasSameXY(point)) return true;
            }
        }
        return false;
    }

    private boolean doesPointWithCoordsExist(int x, int y){
        for(GeoObject go: geoObjects){
            if(go instanceof GPoint){
                if(((GPoint) go).hasSameXY(x, y)) return true;
            }
        }
        return false;
    }

    public void mouseReleased(MouseEvent e) {
        dragPoint = null;
    }

    public void mouseEntered(MouseEvent e) { }

    public void mouseExited(MouseEvent e) { }

    public void mouseClicked(MouseEvent e) { }


    // MouseMotionListener

    public void mouseMoved(MouseEvent e) {  }

    public void mouseDragged(MouseEvent e) {
        if(dragPoint != null) {
            dragPoint.setXY(e.getX(), e.getY());
            repaint();
        }
    }

    // Anfang Methoden

    public int getSelPtsCount() {
        return 0;
    }
    public void addNewCircle() {
        if(this.selectedPoints.size() == 2){
            this.geoObjects.add(new GCircle(this.selectedPoints.get(0), this.selectedPoints.get(1)));
            resetSelectedPoints();
            repaint();
        }
    }

    public void addNewRect() {
        if(this.selectedPoints.size() == 2){
            this.geoObjects.add(new GRectangle(this.selectedPoints.get(0), this.selectedPoints.get(1)));
            resetSelectedPoints();
            repaint();
        }
    }

    public void addNewLine() {
        if(this.selectedPoints.size() == 2){
            this.geoObjects.add(new GLine(this.selectedPoints.get(0), this.selectedPoints.get(1)));
            resetSelectedPoints();
            repaint();
        }
    }

    private void resetSelectedPoints(){
        for(GeoObject go: geoObjects){
            if(go instanceof GPoint){
                ((GPoint) go).setSelected(false);
                this.selectedPoints.clear();
            }
        }
    }

    public void addNewPolygon() {
        if(this.selectedPoints.size() >= 3){
            this.geoObjects.add(new GPolygon(this.selectedPoints));
            resetSelectedPoints();
            repaint();
        }
    }

    public void addNewAngle(){
        if(this.selectedPoints.size() == 3){
            this.geoObjects.add(new GAngle(this.selectedPoints.get(0), this.selectedPoints.get(1), this.selectedPoints.get(2)));
            resetSelectedPoints();
            repaint();
        }
    }

    public void setObjColor(Color newCol) {  }

    public void deleteObj() {  }

    public void paint(Graphics g) {
        super.paint(g);
        BasicStroke stroke2 = new BasicStroke(2.0f, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER);
        ((Graphics2D) g).setStroke(stroke2);
        for (GeoObject go : geoObjects ) {
            go.draw(g);
        } // end of for
    }
    // Ende Methoden

} // end of Board
