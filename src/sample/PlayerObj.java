package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


/**
 * Created by ChiChaChai on 29/3/2560.
 */
abstract public class PlayerObj extends ObjSprite implements Direction {


    private String name;
    private ImageView characterCore;


    private double running_velo = 7;
    private int amountBomb = 5;
    private int distanceBomb = 5;
    private int hp;
    private boolean canKickBomb;

    private KeyCode moveUPkey;
    private KeyCode moveRIGHTkey;
    private KeyCode moveDownkey;
    private KeyCode moveLEFTkey;

    private Pane pane;
    //private ImageView bomb = new ImageView();

    int[] runBoomEff;
    int i;

    public PlayerObj(Pane pane, String character) {
        runBoomEff = new int[4 * distanceBomb];
        this.pane = pane;


        characterCore = new ImageView(character);
        moveUPkey = getMoveUPkey();
        moveRIGHTkey = getMoveRIGHTkey();
        moveDownkey = getMoveDownkey();
        moveLEFTkey = getMoveLEFTkey();
        characterCore.setFitHeight(SaveMap.getHeightEachSprite());
        characterCore.setFitWidth(SaveMap.getWidthEachSprite());
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

    public void setName(String name) {
        this.name = name;
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

    public String getName() {
        return name;
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

        //update();
    }

    public void update() {
        characterCore.relocate(getX(), getY());
    }

    public void deployBomb() {
        if (!isCanDeployBomb()) return;

        amountBomb--;
        ImageView bomb = new ImageView(ImgSprite.bombObj);
        ImageView[] boom = new ImageView[4 * distanceBomb];

        for (int i = 0; i < 4 * distanceBomb; i += 4) {
            boom[i] = new ImageView();
            boom[i].setFitHeight(SaveMap.getHeightEachSprite());
            boom[i].setFitWidth(SaveMap.getWidthEachSprite());
            boom[i].setX(characterCore.getX());
            boom[i].setY(characterCore.getY() - SaveMap.getHeightEachSprite() * (i / 4));
            pane.getChildren().add(boom[i]);

            boom[i + 1] = new ImageView();
            boom[i + 1].setFitHeight(SaveMap.getHeightEachSprite());
            boom[i + 1].setFitWidth(SaveMap.getWidthEachSprite());
            boom[i + 1].setX(characterCore.getX() + SaveMap.getWidthEachSprite() * (i / 4));
            boom[i + 1].setY(characterCore.getY());
            pane.getChildren().add(boom[i + 1]);

            boom[i + 2] = new ImageView();
            boom[i + 2].setFitHeight(SaveMap.getHeightEachSprite());
            boom[i + 2].setFitWidth(SaveMap.getWidthEachSprite());
            boom[i + 2].setX(characterCore.getX());
            boom[i + 2].setY(characterCore.getY() + SaveMap.getHeightEachSprite() * (i / 4));
            pane.getChildren().add(boom[i + 2]);

            boom[i + 3] = new ImageView();
            boom[i + 3].setFitHeight(SaveMap.getHeightEachSprite());
            boom[i + 3].setFitWidth(SaveMap.getWidthEachSprite());
            boom[i + 3].setX(characterCore.getX() - SaveMap.getWidthEachSprite() * (i / 4));
            boom[i + 3].setY(characterCore.getY());
            pane.getChildren().add(boom[i + 3]);
        }

        bomb.setFitWidth(SaveMap.getWidthEachSprite());
        bomb.setFitHeight(SaveMap.getHeightEachSprite());
        bomb.setX(characterCore.getX());
        bomb.setY(characterCore.getY());

        pane.getChildren().add(bomb);
        Timeline boomEffMain = new Timeline();
        final ImageView bombfinal = bomb;
        boomEffMain.getKeyFrames().add(new KeyFrame(Duration.millis(75), event -> {
            bomb.setImage(new Image(ImgSprite.boomEff[i++]));
        }));

        boomEffMain.setOnFinished(event -> pane.getChildren().remove(bomb));
        boomEffMain.setCycleCount(6);

        Timeline timeLeft = new Timeline(new KeyFrame(Duration.seconds(1)));
        timeLeft.setOnFinished((ActionEvent event) -> {
            amountBomb++;

            new BoomEffect(pane, bomb).start();


            for (int j = 0; j < 4 * distanceBomb; j++)
                new BoomEffect(pane, boom[j]).start();


        });


        timeLeft.playFromStart();


    }

    public void die() {

    }


    @Override
    public boolean checkMovable() {
        return true;
    }

    public boolean isOverlapWithMap() {
        double px = getX();
        double py = getY();
        double pWidth = SaveMap.getWidthEachSprite();
        double pHeight = SaveMap.getHeightEachSprite();

        double mapx;
        double mapy;
        double mapWidth = SaveMap.getWidthEachSprite();
        double mapHeight = SaveMap.getHeightEachSprite();

        for (int i = 0; i < SaveMap.mapObj.length; i++)
            for (int j = 0; j < SaveMap.mapObj[i].length; j++) {
                mapx = SaveMap.mapObj[i][j].getItemCore().getX();
                mapy = SaveMap.mapObj[i][j].getItemCore().getY();
                if (px < mapx + mapWidth
                        && px + pWidth > mapx
                        && py < mapy + mapHeight
                        && py + pHeight > mapy) {
                    return true;
                }
            }
        return false;
    }

    public boolean isCanDeployBomb() {

        return amountBomb > 0;
    }


}
