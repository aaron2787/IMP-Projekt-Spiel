import javax.swing.*;
import java.awt.*;
public class Funktionen
{
    public int rows = 4, cols = 4, cellSize;    
    public Image scaleImage(Image originalPicture, int wideImage,int hightImage){
        Image scaledPicture = originalPicture.getScaledInstance(wideImage, hightImage, Image.SCALE_SMOOTH);
        return scaledPicture;
    }
    public JLabel addImageToJFrame (Image imageToAdd, JFrame frameToAddTo, int xPosition, int yPosition, int imageWide, int imageHight, int z){
        frameToAddTo.setLayout(null);
        imageToAdd = scaleImage(imageToAdd, imageWide, imageHight);
        ImageIcon icon = new ImageIcon(imageToAdd);
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setBounds(xPosition, yPosition,imageWide, imageHight);
        frameToAddTo.getLayeredPane().add(imageLabel, Integer.valueOf(z));
        frameToAddTo.repaint();
        return imageLabel;
    }
    public JFrame startJFrame(String displayedName){
        GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        JFrame frame = new JFrame(displayedName);
        ImageIcon icon = new ImageIcon("logo.png"); 
        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);  
        frame.setVisible(true);
        return frame;
    }
}