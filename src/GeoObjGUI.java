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
    private JButton jBAngle = new JButton();
    private JButton jBDelete = new JButton();
    private JButton jBColour = new JButton();
    // Ende Attribute

    private final int BUTTON_WIDTH = 120;

    public GeoObjGUI(String title) {
        // Frame-Initialisierung
        super(title);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 693;
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
        jBCircle.setBounds(552, 64, BUTTON_WIDTH, 25);
        jBCircle.setText("Kreis");
        jBCircle.setBackground(Color.WHITE);
        jBCircle.setFont(new Font("Roboto Mono", Font.PLAIN, 12));
        jBCircle.setFocusPainted(false);
        jBCircle.setMargin(new Insets(2, 2, 2, 2));
        jBCircle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jBCircle_ActionPerformed(evt);
            }
        });
        cp.add(jBCircle);
        jBRect.setBounds(552, 104, BUTTON_WIDTH, 25);
        jBRect.setText("Rechteck");
        jBRect.setBackground(Color.WHITE);
        jBRect.setFont(new Font("Roboto Mono", Font.PLAIN, 12));
        jBRect.setFocusPainted(false);
        jBRect.setMargin(new Insets(2, 2, 2, 2));
        jBRect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jBRect_ActionPerformed(evt);
            }
        });
        cp.add(jBRect);
        jBLine.setBounds(552, 24, BUTTON_WIDTH, 25);
        jBLine.setText("Strecke");
        jBLine.setBackground(Color.WHITE);
        jBLine.setFont(new Font("Roboto Mono", Font.PLAIN, 12));
        jBLine.setFocusPainted(false);
        jBLine.setMargin(new Insets(2, 2, 2, 2));
        jBLine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jBLine_ActionPerformed(evt);
            }
        });
        cp.add(jBLine);
        jBPolygone.setBounds(552, 144, BUTTON_WIDTH, 25);
        jBPolygone.setText("Polygon");
        jBPolygone.setBackground(Color.WHITE);
        jBPolygone.setFont(new Font("Roboto Mono", Font.PLAIN, 12));
        jBPolygone.setFocusPainted(false);
        jBPolygone.setMargin(new Insets(2, 2, 2, 2));
        jBPolygone.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jBPolygone_ActionPerformed(evt);
            }
        });
        cp.add(jBPolygone);
        jBAngle.setBounds(552, 184, BUTTON_WIDTH, 25);
        jBAngle.setText("Angle");
        jBAngle.setBackground(Color.WHITE);
        jBAngle.setFont(new Font("Roboto Mono", Font.PLAIN, 12));
        jBAngle.setFocusPainted(false);
        jBAngle.setMargin(new Insets(2, 2, 2, 2));
        jBAngle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jBAngle_ActionPerformed(evt);
            }
        });
        cp.add(jBAngle);
        jBDelete.setBounds(553, 293, BUTTON_WIDTH, 34);
        jBDelete.setText("Objekt löschen");
        jBDelete.setBackground(Color.WHITE);
        jBDelete.setFont(new Font("Roboto Mono", Font.PLAIN, 12));
        jBDelete.setFocusPainted(false);
        jBDelete.setMargin(new Insets(2, 2, 2, 2));
        jBDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jBDelete_ActionPerformed(evt);
            }
        });
        jBDelete.setFont(new Font("Dialog", Font.BOLD, 12));
        cp.add(jBDelete);
        jBColour.setBounds(552, 248, BUTTON_WIDTH, 33);
        jBColour.setText("Objekt färben");
        jBColour.setBackground(Color.WHITE);
        jBColour.setFont(new Font("Roboto Mono", Font.PLAIN, 12));
        jBColour.setFocusPainted(false);
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

    public void jBAngle_ActionPerformed(ActionEvent evt){
        board1.addNewAngle();
    }
    // Ende Methoden

    public static void main(String[] args) {
        new GeoObjGUI("GeoObjGUI");
    } // end of main

} // end of class DrawItGUI

