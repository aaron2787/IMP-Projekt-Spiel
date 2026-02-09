import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Beschreiben Sie hier die Klasse Bildschirm.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Bildschirm extends Funktionen
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    JFrame bildschirm; 
    int width;
    int height;
    public Bildschirm()
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width  = (int) screenSize.getWidth();
        height = (int) screenSize.getHeight();
        int brettM = (int) (height * 0.9);
        
        this.bildschirm = startJFrame("Orbito", width, height); 
        Image brett = new ImageIcon("Spielbrettsora.png").getImage();
        int widthI = brettM;
        int heightI = brettM;
        addImageToJFrame(brett, bildschirm, (width-widthI)/2, (height-heightI)/2, widthI, heightI);
        
        double cellSize = (((double) brettM*(1.0-(136.0/745.0)))/4.0);
        //System.out.println(cellSize);
        createGrid(bildschirm, (int) cellSize);
        }
}
