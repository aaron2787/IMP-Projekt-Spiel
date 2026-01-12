import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Beschreiben Sie hier die Klasse frame.
 *
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class ImageViewer
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private JFrame frame;
    /**
     * Konstruktor für Objekte der Klasse frame
     */
    public ImageViewer()
    {
        // Instanzvariable initialisieren
        makeFrame();
    }
    
    private void makeFrame(){
        frame = new JFrame("ImageViewer");
        Container contentPane = frame.getContentPane();
       
        JLabel label = new JLabel("I am a label and I don't know, how this works.   Tralalero Tralala");
        contentPane.add(label);
        makeMenuBar(frame);
        frame.pack();
        frame.setVisible(true);
    }
    private void makeMenuBar (JFrame frame){
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
       
        JMenu fileMenu = new JMenu("File");
        menubar.add(fileMenu);
       
        JMenuItem openItem = new JMenuItem("Open");
        fileMenu.add(openItem);
       
        JMenuItem quitItem = new JMenuItem ("Quit");
        fileMenu.add(quitItem);
       
        JMenuItem searchItem = new JMenuItem("Search");
        fileMenu.add(searchItem);
    }
        
    
}