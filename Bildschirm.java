import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Bildschirm extends GUIUtilities {
    public JFrame bildschirm;
    private int width;
    private int height;
    private PlayerPanel weiss, schwarz;
    private cell[][] cells = new cell[4][4];
    public spieler amZug;
    private JLabel[] kugelLabelStore = new JLabel[16];
    private int kugelIdx;
    private double cellSize;
    private JLabel knopfLabel;
    public int modus;
    private JLabel amZugIndicator;
    private help help;
    public final int MODUS_MOVE = 1;
    public final int MODUS_PLACE = 0;
    public int moveX, moveY;
    public Bildschirm(spieler[] spieler) {
        this.bildschirm = startJFrame("Orbito");
        modus = MODUS_PLACE;        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = (int) screenSize.getWidth();
        height = (int) screenSize.getHeight();
        int brettM = (int)(height * 0.9);
        this.kugelIdx = 0;
        Image brett = new ImageIcon("Spielbrettsora.png").getImage();
        int widthI = brettM;
        int heightI = brettM;
        JLabel feld = addImageToJFrame(brett, bildschirm, (width - widthI) / 2, (height - heightI) / 2, widthI, heightI, 0);
        cellSize = (((double) brettM * (1.0 - (136.0 / 745.0))) / 4.0);
        createGrid(bildschirm, (int) cellSize);
        this.weiss = new PlayerPanel(bildschirm, "w", width, height, 20, 20, "Spieler 1", spieler[0]);
        this.schwarz = new PlayerPanel(bildschirm, "s", width, height, (int)((width - widthI) / 2.0 + widthI + 10), 20, "Spieler 2", spieler[1]);
        double helpWidth = 120.0;
        help = new help((int) (width-(helpWidth*1.05)), (int) (height-helpWidth*1.05), (int) helpWidth, bildschirm);
    }
    public Textfeld addOrbitoCountdown() {
        int TWidth = width / 38;
        Textfeld countdown = new Textfeld(bildschirm, TWidth, TWidth, (int)(((width - TWidth) / 2.0) + width * 0.0035), (height - TWidth) / 2, "5");
        return countdown;
    }
    public void showOrbitoKnopf() {
        for (cell[] row: cells) {
            for (cell cell: row) {
                cell.enabled = false;
            }
        }
        Image knopf = new ImageIcon("orbitoButton.png").getImage();
        int knopfWidth = width / 19;
        knopfLabel = addImageToJFrame(knopf, bildschirm, (int)(((width - knopfWidth) / 2.0) + width * 0.0035), (int)(((height - knopfWidth) / 2.0) + height * 0.0035), knopfWidth, knopfWidth, 10000);
        knopfLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                amZug.spielfeld.spielfeld = amZug.spielfeld.orbito.drehen(amZug.spielfeld.spielfeld);
                amZug.spiel.naechsterSpieler();
            }
        });
    }
    public void disableAllCells() {
        for (cell[] row: cells) {
            for (cell cell: row) {
                cell.enabled = false;
            }
        }
    }
    public void removeOrbitoKnopf() {
        if (knopfLabel != null) {
            bildschirm.getLayeredPane().remove(knopfLabel);
            knopfLabel = null;
        }
    }
    public void removeAmZugIndicator() {
        if (amZug == null) {
            return;
        }
        if (amZug.color.equals("w")) {
            weiss.removeAmZugIndicator();
        } else {
            schwarz.removeAmZugIndicator();
        }
    }
    private void addAmZugIndicator() {
        if (amZug.color.equals("w")) {
            weiss.addAmZugIndicator("w");
        } else {
            schwarz.addAmZugIndicator("s");
        }
    }
    public void unentschieden() {
        weiss.showDraw("w");
        schwarz.showDraw("s");
    }
    public void gewonnen(String winnerColor) {
        if (winnerColor.equals("s")) {
            schwarz.showWin();
        } else {
            weiss.showWin();
        }
    }
    public void addNewGameButtons() {
        Image newGame = new ImageIcon("new.png").getImage();
        Image closeGame = new ImageIcon("close.png").getImage();
        double widthButton = ((height * 0.9) / 2) * 0.8;
        JLabel newGameLabel = addImageToJFrame(newGame, bildschirm, (int)(((width * 0.95) / 2.0) - widthButton), (int)(height * 0.005), (int) widthButton, (int)(widthButton * (291.0 / 1013.0)), 456787678);
        JLabel closeGameLabel = addImageToJFrame(closeGame, bildschirm, (int)((width * (100.0 / 95.0)) / 2.0), (int)(height * 0.005), (int) widthButton, (int)(widthButton * (351.0 / 1240.0)), 456787678);
        newGameLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                amZug.spiel.reset();
            }
        });
        closeGameLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                amZug.spiel.closeGame();
            }
        });
    }
    public void addStone(int row, int clmn, stein stein) {
        Image kugel = new ImageIcon("kugel_" + stein.color + ".png").getImage();
        bildschirm.setLayout(null);
        double diam = (cellSize * 0.7);
        kugel = scaleImage(kugel, (int) diam, (int) diam);
        ImageIcon kugelIcon = new ImageIcon(kugel);
        JLabel kugelLabel = new JLabel(kugelIcon);
        kugelLabel.setBounds((cells[row][clmn].pixelX + (int)((cellSize - diam) / 2)), (cells[row][clmn].pixelY + (int)((cellSize - diam) / 2)), (int) diam, (int) diam);
        bildschirm.getLayeredPane().add(kugelLabel, Integer.valueOf(1000));
        kugelLabelStore[kugelIdx] = kugelLabel;
        kugelIdx++;
    }
    public void disableOccupiedCells(stein[][] spielfeld) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                boolean occ = spielfeld[j][i] != null;
                cells[i][j].occupied = occ;
                cells[i][j].enabled = !occ;
            }
        }
    }
    public void clearSpielfeld() {
        for (JLabel kugel: kugelLabelStore) {
            if (kugel == null) {
                continue;
            }
            bildschirm.getLayeredPane().remove(kugel);
        }
        kugelLabelStore = new JLabel[16];
        kugelIdx = 0;
    }
    public void startPlacing(spieler spieler) {
        removeOrbitoKnopf();
        removeAmZugIndicator();
        amZug = spieler;
        addAmZugIndicator();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                cell cell = cells[i][j];
                if (!cell.occupied || (!amZug.hasMoved && !amZug.spielfeld.spielfeld[j][i].color.equals(amZug.color))) {
                    cell.enabled = true;
                } else {
                    cell.enabled = false;
                }
            }
        }
    }
    public void startModusMove(int x, int y) {
        modus = MODUS_MOVE;
        disableAllCells();
        if (x - 1 >= 0) {
            cells[x - 1][y].enabled = !cells[x - 1][y].occupied;
        }
        if (x + 1 < 4) {
            cells[x + 1][y].enabled = !cells[x + 1][y].occupied;
        }
        if (y - 1 >= 0) {
            cells[x][y - 1].enabled = !cells[x][y - 1].occupied;;
        }
        if (y + 1 < 4) {
            cells[x][y + 1].enabled = !cells[x][y + 1].occupied;;
        }
        cells[x][y].enabled = true;
        moveX = x;
        moveY = y;
    }
    private void createGrid(JFrame frame, int cellSize) {
        frame.setLayout(null);
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                cell cell = new cell(this, frame, cellSize, x, y);
                cells[x][y] = cell;
            }
        }
        frame.repaint();
    }
}