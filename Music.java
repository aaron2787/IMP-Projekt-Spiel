import javax.sound.sampled.*;
import java.io.File;
public class Music {
    public Music() {
        try {
            File song = new File("Orbito_Theme.wav");
            AudioInputStream stream = AudioSystem.getAudioInputStream(song);
            Clip play = AudioSystem.getClip();
            play.open(stream);
            play.loop(Clip.LOOP_CONTINUOUSLY);
            play.start();
        } catch (Exception e) {
             
        }
    }
}