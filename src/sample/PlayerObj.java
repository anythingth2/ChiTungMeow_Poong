package sample;

import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

/**
 * Created by ChiChaChai on 29/3/2560.
 */
abstract public class PlayerObj extends ObjSprite implements Direction {


    private String name;
    private ImageView characterCore;


    private double running_velo = 7;
    private int amountBomb;
    private double distanceBomb;
    private int hp;
    private boolean canKickBomb;

    private KeyCode moveUPkey;
    private KeyCode moveRIGHTkey;
    private KeyCode moveDownkey;
    private KeyCode moveLEFTkey;


    public PlayerObj(String character) {
        this.name = name;
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

        return true;
    }
}
