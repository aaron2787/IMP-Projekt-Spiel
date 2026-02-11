/**
Credits für diese Klasse gehen an ChatGPT, ich bin ehrlich ich hatte keinen Bock
2 Jahre Swing zu studieren einfach um eine Klasse zu haben die Text anzeigt...
**/
import javax.swing.*;
import java.awt.*;

public class Textfeld extends JComponent {

    public String text;

    public Textfeld(JFrame frame, int w, int h, int x, int y, String text) {
        this.text = text;

        setBounds(x, y, w, h);
        setOpaque(false);

        JLayeredPane lp = frame.getLayeredPane();
        lp.add(this, JLayeredPane.POPUP_LAYER);
    }

    public void setText(String t) {
        text = t;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);

        for (int s = 1; ; s++) {
            Font f = new Font("Arial", Font.BOLD, s);
            g.setFont(f);
            FontMetrics m = g.getFontMetrics();

            if (m.stringWidth(text) > getWidth() ||
                m.getHeight() > getHeight()) {

                g.setFont(new Font("Arial", Font.BOLD, s - 1));
                m = g.getFontMetrics();

                g.drawString(
                    text,
                    (getWidth() - m.stringWidth(text)) / 2,
                    (getHeight() + m.getAscent()) / 2
                );
                return;
            }
        }
    }
}
