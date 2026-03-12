public class Spiel {
    public spielbrett spielfeld;
    public spieler[] spieler;
    public Music music;
    public Bildschirm bildschirm;
    public int spIdx = 1;
    public int endEventCounter = 0;
    public Textfeld countdown = null;
    public Spiel() {
        this.music = new Music();
        this.spielfeld = new spielbrett();
        spieler s1 = new spieler("Spieler 1", "w", spielfeld, this);
        spieler s2 = new spieler("Spieler 2", "s", spielfeld, this);
        this.spieler = new spieler[] {s1, s2};
        this.bildschirm = new Bildschirm(spieler);
        spielfeld.setBildschirm(this.bildschirm);
        naechsterSpieler();
    }
    public void reset() {
        bildschirm.bildschirm.dispose();
        spIdx = 1;
        endEventCounter = 0;
        this.music = new Music();
        this.spielfeld = new spielbrett();
        spieler s1 = new spieler("Spieler 1", "w", spielfeld, this);
        spieler s2 = new spieler("Spieler 2", "s", spielfeld, this);
        this.spieler = new spieler[] {s1, s2};
        this.bildschirm = new Bildschirm(spieler);
        spielfeld.setBildschirm(this.bildschirm);
        naechsterSpieler();
    }
    public void closeGame() {
        System.exit(0);
    }
    public void naechsterSpieler() {
        bildschirm.removeAmZugIndicator();
        spielfeld.showBoard();
        String[] winC = checkWin();
        if (winC[0] != null) {
            if (winC[1] != null) {
                endGame("beide");
            } else {
                endGame(winC[0]);
            }
            return;
        }
        spIdx = (spIdx + 1) % 2;
        if (spieler[0].steinAnzahl > 0 || spieler[1].steinAnzahl > 0) {
            spieler[spIdx].startZug();
        } else {
            if (endEventCounter < 5) {
                if (endEventCounter == 0) {
                    countdown = bildschirm.addOrbitoCountdown();
                }
                countdown.setText("" + (5 - endEventCounter));
                bildschirm.removeOrbitoKnopf();
                bildschirm.showOrbitoKnopf();
                endEventCounter++;
            } else {
                countdown.setText("0");
                endGame(null);
            }
        }
    }
    private void endGame(String winner) {
        bildschirm.removeOrbitoKnopf();
        bildschirm.disableAllCells();
        if (winner == null) {
            bildschirm.unentschieden();
        } else if (winner.equals("beide")) {
            bildschirm.unentschieden();
        } else {
            for (spieler s: spieler) {
                if (s.color.equals(winner)) {
                    bildschirm.gewonnen(s.color);
                }
            }
        }
        bildschirm.addNewGameButtons();
    }
    private String[] checkWin() {
        String winners[] = new String[2];
        int winIdx = 0;
        for (int i = 0; i < 4; i++) {
            if (spielfeld.spielfeld[i][0] == null) continue;
            String c = spielfeld.spielfeld[i][0].color;
            boolean won = true;
            for (int j = 1; j < 4; j++) {
                if (spielfeld.spielfeld[i][j] == null ||
                    !spielfeld.spielfeld[i][j].color.equals(c)) {
                    won = false;
                    break;
                }
            }
            if (won) {
                if (winIdx < 2 && (winIdx == 0 || !winners[0].equals(c))) {
                    winners[winIdx] = c;
                    winIdx++;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            if (spielfeld.spielfeld[0][i] == null) continue;
            String c = spielfeld.spielfeld[0][i].color;
            boolean won = true;
            for (int j = 1; j < 4; j++) {
                if (spielfeld.spielfeld[j][i] == null ||
                    !spielfeld.spielfeld[j][i].color.equals(c)) {
                    won = false;
                    break;
                }
            }
            if (won) {
                if (winIdx < 2 && (winIdx == 0 || !winners[0].equals(c))) {
                    winners[winIdx] = c;
                    winIdx++;
                }
            }
        }
        if (spielfeld.spielfeld[0][0] != null) {
            String c = spielfeld.spielfeld[0][0].color;
            boolean won = true;
            for (int i = 1; i < 4; i++) {
                if (spielfeld.spielfeld[i][i] == null ||
                    !spielfeld.spielfeld[i][i].color.equals(c)) {
                    won = false;
                    break;
                }
            }
            if (won) {
                if (winIdx < 2 && (winIdx == 0 || !winners[0].equals(c))) {
                    winners[winIdx] = c;
                    winIdx++;
                }
            }
        }
        if (spielfeld.spielfeld[0][3] != null) {
            String c = spielfeld.spielfeld[0][3].color;
            boolean won = true;
            for (int i = 1; i < 4; i++) {
                if (spielfeld.spielfeld[i][3 - i] == null ||
                    !spielfeld.spielfeld[i][3 - i].color.equals(c)) {
                    won = false;
                    break;
                }
            }
            if (won) {
                if (winIdx < 2 && (winIdx == 0 || !winners[0].equals(c))) {
                    winners[winIdx] = c;
                    winIdx++;
                }
            }
        }
        return winners;
    }
}