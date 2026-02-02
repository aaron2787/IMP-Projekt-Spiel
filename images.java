
/**
 * Beschreiben Sie hier die Klasse images.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class images extends Funktionen
{
    public images()
    {
        /**
        JFrame image = new JFrame("Images");
        image.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        image.setSize(400, 300);
        
        Image originalesBild = new ImageIcon("dummy.png").getImage();
        int neueBreite = 150;
        int neueHoehe = 150;
        Image skaliertesBild = originalesBild.getScaledInstance(neueBreite, neueHoehe, Image.SCALE_SMOOTH);
        
        ImageIcon skaliertesIcon = new ImageIcon(skaliertesBild);
        
        JLabel bildLabel = new JLabel(skaliertesIcon);
        image.add(bildLabel);
        image.setVisible(true);
        //ImageIcon 
        */
           
        /**
        JFrame image = new JFrame("Images");
        image.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        image.setSize(400, 300);
        
        Image originalesBild = new ImageIcon("Spielbrettsora.png").getImage();
        int neueBreite = 150;
        int neueHoehe = 150;
        Image skaliertesBild = originalesBild.getScaledInstance(neueBreite, neueHoehe, Image.SCALE_SMOOTH);
        
        ImageIcon skaliertesIcon = new ImageIcon(skaliertesBild);
        
        JLabel bildLabel = new JLabel(skaliertesIcon);
        image.add(bildLabel);
        image.setVisible(true);
        //ImageIcon 
        */
        JFrame frame = startJFrame("Test");
        //Image scaledPicture = scaleImage("Hintergrund.png", 312, 312);
        //Image processedImage = processImage("Hintergrund.png");
        //addImageToJFrame(processedImage, frame, 0, 0, 312, 313);
        //displayText("Test", frame, 0, 0);
        createGrid(frame);
        //addStoneWhite(1,1,frame);

        
    }
}
