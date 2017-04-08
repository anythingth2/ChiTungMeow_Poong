package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

/**
 * Created by ChiChaChai on 30/3/2560.
 */
public class Input {
    private Scene scene;
    private PlayerObj playerObj;
    private PlayerObj playerObj2;
    private KeyCode keyPressing;
    private boolean isMoveUp1 = false;
    private boolean isMoveLeft1 = false;
    private boolean isMoveDown1 = false;
    private boolean isMoveRight1 = false;
    private boolean isDeployBomb1 = false;
    private boolean isMoveUp2 = false;
    private boolean isMoveLeft2 = false;
    private boolean isMoveDown2 = false;
    private boolean isMoveRight2 = false;
    private boolean isDeployBomb2 = false;
    private Timeline timeline = new Timeline();

    public Input(Scene scene, PlayerObj playerObj, PlayerObj playerObj2) {
        this.scene = scene;
        this.playerObj = playerObj;
        this.playerObj2 = playerObj2;
        addOnKeyPressListener();
        addOnKeyReleasedListener();
    }

    public void addOnKeyPressListener() {
        scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                //if (keyPressing != event.getCode()) {
                keyPressing = event.getCode();
                if (isPlayer1Key(keyPressing)) {

                    isMoveUp1 = keyPressing == playerObj.getMoveUPkey();

                    isMoveRight1 = keyPressing == playerObj.getMoveRIGHTkey();

                    isMoveDown1 = keyPressing == playerObj.getMoveDownkey();

                    isMoveLeft1 = keyPressing == playerObj.getMoveLEFTkey();

                    isDeployBomb1 = keyPressing == playerObj.getDeployBombKey();
                } else {

                    isMoveUp2 = keyPressing == playerObj2.getMoveUPkey();

                    isMoveRight2 = keyPressing == playerObj2.getMoveRIGHTkey();

                    isMoveDown2 = keyPressing == playerObj2.getMoveDownkey();

                    isMoveLeft2 = keyPressing == playerObj2.getMoveLEFTkey();

                    isDeployBomb2 = keyPressing == playerObj2.getDeployBombKey();
                }
            }
        });
//        scene.setOnKeyPressed(event -> {
//
//        });
    }

    public void addOnKeyReleasedListener() {
        scene.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                //keyPressing = null;
                if (isPlayer1Key(event.getCode())) {

                    isMoveUp1 = false;
                    isMoveRight1 = false;
                    isMoveDown1 = false;
                    isMoveLeft1 = false;
                    isDeployBomb1 = false;
                }
                if (isPlayer2Key(event.getCode())) {

                    isMoveUp2 = false;
                    isMoveRight2 = false;
                    isMoveDown2 = false;
                    isMoveLeft2 = false;
                    isDeployBomb2 = false;
                }
                System.out.println("Clear");
            }
        });
    }

    public boolean isPlayer1Key(KeyCode k) {
        return k == playerObj.getMoveUPkey()
                || k == playerObj.getMoveRIGHTkey()
                || k == playerObj.getMoveDownkey()
                || k == playerObj.getMoveLEFTkey()
                || k == playerObj.getDeployBombKey();
    }

    public boolean isPlayer2Key(KeyCode k) {
        return k == playerObj2.getMoveUPkey()
                || k == playerObj2.getMoveRIGHTkey()
                || k == playerObj2.getMoveDownkey()
                || k == playerObj2.getMoveLEFTkey()
                || k == playerObj2.getDeployBombKey();
    }

    public void startLoopInput() {
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(1000 / 60),
                event -> {
                    if (isMoveUp1) {
                        playerObj.move(Direction.UP);
                        if (playerObj.isOverlapWithMap())
                            playerObj.move(Direction.DOWN);
                    }
                    if (isMoveRight1) {
                        playerObj.move(Direction.RIGHT);
                        if (playerObj.isOverlapWithMap())
                            playerObj.move(Direction.LEFT);
                    }
                    if (isMoveDown1) {
                        playerObj.move(Direction.DOWN);
                        if (playerObj.isOverlapWithMap())
                            playerObj.move(Direction.UP);
                    }
                    if (isMoveLeft1) {
                        playerObj.move(Direction.LEFT);
                        if (playerObj.isOverlapWithMap())
                            playerObj.move(Direction.RIGHT);
                    }

                    if (isDeployBomb1) {
                        if (playerObj.isCanDeployBomb())
                            playerObj.deployBomb();
                    }

                    if (isMoveUp2) {
                        playerObj2.move(Direction.UP);
                        if (playerObj2.isOverlapWithMap())
                            playerObj2.move(Direction.DOWN);
                    }
                    if (isMoveRight2) {
                        playerObj2.move(Direction.RIGHT);
                        if (playerObj2.isOverlapWithMap())
                            playerObj2.move(Direction.LEFT);
                    }
                    if (isMoveDown2) {
                        playerObj2.move(Direction.DOWN);
                        if (playerObj2.isOverlapWithMap())
                            playerObj2.move(Direction.UP);
                    }
                    if (isMoveLeft2) {
                        playerObj2.move(Direction.LEFT);
                        if (playerObj2.isOverlapWithMap())
                            playerObj2.move(Direction.RIGHT);
                    }

                    if (isDeployBomb2) {
                        if (playerObj2.isCanDeployBomb())
                            playerObj2.deployBomb();
                    }

                }
        ));
        timeline.playFromStart();
    }
}
