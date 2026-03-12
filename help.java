import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Desktop;
import java.net.URI;
public class help extends Funktionen {
    JLabel image;
    public help(int x, int y, int width, JFrame frame) {
        Image image_ = new ImageIcon("help.png").getImage();
        image = addImageToJFrame(image_, frame, x, y, width, width, 14714427);
        image.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if (true) {
                        Desktop.getDesktop().browse(new URI("https://paulosaurus6.github.io/OrbitoWebsite"));
                    }
                } catch (Exception err) {
                    err.printStackTrace();
                }
            }
        });
    }
}