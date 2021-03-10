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
    private ArrayList<GPoint> geoObjects = new ArrayList<GPoint>();
    private GPoint dragPoint = null;
    // Ende Attribute

    // Konstruktor
    public Board() {
        super();
        addMouseListener(this);
        addMouseMotionListener(this);

        GPoint p = new GPoint(150, 100);
        geoObjects.add(p);
        p = new GPoint(130, 110);
        geoObjects.add(p);
        p = new GPoint(110, 120);
        geoObjects.add(p);
        p = new GPoint( 90, 130);
        geoObjects.add(p);
    }

    // MouseListener

    public void mousePressed(MouseEvent e) {
        geoObjects.add(new GPoint(e.getX(), e.getY()));
        if(dragPoint == null) {
            for (GPoint p : geoObjects) {
                if (p.distanceTo(e.getX(), e.getY()) < 4) {
                    this.dragPoint = p;
                } else {
                    this.dragPoint = null;
                }
            }
        }
    }

    public void mouseReleased(MouseEvent e) {
        this.geoObjects.add(new GPoint(e.getX(), e.getY()));
        this.repaint();
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

    public void addNewLine() {  }

    public void addNewPolygon() {  }

    public void setObjColor(Color newCol) {  }

    public void deleteObj() {  }

    public void paint(Graphics g) {
        super.paint(g);
        BasicStroke stroke2 = new BasicStroke(2.0f, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER);
        ((Graphics2D) g).setStroke(stroke2);
        for (GPoint p : geoObjects ) {
            p.draw(g);
        } // end of for
    }
    // Ende Methoden

} // end of Board
