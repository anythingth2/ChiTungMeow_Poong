package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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

    private boolean isDelayBombP1 = false;
    private boolean isDelayBombP2 = false;
    private Timeline delayP1 = new Timeline();
    private Timeline delayP2 = new Timeline();

    public Input(Scene scene, PlayerObj playerObj, PlayerObj playerObj2) {
        this.scene = scene;
        this.playerObj = playerObj;
        this.playerObj2 = playerObj2;
        delayP1.getKeyFrames().add(new KeyFrame(Duration.millis(250)));
        delayP1.setOnFinished(event -> isDelayBombP1 = false);

        delayP2.getKeyFrames().add(new KeyFrame(Duration.millis(250)));
        delayP2.setOnFinished(event -> isDelayBombP2 = false);


        addOnKeyPressListener();
        addOnKeyReleasedListener();
    }

    public void addOnKeyPressListener() {
        scene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {


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
        });

    }

    public void addOnKeyReleasedListener() {
        scene.addEventHandler(KeyEvent.KEY_RELEASED, event -> {

            if (isPlayer1Key(event.getCode())) {

                isMoveUp1 = false;
                isMoveRight1 = false;
                isMoveDown1 = false;
                isMoveLeft1 = false;
                isDeployBomb1 = false;
                playerObj.StopAnimation();
            }
            if (isPlayer2Key(event.getCode())) {

                isMoveUp2 = false;
                isMoveRight2 = false;
                isMoveDown2 = false;
                isMoveLeft2 = false;
                isDeployBomb2 = false;
                playerObj2.StopAnimation();
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
                    if (isMoveUp1 && !playerObj.isDead()) {
                        playerObj.move(Direction.UP);
                        playerObj.Up.play();
                        if (playerObj.isOverlapWithMap() || playerObj.isOverlapWithBorder())
                            playerObj.move(Direction.DOWN);
                    }
                    if (isMoveRight1 && !playerObj.isDead()) {
                        playerObj.move(Direction.RIGHT);
                        playerObj.Right.play();
                        if (playerObj.isOverlapWithMap() || playerObj.isOverlapWithBorder())
                            playerObj.move(Direction.LEFT);
                    }
                    if (isMoveDown1 && !playerObj.isDead()) {
                        playerObj.move(Direction.DOWN);
                        playerObj.Down.play();
                        if (playerObj.isOverlapWithMap() || playerObj.isOverlapWithBorder())
                            playerObj.move(Direction.UP);
                    }
                    if (isMoveLeft1 && !playerObj.isDead()) {
                        playerObj.move(Direction.LEFT);
                        playerObj.Left.play();
                        if (playerObj.isOverlapWithMap() || playerObj.isOverlapWithBorder())
                            playerObj.move(Direction.RIGHT);
                    }

                    if (isDeployBomb1 && !isDelayBombP1 && !playerObj.isDead()) {
                        if (playerObj.isCanDeployBomb()) {
                            playerObj.deployBomb();
                            delayDeployBombP1();
                        }
                    }

                    if (isMoveUp2 && !playerObj2.isDead()) {
                        playerObj2.move(Direction.UP);
                        playerObj2.Up.play();
                        if (playerObj2.isOverlapWithMap() || playerObj2.isOverlapWithBorder())
                            playerObj2.move(Direction.DOWN);
                    }
                    if (isMoveRight2 && !playerObj2.isDead()) {
                        playerObj2.move(Direction.RIGHT);
                        playerObj2.Right.play();
                        if (playerObj2.isOverlapWithMap() || playerObj2.isOverlapWithBorder())
                            playerObj2.move(Direction.LEFT);
                    }
                    if (isMoveDown2 && !playerObj2.isDead()) {
                        playerObj2.move(Direction.DOWN);
                        playerObj2.Down.play();
                        if (playerObj2.isOverlapWithMap() || playerObj2.isOverlapWithBorder())
                            playerObj2.move(Direction.UP);
                    }
                    if (isMoveLeft2 && !playerObj2.isDead()) {
                        playerObj2.move(Direction.LEFT);
                        playerObj2.Left.play();
                        if (playerObj2.isOverlapWithMap() || playerObj2.isOverlapWithBorder())
                            playerObj2.move(Direction.RIGHT);
                    }

                    if (isDeployBomb2 && !isDelayBombP2 && !playerObj2.isDead()) {
                        if (playerObj2.isCanDeployBomb()) {
                            playerObj2.deployBomb();
                            delayDeployBombP2();
                        }

                    }

                }
        ));
        timeline.playFromStart();
    }


    public void delayDeployBombP1() {
        isDelayBombP1 = true;
        delayP1.playFromStart();
    }

    public void delayDeployBombP2() {
        isDelayBombP2 = true;
        delayP2.playFromStart();
    }

}
