package sample;

import javafx.scene.media.AudioClip;

import java.io.File;

/**
 * Created by ChiChaChai on 29/3/2560.
 */
public interface Sound {

    AudioClip BACKGROUND_MUSIC = new AudioClip(new File(SourceDir.BGM).toURI().toString());
    AudioClip DEPLOYBOMB_SOUNDEFFECT = new AudioClip(new File(SourceDir.DEPLOY_BOMB_SOUND_EFF).toURI().toString());
    AudioClip BOOM_SOUNDEFFECT = new AudioClip(new File(SourceDir.BOOM_SOUND_EFF).toURI().toString());
}
