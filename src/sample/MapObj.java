package sample;

import javafx.scene.image.ImageView;


/**
 * Created by ChiChaChai on 29/3/2560.
 */
public class MapObj extends ObjSprite{

    private ImageView itemCore;

    public static final String[] LIST_MAP_OBJ_URL = {};

    public MapObj(int posMapObj) {
        itemCore = new ImageView(LIST_MAP_OBJ_URL[posMapObj]);
    }

    public void destroy() {


    }

    @Override
    public boolean checkMovable() {
        return false;
    }
}
