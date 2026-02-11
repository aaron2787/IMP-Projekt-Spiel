import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PlayerPanel extends Funktionen
{
    String color;
    Textfeld textfeld;
    public PlayerPanel(JFrame frame, String color, int screenWidth, int screenHeight, int x, int y, String name, spieler spieler) {
        this.color = color;
        Image image = new ImageIcon("player_panel_" + color + ".png").getImage();
        int width = (int) ((screenWidth-(screenHeight*0.9)-40.0)/2.0);
        int height = (int) ((width/1202.0)*788.0);
        //System.out.print(color + ": " + x + " " + y + " " + width + " " + height);
        JLabel panel = addImageToJFrame(image, frame, x, y, width, height); 
        textfeld = new Textfeld(frame, (int) (width*0.85), (int) (height*0.73), (int) (x+(width*0.07)), (int) (y+(height*0.05)), name);
        
        panel.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                //frame.setAlwaysOnTop(true);
                String updt = JOptionPane.showInputDialog(frame, "Wie heißt " + name + "?");
                //frame.setAlwaysOnTop(false);
                if (updt == null || updt.equals("")) {
                    updt = textfeld.text; 
                } else {
                    textfeld.setText(updt);
                    spieler.name = updt;
                } 
                
            }
        });
    }
}
