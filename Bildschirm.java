import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Beschreiben Sie hier die Klasse Bildschirm.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Bildschirm extends Funktionen
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    JFrame bildschirm; 
    int width;
    int height;
    PlayerPanel weiss, schwarz;
    cell[][] cells = new cell[4][4];
    spieler amZug;
    JLabel[] kugelLabelStore = new JLabel[16];
    int kugelIdx;
    double cellSize;
    JLabel knopfLabel;
    int modus;
    
    final int MODUS_MOVE = 1;
    final int MODUS_PLACE = 0;
    
    int moveX, moveY;
    
    public Bildschirm(spieler[] spieler)
    {
        this.bildschirm = startJFrame("Orbito", width, height); 
        
        
        
        //stein stein = new stein("s");
        //addStone(1, 1, stein);
        /**
        Image s = new ImageIcon("dummy.png").getImage();
         //JLabel steinLabel = addImageToJFrame(kugel, bildschirm, 500, 500, 150, 150);
         //"kreis_"+stein.color+".png"
         bildschirm.setLayout(null);
        //System.out.println(imageWide);
        //System.out.println(imageHight);
        s = scaleImage(s, 150, 150);
        ImageIcon e = new ImageIcon(s);
        JLabel f = new JLabel(e);
        f.setBounds(20, 500,150, 150);
        bildschirm.add(f);
        */
        
        
        modus = MODUS_PLACE;
        
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width  = (int) screenSize.getWidth();
        height = (int) screenSize.getHeight();
        
        int brettM = (int) (height * 0.9);
        this.kugelIdx = 0;
        
        Image brett = new ImageIcon("Spielbrettsora.png").getImage();
        int widthI = brettM;
        int heightI = brettM;
        JLabel feld = addImageToJFrame(brett, bildschirm, (width-widthI)/2, (height-heightI)/2, widthI, heightI, 0);
        
        cellSize = (((double) brettM*(1.0-(136.0/745.0)))/4.0);
        //System.out.println(cellSize);
        createGrid(bildschirm, (int) cellSize);
        this.weiss = new PlayerPanel(bildschirm, "w", width, height, 20, 20, "Spieler 1", spieler[0]);
        this.schwarz = new PlayerPanel(bildschirm, "s", width, height,  (int) ((width-widthI)/2.0+widthI+10), 20, "Spieler 2", spieler[1]);
        
        
        }
        void showOrbitoKnopf() {
            for (cell[] row : cells) {
                for (cell cell : row) {
                    cell.enabled = false;
                }
            }
            Image knopf = new ImageIcon("orbitoKnopf.png").getImage();
            //int knopfWidth
            knopfLabel = addImageToJFrame(knopf, bildschirm, 920, 550, 100, 100, 10000);
            
            //bildschirm.getLayeredPane().add(knopfLabel, Integer.valueOf(1000));
            
            knopfLabel.addMouseListener(new MouseAdapter() {
            /**
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
            **/
            @Override
            public void mouseClicked(MouseEvent e) {
                amZug.spielfeld.spielfeld = amZug.spielfeld.orbito.drehen(amZug.spielfeld.spielfeld);
                amZug.spiel.naechsterSpieler();
            }
        });
        }
        void removeOrbitoKnopf() {
            if (knopfLabel != null) {
            bildschirm.getLayeredPane().remove(knopfLabel);
            knopfLabel = null;
        }
        
        }
        void unentschieden() {
            weiss.showWin();
            schwarz.showWin();
        }
        void gewonnen(String winnerColor) {
            if (winnerColor.equals("s")) {
                schwarz.showWin();
            } else {
                weiss.showWin();
            }
        }
        void newGame() {
            Image newGame = new ImageIcon("newGame.png").getImage();
            Image closeGame = new ImageIcon("closeGame.png").getImage();
            
            JLabel newGameLabel = addImageToJFrame (newGame, bildschirm, 300, 500, 200, 50, 456787678);
            JLabel closeGameLabel = addImageToJFrame (closeGame, bildschirm, 600, 500, 200, 50, 456787678);
            
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
     void addStone(int row, int clmn, stein stein) {
         Image kugel = new ImageIcon("kugel_"+stein.color+".png").getImage();
         //JLabel steinLabel = addImageToJFrame(kugel, bildschirm, 500, 500, 150, 150);
         //
         bildschirm.setLayout(null);
        //System.out.println(imageWide);
        //System.out.println(imageHight);
        double diam = (cellSize*0.7);
        kugel = scaleImage(kugel, (int) diam , (int) diam);
        ImageIcon kugelIcon = new ImageIcon(kugel);
        JLabel kugelLabel = new JLabel(kugelIcon);
        kugelLabel.setBounds((cells[row][clmn].pixelX + (int) ((cellSize-diam)/2)), (cells[row][clmn].pixelY + (int) ((cellSize-diam)/2)), (int) diam, (int) diam);
        //bildschirm.add(kugelLabel);
        //bildschirm.setComponentZOrder(kugelLabel, 0);
        bildschirm.getLayeredPane().add(kugelLabel, Integer.valueOf(1000));


        kugelLabelStore[kugelIdx] = kugelLabel;
        kugelIdx++;
     }
     public void disableOcc(stein[][] spielfeld) {
         for (int i = 0; i < 4; i++) {
             for (int j = 0; j < 4; j++) {
                boolean occ = spielfeld[j][i] != null;
                
                cells[i][j].occupied = occ;
                cells[i][j].enabled = !occ;
             }
         }
     }
    public void resetKugel() {
        for (JLabel kugel : kugelLabelStore) {
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
    amZug = spieler;
    /**
    for (cell[] row : cells) {
            for (cell cell : row) {
               cell.enabled = !cell.occupied
        }
    }
    **/
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
public void moveStein(int x, int y) {
    modus = MODUS_MOVE;
    for (cell[] row : cells) {
                for (cell cell : row) {
                    cell.enabled = false;
                }
    }
    if (x-1 >= 0) {
        cells[x-1][y].enabled = !cells[x-1][y].occupied;
    }
    if (x+1 < 4) {
        cells[x+1][y].enabled = !cells[x+1][y].occupied;
    }
    if (y-1 >= 0) {
        cells[x][y-1].enabled = !cells[x][y-1].occupied;;
    }
    if (y+1 < 4) {
        cells[x][y+1].enabled = !cells[x][y+1].occupied;;
    }
    cells[x][y].enabled = true;
    moveX = x;
    moveY = y;
}
public void createGrid(JFrame frame, int cellSize){
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
