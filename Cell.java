
/**
 * Beschreiben Sie hier die Klasse cell.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Cell extends JLabel
{
    private int gridX, gridY;
        public Cell(int gridX, int gridY){
        this.gridX = gridX;
        this.gridY = gridY;
        this.addMouseListener(new MouseAdapter() {
            @Override
                public void mouseClicked(MouseEvent e) {
                    //Spiel.onCellClicked(gridX, gridY);
                    System.out.println("Klicked " + gridX + "|" + gridY);
                }
        });
    }
}

