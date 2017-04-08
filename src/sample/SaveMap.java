package sample;

/**
 * Created by ChiChaChai on 30/3/2560.
 */


import javafx.scene.image.ImageView;

import java.io.*;
import java.util.ArrayList;

public class SaveMap {

    private int widthBlock;
    private int heightBlock;
    private double widthResolution;
    private double heightResolution;
    private static double widthEachSprite;
    private static double heightEachSprite;

    public static MapObj[][] mapObj;

    public SaveMap(int widthBlock, int heightBlock, double widthResolution, double heightResolution) {
        this.widthBlock = widthBlock;
        this.heightBlock = heightBlock;
        this.widthResolution = widthResolution;
        this.heightResolution = heightResolution;
        widthEachSprite = widthResolution / widthBlock;
        heightEachSprite = heightResolution / heightBlock;
        mapObj = new MapObj[heightBlock][widthBlock];
        init();

    }

    public ImageView getMapObjCore(int i, int j) {
        return mapObj[i][j].getItemCore();
    }

    public static double getWidthEachSprite() {
        return widthEachSprite;
    }

    public static double getHeightEachSprite() {
        return heightEachSprite;
    }

    private void init() {

        for (int i = 0; i < heightBlock; i++)
            for (int j = 0; j < widthBlock; j++) {
                mapObj[i][j] = new MapObj(ImgSprite.blue);
                mapObj[i][j].getItemCore().setFitWidth(widthEachSprite);
                mapObj[i][j].getItemCore().setFitHeight(heightEachSprite);
                mapObj[i][j].getItemCore().setX(150);
                mapObj[i][j].getItemCore().setY(250);

            }

    }

    public void save() {

        try{

            FileOutputStream saveFile=new FileOutputStream("SaveObj.sav");
            ObjectOutputStream save = new ObjectOutputStream(saveFile);
            save.writeObject(mapObj);
            save.close();
        }
        catch(Exception exc){
            exc.printStackTrace();
        }


    }

    public void readMap() {

        try{
            FileInputStream saveFile = new FileInputStream("SaveObj.sav");
            ObjectInputStream save = new ObjectInputStream(saveFile);
            mapObj = (MapObj[][])save.readObject();
            save.close();
        }
        catch(Exception exc){
            exc.printStackTrace();
        }

    }
}
