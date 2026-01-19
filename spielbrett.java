import java.util.Scanner;
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
    
    public spieler[] spieler;
    public stein[][] spielfeld;
    Scanner sc = new Scanner(System.in);
    /**
     * Konstruktor für Objekte der Klasse spielbrett
     */
    public spielbrett()
    {
        // Instanzvariable initialisieren
        this.spielfeld = new stein[4][4];
        System.out.println("Spiel gestartet. Wie heißt Spieler 1? ");
        String name = sc.nextLine();
        spieler s1 = new spieler(name, "w", this);
        System.out.println("Hallo " + name + ", wie heißt dein Mitspieler? ");
        name = sc.nextLine();
        spieler s2 = new spieler(name, "s", this);
        this.spieler = new spieler[] {s1, s2};
        spiel();
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    private void spiel() {
        int spIdx = 0;
        while(spieler[0].steinAnzahl > 0 && spieler[0].steinAnzahl > 0) {
            spieler[spIdx].zug();
            showBoard();
            spIdx = (spIdx+1) % 2;
        }
    }
    
    public void showBoard() {
        System.out.println();
        System.out.println("  A B C D");
        String zeile;
        for (int i = 0; i < 4; i++) {
            zeile = "" + (i+1);
            for (int j = 0; j < 4; j++) {
                if (spielfeld[i][j] == null) {
                    zeile = zeile + " .";                    
                } else {
                    zeile = zeile + " " + spielfeld[i][j].color;   
                }
            }
            System.out.println(zeile);
        }
        System.out.println();
    }
    
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
        int clm = Character.toUpperCase(pos.charAt(0)) - 'A';
        int row = pos.charAt(1) - '1';
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
            System.out.println("In welche Richtung möchtest du den Stein bewegen? (l / r / u / d / exit)");
            String dir = sc.nextLine();
            if (dir.equalsIgnoreCase("l")) {
                if(spielfeld[row][clm-1] != null) {
                    System.out.println("Dieses Feld ist belegt!");
                    break;
                }
                spielfeld[row][clm-1] = spielfeld[row][clm];
                spielfeld[row][clm] = null;
                moved = true;
            } else if (dir.equalsIgnoreCase("r")) {
                if(spielfeld[row][clm+1] != null) {
                    System.out.println("Dieses Feld ist belegt!");
                    break;
                }
                spielfeld[row][clm+1] = spielfeld[row][clm];
                spielfeld[row][clm] = null;
                moved = true;
            } else if (dir.equalsIgnoreCase("u")) {
                if(spielfeld[row-1][clm] != null) {
                    System.out.println("Dieses Feld ist belegt!");
                    break;
                }
                spielfeld[row-1][clm] = spielfeld[row][clm];
                spielfeld[row][clm] = null;
                moved = true;
            } else if (dir.equalsIgnoreCase("d")) {
                if(spielfeld[row+1][clm] != null) {
                    System.out.println("Dieses Feld ist belegt!");
                    break;
                }
                spielfeld[row+1][clm] = spielfeld[row][clm];
                spielfeld[row][clm] = null;
                moved = true;
            } else if (dir.equalsIgnoreCase("exit")){
                return false;
            } else {
                System.out.print("Ungültige Eingabe - Versuche es erneut!");
            }
        }
        return true;
    }
}
