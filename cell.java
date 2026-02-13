import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class cell {

    private JLabel image;
    public boolean enabled = false;
    public boolean occupied = false;
    private boolean hovered = false;
    private Bildschirm bildschirm;
    int pixelX;
    int pixelY;

    public cell(Bildschirm bildschirm, JFrame frame, int cellSize, int x, int y) {
        this.bildschirm = bildschirm;
        image = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                // KEIN super.paintComponent bei Overlay
                if (hovered) {
        Graphics2D g2 = (Graphics2D) g.create();

        // transparente graue Fläche
        g2.setColor(new Color(150, 150, 150, 80));
        g2.fillRect(0, 0, getWidth(), getHeight());

        // undurchsichtige graue Border
        g2.setColor(new Color(120, 120, 120)); // voll opaque
        g2.setStroke(new BasicStroke(2));      // Border-Dicke
        g2.drawRect(1, 1, getWidth() - 3, getHeight() - 3);

        g2.dispose();
    }
            }
        };

        image.setOpaque(false);
        image.setLayout(null);
        //image.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        // ===== Position berechnen =====
        int frameWidth  = frame.getWidth();
        int frameHeight = frame.getHeight();

        int gridWidth  = 4 * cellSize;
        int gridHeight = 4 * cellSize;

        int gridStartX = (frameWidth  - gridWidth)  / 2;
        int gridStartY = (frameHeight - gridHeight) / 2;

        pixelX = gridStartX + x * cellSize;
        pixelY = gridStartY + y * cellSize;

        image.setBounds(pixelX, pixelY, cellSize, cellSize);

        // ===== HINZUFÜGEN (RICHTIG!) =====
        frame.getLayeredPane().add(image, Integer.valueOf(100));

        // ===== Hover-Logik =====
        image.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                if (!enabled) return;
                hovered = true;
                image.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hovered = false;
                image.repaint();
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
                if (enabled) {
                    //bildschirm.amZug.finishedPlacing = true;
                    stein stein = new stein(bildschirm.amZug.color);
                    bildschirm.amZug.spielfeld.place(x, y, stein);
                    bildschirm.amZug.beendeZug();
                }
            }
        });
    }
}