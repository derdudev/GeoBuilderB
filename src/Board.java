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

        GeoObject p = new GPoint(150, 100);
        geoObjects.add(p);
        p = new GPoint(130, 110);
        geoObjects.add(p);
        p = new GPoint(110, 120);
        geoObjects.add(p);
        p = new GPoint( 90, 130);
        geoObjects.add(p);
        p = new GLine((GPoint) geoObjects.get(0), (GPoint) geoObjects.get(1));
        geoObjects.add(p);
        this.repaint();
        // System.out.println(geoObjects.get(0));
        // System.out.println(System.getProperty("user.dir"));
    }

    // MouseListener

    public void mousePressed(MouseEvent e) {
        System.out.println(geoObjects.size());
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
            this.geoObjects.add(new GPoint(e.getX(), e.getY()));
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

    public void mouseReleased(MouseEvent e) {
        //if(dragPoint != null) this.dragPoint.setSelected(false);
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
            geoObjects.add(dragPoint);
            repaint();
        }
    }

    // Anfang Methoden

    public int getSelPtsCount() {
        return 0;
    }
    public void addNewCircle() {  }

    public void addNewRect() {  }

    public void addNewLine() {
        if(this.selectedPoints.size() <= 2){
            this.geoObjects.add(new GLine(this.selectedPoints.get(0), this.selectedPoints.get(1)));
            resetSelectedPoints();
            this.selectedPoints.clear();
            repaint();
        }
    }

    private void resetSelectedPoints(){
        for(GeoObject go: geoObjects){
            if(go instanceof GPoint){
                ((GPoint) go).setSelected(false);
            }
        }
    }

    public void addNewPolygon() {  }

    public void setObjColor(Color newCol) {  }

    public void deleteObj() {  }

    public void paint(Graphics g) {
        super.paint(g);
        BasicStroke stroke2 = new BasicStroke(2.0f, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER);
        ((Graphics2D) g).setStroke(stroke2);
        for (GeoObject p : geoObjects ) {
            p.draw(g);
        } // end of for
    }
    // Ende Methoden

} // end of Board
