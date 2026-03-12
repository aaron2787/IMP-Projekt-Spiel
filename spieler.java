public class spieler {
    public String name;
    public int steinAnzahl;
    public Spiel spiel;
    public String color;
    public spielbrett spielfeld;
    public boolean finishedPlacing;
    public boolean hasMoved = false;
    public spieler(String name, String color, spielbrett spielfeld, Spiel spiel) {
        this.name = name;
        this.steinAnzahl = 8;
        this.spiel = spiel;
        this.spielfeld = spielfeld;
        this.color = color;
    }
    public void startZug() {
        finishedPlacing = false;
        spiel.bildschirm.startPlacing(this);
    }
    public void beendeZug() {
        this.steinAnzahl--;
        spielfeld.showBoard();
        spiel.bildschirm.showOrbitoKnopf();
    }
}