/**
 * Beschreiben Sie hier die Klasse Funktionen.
 * 
 * @author (Aaron) 
 * @funktionn (This class is used to help creating objects and images with Swing)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Funktionen
{
    public Image scaleImage(String pathImage, int wideImage,int hightImage){
        Image originalPicture = new ImageIcon(pathImage).getImage();
        Image scaledPicture = originalPicture.getScaledInstance(wideImage, hightImage, Image.SCALE_SMOOTH);
        return scaledPicture;
    }
}
