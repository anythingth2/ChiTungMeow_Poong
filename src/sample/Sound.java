package sample;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import javafx.scene.media.AudioClip;

/**
 * Created by ChiChaChai on 29/3/2560.
 */
public interface Sound {

    AudioClip soundMyNoise = new AudioClip(new File("noises/roll.wav").toURI().toString());
    //soundMyNoise.play();
    //ใส่ไฟล์เพลงแล้วลองรันดู
}
