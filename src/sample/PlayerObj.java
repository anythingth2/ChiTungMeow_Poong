package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

/**
 * Created by ChiChaChai on 29/3/2560.
 */
abstract public class PlayerObj extends ObjSprite implements Direction {


    private String name;
    private ImageView characterCore;

    public Timeline Up = new Timeline();
    public Timeline Down = new Timeline();
    public Timeline Right = new Timeline();
    public Timeline Left = new Timeline();

    private double running_velo = 3;
    private int amountBomb;
    private double distanceBomb;
    private int hp;
    private boolean canKickBomb;

    private KeyCode moveUPkey;
    private KeyCode moveRIGHTkey;
    private KeyCode moveDownkey;
    private KeyCode moveLEFTkey;

    private int i,n;
    private String[] charUp;
    private String[] charLeft;
    private String[] charRight;
    private String[] charDown;
    private double duration =0.0;



    public PlayerObj(String name, String character) {
        this.name = name;

        if(character=="cat")
            characterCore = new ImageView(ImgSprite.catDown[0]);
        else if(character=="dog")
            characterCore = new ImageView(ImgSprite.dogDown[0]);
        else if(character=="rabbit")
            characterCore = new ImageView(ImgSprite.rabbitDown[0]);
        else if (character=="poring")
            characterCore = new ImageView(ImgSprite.poringDown[0]);

        moveUPkey = getMoveUPkey();
        moveRIGHTkey = getMoveRIGHTkey();
        moveDownkey = getMoveDownkey();
        moveLEFTkey = getMoveLEFTkey();

        setAnimation(character);

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

    public double getDistanceBomb() {
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

    public void setDistanceBomb(double distanceBomb) {
        this.distanceBomb = distanceBomb;
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

        update();
    }

    public void update() {
        characterCore.relocate(getX(), getY());
    }

    public void deployBomb() {

    }

    public void die() {

    }


    @Override
    public boolean checkMovable() {
        return true;
    }

    public void setAnimation(String character){

        if(character=="cat"){
            charUp =ImgSprite.catUp;
            charLeft = ImgSprite.catLeft;
            charRight =ImgSprite.catRight;
            charDown =ImgSprite.catDown;
            duration =150.0;
            n =4;
        }
        else if(character=="dog"){
            charUp =ImgSprite.dogUp;
            charLeft =ImgSprite.dogLeft;
            charRight =ImgSprite.dogRight;
            charDown =ImgSprite.dogDown;
            duration =150.0;
            n =3;
        }
        else if(character=="rabbit"){
            charUp =ImgSprite.rabbitUp;
            charLeft =ImgSprite.rabbitLeft ;
            charRight =ImgSprite.rabbitRight;
            charDown =ImgSprite.rabbitDown;
            duration =150.0;
            n =6;
        }
        else if (character=="poring"){
            charUp =ImgSprite.poringUp;
            charLeft =ImgSprite.poringLeft;
            charRight =ImgSprite.poringRight;
            charDown =ImgSprite.poringDown;
            duration =150;
            n =6;
        }


        Up.setCycleCount(Timeline.INDEFINITE);
        Up.getKeyFrames().add(new KeyFrame(Duration.millis(duration), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (i < n) {
                    characterCore.setImage(new Image(""+charUp[i]));
                    i++;
                }
                else {
                    characterCore.setImage(new Image(""+charUp[0]));
                    i = 1;

                }
            }

        }));

        Down.setCycleCount(Timeline.INDEFINITE);
        Down.getKeyFrames().add(new KeyFrame(Duration.millis(duration), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (i < n) {
                    characterCore.setImage(new Image(""+charDown[i]));
                    i++;
                }
                else {
                    characterCore.setImage(new Image(""+charDown[0]));
                    i = 1;

                }
            }

        }));

        Left.setCycleCount(Timeline.INDEFINITE);
        Left.getKeyFrames().add(new KeyFrame(Duration.millis(duration), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (i < n) {
                    characterCore.setImage(new Image(""+charLeft[i]));
                    i++;
                }
                else {
                    characterCore.setImage(new Image(""+charLeft[0]));
                    i = 1;

                }
            }

        }));

        Right.setCycleCount(Timeline.INDEFINITE);
        Right.getKeyFrames().add(new KeyFrame(Duration.millis(150), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (i < n) {
                    characterCore.setImage(new Image(""+charRight[i]));
                    i++;
                }
                else {
                    characterCore.setImage(new Image(""+charRight[0]));
                    i = 1;

                }
            }

        }));
    }

    public void StopAnimation(){
        Up.stop();
        Right.stop();
        Left.stop();
        Down.stop();
    }


}
