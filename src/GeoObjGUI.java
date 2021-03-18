import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Grafische Benutzeroberfläche
 * für geometrische Objekte;
 * verwaltet das Anwendungsfenster
 * und Mausklicks auf die Buttons.
 *
 * @version 1.1 vom 20.07.2012
 * @author Tom Schaller, Roland Mechling
 */

public class GeoObjGUI extends JFrame {
    // Anfang Attribute
    private Board board1 = new Board();
    private JButton jBCircle = new JButton();
    private JButton jBRect = new JButton();
    private JButton jBLine = new JButton();
    private JButton jBPolygone = new JButton();
    private JButton jBDelete = new JButton();
    private JButton jBColour = new JButton();
    // Ende Attribute

    public GeoObjGUI(String title) {
        // Frame-Initialisierung
        super(title);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 672;
        int frameHeight = 455;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);
        // Anfang Komponenten

        board1.setBounds(8, 0, 537, 425);
        board1.setBackground(Color.WHITE);
        cp.add(board1);
        jBCircle.setBounds(552, 64, 99, 25);
        jBCircle.setText("Kreis");
        jBCircle.setBackground(Color.WHITE);
        jBCircle.setFont(new Font("Roboto Mono", Font.PLAIN, 12));
        jBCircle.setMargin(new Insets(2, 2, 2, 2));
        jBCircle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jBCircle_ActionPerformed(evt);
            }
        });
        cp.add(jBCircle);
        jBRect.setBounds(552, 104, 99, 25);
        jBRect.setText("Rechteck");
        jBRect.setMargin(new Insets(2, 2, 2, 2));
        jBRect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jBRect_ActionPerformed(evt);
            }
        });
        cp.add(jBRect);
        jBLine.setBounds(552, 24, 99, 25);
        jBLine.setText("Strecke");
        jBLine.setMargin(new Insets(2, 2, 2, 2));
        jBLine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jBLine_ActionPerformed(evt);
            }
        });
        cp.add(jBLine);
        jBPolygone.setBounds(552, 144, 99, 25);
        jBPolygone.setText("Polygon");
        jBPolygone.setMargin(new Insets(2, 2, 2, 2));
        jBPolygone.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jBPolygone_ActionPerformed(evt);
            }
        });
        cp.add(jBPolygone);
        jBDelete.setBounds(553, 293, 96, 34);
        jBDelete.setText("Objekt löschen");
        jBDelete.setMargin(new Insets(2, 2, 2, 2));
        jBDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jBDelete_ActionPerformed(evt);
            }
        });
        jBDelete.setFont(new Font("Dialog", Font.BOLD, 12));
        cp.add(jBDelete);
        jBColour.setBounds(552, 248, 97, 33);
        jBColour.setText("Objekt färben");
        jBColour.setMargin(new Insets(2, 2, 2, 2));
        jBColour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jBColour_ActionPerformed(evt);
            }
        });
        cp.add(jBColour);
        setTitle("Geometrische Objekte");
        // Ende Komponenten

        setVisible(true);
    } // end of public GeoObjGUI

    // Anfang Methoden

    public void jBCircle_ActionPerformed(ActionEvent evt) {
        board1.addNewCircle();
    } // end of jBCircle_ActionPerformed

    public void jBRect_ActionPerformed(ActionEvent evt) {
        board1.addNewRect();
    } // end of jBRect_ActionPerformed

    public void jBLine_ActionPerformed(ActionEvent evt) {
        board1.addNewLine();
    } // end of jBLine_ActionPerformed

    public void jBPolygone_ActionPerformed(ActionEvent evt) {
        board1.addNewPolygon();
    } // end of jBPolygone_ActionPerformed

    public void jBDelete_ActionPerformed(ActionEvent evt) {
        board1.deleteObj();
    } // end of jBDelete_ActionPerformed

    public void jBColour_ActionPerformed(ActionEvent evt) {
        if (board1.getSelPtsCount() > 0) {
            Color newCol = JColorChooser.showDialog(this, "Wähle Farbe", Color.BLACK);
            board1.setObjColor(newCol);
        } // end of if
    } // end of jBColour_ActionPerformed


    // Ende Methoden

    public static void main(String[] args) {
        new GeoObjGUI("GeoObjGUI");
    } // end of main

} // end of class DrawItGUI

