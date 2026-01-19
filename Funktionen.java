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
    public void addImageToJFrame (Image imageToAdd, JFrame frameToAddTo, int xPosition, int yPosition, int imageWide, int imageHight){
        frameToAddTo.setLayout(null);
        ImageIcon icon = new ImageIcon(imageToAdd);
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setBounds(xPosition, yPosition,imageWide, imageHight);
        frameToAddTo.add(imageLabel);
    }
    public void addClickListener(JComponent object, Runnable action){
        object.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                action.run();
            }
        });
    }
}

