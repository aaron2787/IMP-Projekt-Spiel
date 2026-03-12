public class orbitoKnopf {
    public orbitoKnopf() {}
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