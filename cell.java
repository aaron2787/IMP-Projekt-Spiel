import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class cell {
    private JLabel image;
    public boolean enabled = false;
    public boolean occupied = false;
    private boolean hovered = false;
    private Bildschirm bildschirm;
    public int pixelX;
    public int pixelY;
    public cell(Bildschirm bildschirm, JFrame frame, int cellSize, int x, int y) {
        this.bildschirm = bildschirm;
        image = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                if (hovered) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    if (bildschirm.modus == bildschirm.MODUS_MOVE) {
                        g2.setColor(new Color(255, 255, 0, 80));
                    } 
                    else {
                        g2.setColor(new Color(150, 150, 150, 80));
                    }
                    if (occupied) {
                        g2.setColor(new Color(0, 0, 255, 80));
                    }
                    g2.fillRect(0, 0, getWidth(), getHeight());
                    if (bildschirm.modus == bildschirm.MODUS_MOVE) {
                        g2.setColor(new Color(255, 255, 0));
                    }                     else {
                        g2.setColor(new Color(120, 120, 120));
                    }
                    if (occupied) {
                        g2.setColor(new Color(0, 0, 255, 80));
                    }
                    g2.setStroke(new BasicStroke(2));
                    g2.drawRect(1, 1, getWidth() - 3, getHeight() - 3);
                    g2.dispose();
                    image.repaint();
                }
            }
        };
        image.setOpaque(false);
        image.setLayout(null);
        int frameWidth = frame.getWidth();
        int frameHeight = frame.getHeight();
        int gridWidth = 4 * cellSize;
        int gridHeight = 4 * cellSize;
        int gridStartX = (frameWidth - gridWidth) / 2;
        int gridStartY = (frameHeight - gridHeight) / 2;
        pixelX = gridStartX + x * cellSize;
        pixelY = gridStartY + y * cellSize;
        image.setBounds(pixelX, pixelY, cellSize, cellSize);
        frame.getLayeredPane().add(image, Integer.valueOf(100));
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
                    if (bildschirm.modus == bildschirm.MODUS_MOVE) {
                        mouseClickedModusMove(e);
                    } else if (bildschirm.modus == bildschirm.MODUS_PLACE) {
                        mouseClickedModusPlace(e);
                    }
                }
            }
            public void mouseClickedModusPlace(MouseEvent e) {
                if (bildschirm.amZug.spielfeld.spielfeld[y][x] == null) {
                    hovered = false;
                    stein stein = new stein(bildschirm.amZug.color);
                    bildschirm.amZug.spielfeld.place(x, y, stein);
                    bildschirm.amZug.hasMoved = false;
                    bildschirm.amZug.beendeZug();
                } else {
                    bildschirm.startModusMove(x, y);
                }
            }
            public void mouseClickedModusMove(MouseEvent e) {
                spielbrett spielfeld = bildschirm.amZug.spielfeld;
                if (y == bildschirm.moveY && x == bildschirm.moveX) { 
                    bildschirm.modus = bildschirm.MODUS_PLACE;
                    bildschirm.amZug.spielfeld.showBoard();
                    bildschirm.startPlacing(bildschirm.amZug);
                    return;
                }
                spielfeld.move(x, y, bildschirm.moveX, bildschirm.moveY);
                hovered = false;
            }
        });
    }
}