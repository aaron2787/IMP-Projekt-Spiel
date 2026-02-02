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
    int rows = 4, cols = 4, cellSize = 150;
    public JFrame startJFrame(String displayedName){
        JFrame frame = new JFrame(displayedName);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1535, 1000);
        frame.setLayout(null);
        frame.setVisible(true);
        return frame;
    }
    public void addStoneW(int gridX, int gridY, JFrame frame, String path){
        Image stone = new ImageIcon(path).getImage();
        Image scaledStone = stone.getScaledInstance(cellSize, cellSize, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(scaledStone);
        JLabel imageLabel = new JLabel(icon);
        
        int frameWidth  = frame.getWidth();
        int frameHeight = frame.getHeight();
        int gridWidth  = cols * cellSize;
        int gridHeight = rows * cellSize;

        int gridStartX = (frameWidth  - gridWidth)  / 2;
        int gridStartY = (frameHeight - gridHeight) / 2;
        int pixelX = gridStartX + gridX * cellSize;
        int pixelY = gridStartY + gridX * cellSize;

        imageLabel.setBounds(pixelX, pixelY, cellSize, cellSize);
        frame.add(imageLabel);
        frame.repaint();
    }
    public void createGrid(JFrame frame){
        frame.setLayout(null);
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                //JLabel cell = new JLabel();
                Cell cell = new Cell(x,y);
                cell.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                int frameWidth  = frame.getWidth();
                int frameHeight = frame.getHeight();
                int gridWidth  = cols * cellSize;
                int gridHeight = rows * cellSize;

                int gridStartX = (frameWidth  - gridWidth)  / 2;
                int gridStartY = (frameHeight - gridHeight) / 2;
                int pixelX = gridStartX + x * cellSize;
                int pixelY = gridStartY + y * cellSize;
                cell.setBounds(pixelX, pixelY, cellSize, cellSize);
                frame.add(cell);
            }
        }
        frame.repaint();
    }
}

