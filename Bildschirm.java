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
    PlayerPanel weiss, schwarz;
    public Bildschirm(spieler[] spieler)
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width  = (int) screenSize.getWidth();
        height = (int) screenSize.getHeight();
        int brettM = (int) (height * 0.9);
        
        this.bildschirm = startJFrame("Orbito", width, height); 
        Image brett = new ImageIcon("Spielbrettsora.png").getImage();
        int widthI = brettM;
        int heightI = brettM;
        JLabel feld = addImageToJFrame(brett, bildschirm, (width-widthI)/2, (height-heightI)/2, widthI, heightI);
        
        double cellSize = (((double) brettM*(1.0-(136.0/745.0)))/4.0);
        //System.out.println(cellSize);
        createGrid(bildschirm, (int) cellSize);
        this.weiss = new PlayerPanel(bildschirm, "w", width, height, 20, 20, "Spieler 1", spieler[0]);
        this.schwarz = new PlayerPanel(bildschirm, "s", width, height,  (int) ((width-widthI)/2.0+widthI+10), 20, "Spieler 2", spieler[1]);
        }
}
