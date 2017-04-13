package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


/**
 * Created by ChiChaChai on 29/3/2560.
 */
abstract public class PlayerObj extends ObjSprite implements Direction, Sound {

    private String type = "";
    private ImageView characterCore;


    private double running_velo = 3;
    private int amountBomb = 5;
    private int distanceBomb = 3;
    private int hp = 100;
    private boolean canKickBomb;
    private boolean isDead = false;

    private KeyCode moveUPkey;
    private KeyCode moveRIGHTkey;
    private KeyCode moveDownkey;
    private KeyCode moveLEFTkey;


    public Timeline Up = new Timeline();
    public Timeline Down = new Timeline();
    public Timeline Right = new Timeline();
    public Timeline Left = new Timeline();


    private int ig, n;
    private String[] charUp;
    private String[] charLeft;
    private String[] charRight;
    private String[] charDown;
    private double duration = 0.0;
    private Pane pane;

    int[] runBoomEff;
    int i;


    public PlayerObj(Pane pane, String type) {
        runBoomEff = new int[4 * distanceBomb];
        this.pane = pane;
        this.type = type;

        if (type == "CAT")
            characterCore = new ImageView(SourceDir.CAT_DOWN[0]);
        else if (type == "DOG")
            characterCore = new ImageView(SourceDir.DOG_DOWN[0]);
        else if (type == "RABBIT")
            characterCore = new ImageView(SourceDir.RABBIT_DOWN[0]);
        else if (type == "PORING")
            characterCore = new ImageView(SourceDir.PORING_DOWN[0]);
        moveUPkey = getMoveUPkey();
        moveRIGHTkey = getMoveRIGHTkey();
        moveDownkey = getMoveDownkey();
        moveLEFTkey = getMoveLEFTkey();
        characterCore.setFitHeight(SaveMap.getHeightEachSprite());
        characterCore.setFitWidth(SaveMap.getWidthEachSprite());

        setAnimation(this.type);
    }

    public ImageView getCharacterCore() {
        return characterCore;
    }

    public double getRunning_velo() {
        return running_velo;
    }

    public int getAmountBomb() {
        return amountBomb;
    }

    public int getDistanceBomb() {
        return distanceBomb;
    }

    public int getHp() {
        return hp;
    }

    public boolean isCanKickBomb() {
        return canKickBomb;
    }

    public void setCharacterCore(ImageView characterCore) {
        this.characterCore = characterCore;
    }

    public void setRunning_velo(double running_velo) {
        this.running_velo = running_velo;
    }

    public void setAmountBomb(int amountBomb) {
        this.amountBomb = amountBomb;
    }

    public void setDistanceBomb(int distanceBomb) {
        this.distanceBomb = distanceBomb;
        runBoomEff = new int[4 * distanceBomb];
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
        setAnimation(type);
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setCanKickBomb(boolean canKickBomb) {
        this.canKickBomb = canKickBomb;
    }

    abstract public KeyCode getMoveUPkey();

    abstract public KeyCode getMoveRIGHTkey();

    abstract public KeyCode getMoveDownkey();

    abstract public KeyCode getMoveLEFTkey();

    abstract public KeyCode getDeployBombKey();

    public void setMoveUPkey(KeyCode moveUPkey) {
        this.moveUPkey = moveUPkey;
    }

    public void setMoveRIGHTkey(KeyCode moveRIGHTkey) {
        this.moveRIGHTkey = moveRIGHTkey;
    }

    public void setMoveDownkey(KeyCode moveDownkey) {
        this.moveDownkey = moveDownkey;
    }

    public void setMoveLEFTkey(KeyCode moveLEFTkey) {
        this.moveLEFTkey = moveLEFTkey;
    }

    public boolean isDead() {
        return isDead;
    }

    @Override
    public double getX() {
        return characterCore.getX();
    }

    @Override
    public double getY() {
        return characterCore.getY();
    }

    @Override
    public void setX(double x) {
        characterCore.setX(x);
    }

    @Override
    public void setY(double y) {
        characterCore.setY(y);
    }

    public void move(int direction) {
        switch (direction) {
            case UP:
                setY(getY() - running_velo);
                break;
            case RIGHT:
                setX(getX() + running_velo);
                break;
            case DOWN:
                setY(getY() + running_velo);
                break;
            case LEFT:
                setX(getX() - running_velo);
                break;
        }


    }


    public void deployBomb() {
        if (!isCanDeployBomb()) return;
        DEPLOYBOMB_SOUNDEFFECT.play();
        amountBomb--;
        ImageView bomb = new ImageView(SourceDir.BOMB_OBJ);
        ImageView[] boom = new ImageView[4 * distanceBomb];

        for (int i = 0; i < 4 * distanceBomb; i += 4) {
            boom[i] = new ImageView();
            boom[i].setX(characterCore.getX());
            boom[i].setY(characterCore.getY() - SaveMap.getHeightEachSprite() * (i / 4) * 0.75);
            pane.getChildren().add(boom[i]);

            boom[i + 1] = new ImageView();
            boom[i + 1].setX(characterCore.getX() + SaveMap.getWidthEachSprite() * (i / 4) * 0.75);
            boom[i + 1].setY(characterCore.getY());
            pane.getChildren().add(boom[i + 1]);

            boom[i + 2] = new ImageView();
            boom[i + 2].setX(characterCore.getX());
            boom[i + 2].setY(characterCore.getY() + SaveMap.getHeightEachSprite() * (i / 4) * 0.75);
            pane.getChildren().add(boom[i + 2]);

            boom[i + 3] = new ImageView();

            boom[i + 3].setX(characterCore.getX() - SaveMap.getWidthEachSprite() * (i / 4) * 0.75);
            boom[i + 3].setY(characterCore.getY());
            pane.getChildren().add(boom[i + 3]);
        }

        bomb.setFitWidth(SaveMap.getWidthEachSprite());
        bomb.setFitHeight(SaveMap.getHeightEachSprite());
        bomb.setX(characterCore.getX());
        bomb.setY(characterCore.getY());

        pane.getChildren().add(bomb);
        Timeline boomEffMain = new Timeline();

        boomEffMain.getKeyFrames().add(new KeyFrame(Duration.millis(75), event -> {
            bomb.setImage(new Image(SourceDir.BOOM_EFF[i++]));
        }));

        boomEffMain.setOnFinished(event -> pane.getChildren().remove(bomb));
        boomEffMain.setCycleCount(6);

        Timeline timeLeft = new Timeline(new KeyFrame(Duration.seconds(1)));
        timeLeft.setOnFinished((ActionEvent event) -> {
            amountBomb++;
            BOOM_SOUNDEFFECT.play();
            new BoomEffect(pane, bomb).start();
            for (int j = 0; j < 4 * distanceBomb; j++)
                new BoomEffect(pane, boom[j]).start();


        });


        timeLeft.playFromStart();


    }

    public void die() {
        characterCore.setVisible(false);

        isDead = true;
    }


    @Override
    public boolean checkMovable() {
        return true;
    }

    public boolean isOverlapWithMap() {
        double rate = 0.75;
        double px = getX() + SaveMap.getWidthEachSprite() * (1 - rate);
        double py = getY() + SaveMap.getHeightEachSprite() * (1 - rate);
        double pWidth = SaveMap.getWidthEachSprite() * rate;
        double pHeight = SaveMap.getHeightEachSprite() * rate;

        double mapx;
        double mapy;
        double mapWidth = SaveMap.getWidthEachSprite() * rate;
        double mapHeight = SaveMap.getHeightEachSprite() * rate;

        for (int i = 0; i < SaveMap.mapObj.length; i++)
            for (int j = 0; j < SaveMap.mapObj[i].length; j++) {
                mapx = SaveMap.mapObj[i][j].getItemCore().getX() + SaveMap.getWidthEachSprite() * (1 - rate);
                mapy = SaveMap.mapObj[i][j].getItemCore().getY() + SaveMap.getHeightEachSprite() * (1 - rate);
                if (px < mapx + mapWidth
                        && px + pWidth > mapx
                        && py < mapy + mapHeight
                        && py + pHeight > mapy
                        && !SaveMap.mapObj[i][j].isDestroyed()) {
                    return true;
                }
            }
        return false;
    }

    public boolean isCanDeployBomb() {

        return amountBomb > 0;
    }

    public boolean isOverlapWithBorder() {

        return getX() < 0
                || getX() + SaveMap.getWidthEachSprite() > Game.getWidth()
                || getY() < 0
                || getY() + SaveMap.getHeightEachSprite() > Game.getHeight();
    }

    public void wasTakenDamage() {
        setHp(getHp() - 1);
        if (getHp() <= 0)
            die();
    }

    public void setAnimation(String character) {

        if (character == "CAT") {
            charUp = SourceDir.CAT_UP;
            charLeft = SourceDir.CAT_LEFT;
            charRight = SourceDir.CAT_RIGHT;
            charDown = SourceDir.CAT_DOWN;
            duration = 150.0;
            n = 4;
        } else if (character == "DOG") {
            charUp = SourceDir.DOG_UP;
            charLeft = SourceDir.DOG_LEFT;
            charRight = SourceDir.DOG_RIGHT;
            charDown = SourceDir.DOG_DOWN;
            duration = 150.0;
            n = 3;
        } else if (character == "RABBIT") {
            charUp = SourceDir.RABBIT_UP;
            charLeft = SourceDir.RABBIT_LEFT;
            charRight = SourceDir.RABBIT_RIGHT;
            charDown = SourceDir.RABBIT_DOWN;
            duration = 150.0;
            n = 6;
        } else if (character == "PORING") {
            charUp = SourceDir.PORING_UP;
            charLeft = SourceDir.PORING_LEFT;
            charRight = SourceDir.PORING_RIGHT;
            charDown = SourceDir.PORING_DOWN;
            duration = 150;
            n = 6;
        }

        Up = new Timeline();
        Right = new Timeline();
        Down = new Timeline();
        Left = new Timeline();


        Up.setCycleCount(Timeline.INDEFINITE);
        Up.getKeyFrames().add(new KeyFrame(Duration.millis(duration), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (ig < n) {
                    characterCore.setImage(new Image("" + charUp[ig]));
                    ig++;
                } else {
                    characterCore.setImage(new Image("" + charUp[0]));
                    ig = 1;

                }
            }

        }));

        Down.setCycleCount(Timeline.INDEFINITE);
        Down.getKeyFrames().add(new KeyFrame(Duration.millis(duration), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (ig < n) {
                    characterCore.setImage(new Image("" + charDown[ig]));
                    ig++;
                } else {
                    characterCore.setImage(new Image("" + charDown[0]));
                    ig = 1;

                }
            }

        }));

        Left.setCycleCount(Timeline.INDEFINITE);
        Left.getKeyFrames().add(new KeyFrame(Duration.millis(duration), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (ig < n) {
                    characterCore.setImage(new Image("" + charLeft[ig]));
                    ig++;
                } else {
                    characterCore.setImage(new Image("" + charLeft[0]));
                    ig = 1;

                }
            }

        }));

        Right.setCycleCount(Timeline.INDEFINITE);
        Right.getKeyFrames().add(new KeyFrame(Duration.millis(150), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (ig < n) {
                    characterCore.setImage(new Image("" + charRight[ig]));
                    ig++;
                } else {
                    characterCore.setImage(new Image("" + charRight[0]));
                    ig = 1;

                }
            }

        }));
    }

    public void StopAnimation() {
        Up.stop();
        Right.stop();
        Left.stop();
        Down.stop();
    }

}
