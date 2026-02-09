import java.util.Scanner;
/**
 * Beschreiben Sie hier die Klasse spieler.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class spieler
{
    String name;
    public int steinAnzahl;
    Spiel spiel;
    String color;
    spielbrett spielfeld;
    Scanner sc = new Scanner(System.in);
    /**
     * Konstruktor für Objekte der Klasse spieler
     */
    public spieler(String name, String color, spielbrett spielfeld, Spiel spiel)
    {
        this.name = name;
        this.steinAnzahl = 8;
        this.spiel = spiel;
        this.spielfeld = spielfeld;
        this.color = color;
    }
    void zug() {
        System.out.println(name + " ist am Zug.");
        boolean moved = false;
        boolean show = true;
        while (!moved) {
            if (spiel.spieler[0].steinAnzahl == 8 && spiel.spieler[1].steinAnzahl == 8) {
                moved = true;
                break;
            }
            System.out.println("Möchtest du einen Stein deines Gegners bewegen? Gib seine Position ein oder schreibe 'skip'!");
            String pos = sc.nextLine();
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
            stein stein = new stein(color);
            placed = spielfeld.place(pos, stein);
            
            //stein stein = new stein();
            
        }
        this.steinAnzahl--;
        spielfeld.showBoard();
        System.out.println("Gedrehtes Spielfeld:");
        spielfeld.spielfeld = spielfeld.orbito.drehen(spielfeld.spielfeld);
    }
}
