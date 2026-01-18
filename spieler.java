
/**
 * Beschreiben Sie hier die Klasse spieler.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class spieler
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private String name;
    public int steinAnzahl;
    spielbrett spielfeld;
    String color;
    /**
     * Konstruktor für Objekte der Klasse spieler
     */
    public spieler(String name, String color, spielbrett spielfeld)
    {
        // Instanzvariable initialisieren
        this.name = name;
        this.steinAnzahl = 8;
        this.spielfeld = spielfeld;
        this.color = color;
    }

    void zug() {
        System.out.println(name + " ist am Zug.");
        boolean moved = false;
        while (!moved) {
            System.out.println("Möchtest du einen Stein deines Gegners bewegen? Gib seine Position ein oder schreibe 'skip'!");
            String pos = System.console().readLine();
            if (pos.toLowerCase() == "skip") {
                moved = true;
            } else {
                moved = spielfeld.move(pos, color);
            }
        }
        boolean placed = false;
        while (!placed) {
            System.out.println("Wohin möchtest du deinen Stein platzieren?");
            String pos = System.console().readLine();
            placed = spielfeld.place(pos, color);
        }
        this.steinAnzahl--;
        spielfeld.drehen();
    }
}
