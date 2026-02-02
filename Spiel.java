import java.util.Scanner;
public class Spiel
{
    Scanner sc = new Scanner(System.in);
    spielbrett spielfeld;
    spieler[] spieler;
    public Spiel()
    {
        spielfeld = new spielbrett();
        System.out.println("Spiel gestartet. Wie heißt Spieler 1? ");
        String name = sc.nextLine();
        spieler s1 = new spieler(name, "w", spielfeld, this);
        System.out.println("Hallo " + name + ", wie heißt dein Mitspieler? ");
        name = sc.nextLine();
        spieler s2 = new spieler(name, "s",spielfeld, this);
        this.spieler = new spieler[] {s1, s2};
        spielLoop();
    }
    private void spielLoop() {
        int spIdx = 0;
        while(spieler[0].steinAnzahl > 0 && spieler[0].steinAnzahl > 0) {
            spieler[spIdx].zug();
            spielfeld.showBoard();
            spIdx = (spIdx+1) % 2;
        }
    }    
}
