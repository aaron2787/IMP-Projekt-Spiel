import java.util.*;
/**
 * Beschreiben Sie hier die Klasse spielbrett.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class spielbrett
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    // Definiert ein Tupel (x,y)
    

    public stein[][] spielfeld;
    /**
     * Konstruktor für Objekte der Klasse spielbrett
     */
    public spielbrett()
    {
        // Instanzvariable initialisieren
        spielfeld = new stein[4][4];
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    
    public void drehen() {
        stein f = spielfeld[0][0];
        for (int i = 0; i < 3; i++) {
            stein o = spielfeld[i+1][0];
            spielfeld[i+1][0] = f;
            f = o;
        }
        for (int i = 0; i < 3; i++) {
            stein o = spielfeld[3][i+1];
            spielfeld[3][i+1] = f;
            f = o;
        }
        for (int i = 3; i > 0; i--) {
            stein o = spielfeld[i-1][3];
            spielfeld[i-1][3] = f;
            f = o;
        }
        for (int i = 3; i > 0; i--) {
            stein o = spielfeld[0][i-1];
            spielfeld[0][i-1] = f;
            f = o;
        }
        f = spielfeld[1][1];

        spielfeld[1][1] = spielfeld[1][2];
        spielfeld[1][2] = spielfeld[2][2];
        spielfeld[2][2] = spielfeld[2][1];
        spielfeld[2][1] = f;
    }
    
    boolean place(String pos, String color) {
        int[] p = parsePos(pos);
        if (p==null) {
            return false;
        }
        int row = p[0];
        int clm = p[1];        
        spielfeld[row][clm] = new stein(color);
        return true;
    }
    
    int[] parsePos(String pos) {
        if (pos.length()>2) {
            System.out.println("Ungültige Eingabe, versuche es erneut!");
            return null;
        }
        int row = Character.toUpperCase(pos.charAt(0)) - 'A';
        int clm = pos.charAt(1) - '1';
        if (row < 0 || row > 3 || clm < 0 || clm > 3) {
            System.out.println("Dieses Feld existiert nicht, versuche es erneut!");
            return null;
        }
        return new int[] {row,clm};
    }

    boolean move(String pos, String color) {
        int[] p = parsePos(pos);
        if (p==null) {
            return false;
        }
        int row = p[0];
        int clm = p[1];  
        if (spielfeld[row][clm] == null) {
            System.out.println("Hier ist kein Stein! Gib ein anderes Feld ein!");
            return false;
        }
        if (spielfeld[row][clm].color == color) {
            System.out.println("Du kannst nur Figuren deines Gegners bewegen! Gib ein anderes Feld ein!");
            return false;
        }
        boolean moved = false;
        while (!moved) {
            System.out.print("In welche Richtung möchtest du den Stein bewegen? (l / r / o / u / exit)");
            String dir = System.console().readLine();
            if (dir.toLowerCase() == "l") {
                spielfeld[row][clm-1] = spielfeld[row][clm];
                spielfeld[row][clm] = null;
                moved = true;
            } else if (dir.toLowerCase() == "r") {
                spielfeld[row][clm+1] = spielfeld[row][clm];
                spielfeld[row][clm] = null;
                moved = true;
            } else if (dir.toLowerCase() == "o") {
                spielfeld[row-1][clm] = spielfeld[row][clm];
                spielfeld[row][clm] = null;
                moved = true;
            } else if (dir.toLowerCase() == "u") {
                spielfeld[row+1][clm] = spielfeld[row][clm];
                spielfeld[row][clm] = null;
                moved = true;
            } else if (dir.toLowerCase() == "exit"){
                return false;
            } else {
                System.out.print("Ungültige Eingabe - Versuche es erneut!");
            }
        }
        return true;
    }
}
