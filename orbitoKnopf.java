
/**
 * Beschreiben Sie hier die Klasse orbitoKnopf.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class orbitoKnopf
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen

    /**
     * Konstruktor für Objekte der Klasse orbitoKnopf
     */
    public orbitoKnopf()
    {    
        
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public stein[][] drehen(stein[][] spielfeld) {
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
        return spielfeld;
    }    
}
