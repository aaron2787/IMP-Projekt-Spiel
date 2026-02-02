import javax.sound.sampled.*;
import java.io.File;

public class Music {

    public Music() {
        try {
            File song = new File("orbito-theme-1(wav).wav");
            AudioInputStream stream = AudioSystem.getAudioInputStream(song);

            Clip play = AudioSystem.getClip();
            play.open(stream);

            play.loop(Clip.LOOP_CONTINUOUSLY);
            play.start();

        } catch (Exception e) {
            
        }
    }
}