import java.util.Scanner;
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
    Scanner sc = new Scanner(System.in);
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
        boolean show = true;
        while (!moved) {
            if (spielfeld.spieler[0].steinAnzahl == 8 && spielfeld.spieler[1].steinAnzahl == 8) {
                moved = true;
                //show = false;
                break;
            }
            System.out.println("Möchtest du einen Stein deines Gegners bewegen? Gib seine Position ein oder schreibe 'skip'!");
            String pos = sc.nextLine();
            //System.out.println(pos);
            if (pos.equalsIgnoreCase("skip")) {
                moved = true;
                show = false;
            } else {
                moved = spielfeld.move(pos, color);
            }
        }
        if (show) {
            spielfeld.showBoard();
        }
        boolean placed = false;
        while (!placed) {
            System.out.println("Wohin möchtest du deinen Stein platzieren?");
            String pos = sc.nextLine();
            placed = spielfeld.place(pos, color);
        }
        this.steinAnzahl--;
        spielfeld.showBoard();
        System.out.println("Gedrehtes Spielfeld:");
        spielfeld.drehen();
    }
}
