package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * Created by ChiChaChai on 29/3/2560.
 */
public class MapObj extends ObjSprite {

    private ImageView itemCore;

    private boolean isPassable = false;
    private boolean isDestroyed = false;
    private boolean isDestoryable = false;
    private boolean isItem;
    private String type = "";
    private String typeItem;
    private boolean isItemReadyToTake = false;

    public MapObj() {
        itemCore = new ImageView();
        itemCore.setVisible(false);
        isPassable = true;
        isDestoryable = false;
        itemCore.setFitHeight(SaveMap.getHeightEachSprite());
        itemCore.setFitWidth(SaveMap.getWidthEachSprite());
    }

    public MapObj(String imgSprite, boolean isPassable, boolean isDestoryable) {
        itemCore = new ImageView(imgSprite);
        itemCore.setFitHeight(SaveMap.getHeightEachSprite());
        itemCore.setFitWidth(SaveMap.getWidthEachSprite());
        this.isPassable = isPassable;
        this.type = imgSprite;
        this.isItem = false;
        this.isDestoryable=isDestoryable;
    }


    public MapObj(String imgSprite, String typeItem, boolean isPassable, boolean isDestoryable) {
        this(imgSprite, isPassable, isDestoryable);
        this.isItem = true;
        this.typeItem = typeItem;

    }


    public ImageView getItemCore() {
        return itemCore;
    }

    @Override
    public double getY() {
        return itemCore.getY();
    }

    @Override
    public double getX() {
        return itemCore.getX();
    }

    public String getType() {
        return type;
    }

    public boolean isDestoryable() {
        return isDestoryable;
    }

    public boolean isPassable() {
        return isPassable;
    }

    public void setPassable(boolean passable) {
        isPassable = passable;
    }

    public void appear() {

        itemCore.setVisible(true);
        isDestroyed = false;
    }

    public void destroy() {

        itemCore.setVisible(false);
        isDestroyed = true;
        isPassable = true;
        isItem = false;
        isDestoryable = false;
        isItemReadyToTake = false;

    }

    public void transformToItem() {

        if (isItem) {
            itemCore.setImage(new Image(typeItem));
            isItemReadyToTake = true;
        }
    }

    public boolean isVisible() {
        return itemCore.isVisible();
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public boolean isItem() {
        return isItem;
    }

    public boolean isItemReadyToTake() {
        return isItemReadyToTake;
    }

    public void setVisible(boolean b) {
        itemCore.setVisible(b);
    }

    @Override
    public boolean checkMovable() {
        return false;
    }

    public String getTypeItem() {
        return typeItem;
    }
}
