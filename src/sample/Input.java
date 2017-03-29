package sample;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Created by ChiChaChai on 30/3/2560.
 */
public class Input {
    private Scene scene;
    private PlayerObj playerObj;

    private KeyCode keyPressing;

    public Input(Scene scene, PlayerObj playerObj) {
        this.scene = scene;
        this.playerObj = playerObj;
        addOnKeyPressListener();
        addOnKeyReleasedListener();
    }

    public void addOnKeyPressListener() {
        scene.setOnKeyPressed(event -> keyPressing = event.getCode());
    }

    public void addOnKeyReleasedListener() {
        scene.setOnKeyReleased(event -> keyPressing = null);
    }

    public boolean isMoveUp() {

        return keyPressing == playerObj.getMoveUPkey();
    }

    public boolean isMoveRight() {
        return keyPressing == playerObj.getMoveRIGHTkey();
    }

    public boolean isMoveDown() {
        return keyPressing == playerObj.getMoveDownkey();
    }

    public boolean isMoveLeft() {
        return keyPressing == playerObj.getMoveLEFTkey();
    }
}