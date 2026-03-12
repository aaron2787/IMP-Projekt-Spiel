public class spielbrett {
    public spieler[] spieler;
    public stein[][] spielfeld;
    public orbitoKnopf orbito;
    public Bildschirm bildschirm;
    public spielbrett() {
        this.spielfeld = new stein[4][4];
        this.orbito = new orbitoKnopf();
    }
    public void showBoard() {
        bildschirm.clearSpielfeld();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (spielfeld[i][j] != null) {
                    bildschirm.addStone(j, i, spielfeld[i][j]);
                }
            }
        }
        bildschirm.bildschirm.repaint();
        bildschirm.disableOccupiedCells(spielfeld);
    }
    public void setBildschirm(Bildschirm bildschirm) {
        this.bildschirm = bildschirm;
    }
    void place(int x, int y, stein stein) {
        spielfeld[y][x] = stein;
    }
    public void move(int x, int y, int moveX, int moveY) {
        spielfeld[y][x] = spielfeld[moveY][moveX];
        spielfeld[moveY][moveX] = null;
        bildschirm.amZug.hasMoved = true;
        bildschirm.modus = bildschirm.MODUS_PLACE;
        showBoard();
        bildschirm.startPlacing(bildschirm.amZug);
    }
}