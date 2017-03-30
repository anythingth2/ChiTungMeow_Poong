package sample;

import javafx.scene.image.ImageView;


/**
 * Created by ChiChaChai on 29/3/2560.
 */
public class MapObj extends ObjSprite {

    private ImageView itemCore;


    public MapObj(String imgSprite) {
        itemCore = new ImageView(imgSprite);

    }

    public ImageView getItemCore() {
        return itemCore;
    }



    public void destroy() {

    }

    @Override
    public boolean checkMovable() {
        return false;
    }
}
