package sample;

import javafx.scene.image.ImageView;


/**
 * Created by ChiChaChai on 29/3/2560.
 */
public class MapObj extends ObjSprite {

    private ImageView itemCore;
    private boolean isNothing;

    public MapObj() {
        itemCore = new ImageView();
        itemCore.setVisible(false);
        isNothing = true;
        itemCore.setFitHeight(SaveMap.getHeightEachSprite());
        itemCore.setFitWidth(SaveMap.getWidthEachSprite());
    }

    public MapObj(String imgSprite) {
        itemCore = new ImageView(imgSprite);
        isNothing = false;
        itemCore.setFitHeight(SaveMap.getHeightEachSprite());
        itemCore.setFitWidth(SaveMap.getWidthEachSprite());
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

    public void destroy() {
        itemCore.setVisible(false);
    }

    public boolean isNothing() {
        return isNothing;
    }

    public boolean isVisible() {
        return itemCore.isVisible();
    }

    public void setVisible(boolean b) {
        itemCore.setVisible(b);
    }

    @Override
    public boolean checkMovable() {
        return false;
    }
}
