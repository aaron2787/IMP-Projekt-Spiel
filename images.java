
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
        JFrame imageTest = new JFrame("Test");
        imageTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        imageTest.setSize(1535, 1000);
        
        Image scaledPicture = scaleImage("dummy.png", 300, 300);
        addImageToJFrame(scaledPicture, imageTest, 30, 30, 300, 300);
        imageTest.setVisible(true);
    }
}
