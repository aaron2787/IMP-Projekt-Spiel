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
    int rows = 4, cols = 4, cellSize = 40;

    public Image scaleImage(String pathImage, int wideImage,int hightImage){
        Image originalPicture = new ImageIcon(pathImage).getImage();
        Image scaledPicture = originalPicture.getScaledInstance(wideImage, hightImage, Image.SCALE_SMOOTH);
        return scaledPicture;
    }
    public Image processImage(String pathImage){
        Image originalPicture = new ImageIcon(pathImage).getImage();
        return originalPicture;
    }
    public void addImageToJFrame (Image imageToAdd, JFrame frameToAddTo, int xPosition, int yPosition, int imageWide, int imageHight){
        frameToAddTo.setLayout(null);
        ImageIcon icon = new ImageIcon(imageToAdd);
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setBounds(xPosition, yPosition,imageWide, imageHight);
        frameToAddTo.add(imageLabel);
        frameToAddTo.repaint();
    }
    public void addClickListener(JComponent object, Runnable action){
        object.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                action.run();
            }
        });
    }
    public JFrame startJFrame(String displayedName){
        JFrame frame = new JFrame(displayedName);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1535, 1000);
        frame.setLayout(null);
        frame.setVisible(true);
        return frame;
    }
    public JFrame startJFrame(String displayedName, int width, int hight){
        JFrame frame = new JFrame(displayedName);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, hight);
        frame.setVisible(true);
        return frame;
    }
    public void displayText(String textToDisplay, JFrame frameToAddTo, int xPosition, int yPosition){
        JLabel label = new JLabel(textToDisplay);
        label.setBounds(xPosition, yPosition, 200, 30);
        frameToAddTo.setLayout(null);
        frameToAddTo.add(label);
        frameToAddTo.repaint();
    }
    public void test(){
        
    }
    public void addStoneWhite(int gridX, int gridY, JFrame frame){
        Image stone = new ImageIcon("Hintergrund.png").getImage();
        Image scaledStone = stone.getScaledInstance(cellSize, cellSize, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(scaledStone);
        JLabel imageLabel = new JLabel(icon);
        
        int pixelX = gridX * cellSize;
        int pixelY = gridY * cellSize;

        imageLabel.setBounds(pixelX, pixelY, cellSize, cellSize);
        frame.add(imageLabel);
        frame.repaint();
    }
}

