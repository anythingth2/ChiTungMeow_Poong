package sample;

import javafx.scene.image.ImageView;


/**
 * Created by ChiChaChai on 29/3/2560.
 */
public class MapObj extends ObjSprite {

    private ImageView itemCore;
    private boolean isNothing;
    private boolean isDestroyed = false;
    private boolean isItem;
private String type="";
    public MapObj(boolean isItem) {
        itemCore = new ImageView();
        itemCore.setVisible(false);
        isNothing = true;
        itemCore.setFitHeight(SaveMap.getHeightEachSprite());
        itemCore.setFitWidth(SaveMap.getWidthEachSprite());
        this.isItem = isItem;
    }

    public MapObj(String imgSprite, boolean isItem) {
        itemCore = new ImageView(imgSprite);
        isNothing = false;
        itemCore.setFitHeight(SaveMap.getHeightEachSprite());
        itemCore.setFitWidth(SaveMap.getWidthEachSprite());
        this.isItem = isItem;
        this.type = imgSprite;
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

    public void appear() {

        itemCore.setVisible(true);
        isDestroyed = false;
    }

    public void destroy() {

        itemCore.setVisible(false);
        isDestroyed = true;

    }

    public boolean isNothing() {
        return isNothing;
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

    public void setVisible(boolean b) {
        itemCore.setVisible(b);
    }

    @Override
    public boolean checkMovable() {
        return false;
    }
}
