package sample;

/**
 * Created by ChiChaChai on 30/3/2560.
 */

import java.io.*;
import java.util.ArrayList;

public class SaveMap {


    private int widthBlock;
    private int heightBlock;
    private double widthResolution;
    private double heightResolution;
    private double widthEachSprite;
    private double heightEachSprite;


    public MapObj[][] mapObj;

    public SaveMap(int widthBlock, int heightBlock, double widthResolution, double heightResolution) {
        this.widthBlock = widthBlock;
        this.heightBlock = heightBlock;
        this.widthResolution = widthResolution;
        this.heightResolution = heightResolution;
        widthEachSprite = widthResolution / widthBlock;
        heightEachSprite = heightResolution / heightBlock;
        mapObj = new MapObj[heightBlock][widthBlock];
        //init();
        //save();
        readMap();

    }

    public int getWidthBlock() {
        return widthBlock;
    }

    public int getHeightBlock() {
        return heightBlock;
    }

    public double getWidthEachSprite() {
        return widthEachSprite;
    }

    public double getHeightEachSprite() {
        return heightEachSprite;
    }

    private void init() {
        for (int i = 0; i < heightBlock; i++)
            for (int j = 0; j < widthBlock; j++) {
                mapObj[i][j] = new MapObj(ImgSprite.rock);
                mapObj[i][j].getItemCore().setFitWidth(widthEachSprite);
                mapObj[i][j].getItemCore().setFitHeight(heightEachSprite);
                //mapObj[i][j].getItemCore().relocate(widthEachSprite * j, heightEachSprite * i);
                mapObj[i][j].relocate(150, 150);
            }
    }

    public double getMapObjX(int i, int j) {
        return mapObj[i][j].getX();
    }

    public double getMapObjY(int i, int j) {
        return mapObj[i][j].getY();
    }

    public void save() {
        try {

            FileOutputStream saveFile = new FileOutputStream("SaveObj.sav");
            ObjectOutputStream save = new ObjectOutputStream(saveFile);
            save.writeObject(mapObj);
            save.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    public void readMap() {
        try {
            FileInputStream saveFile = new FileInputStream("SaveObj.sav");
            ObjectInputStream save = new ObjectInputStream(saveFile);
            mapObj = (MapObj[][]) save.readObject();
            save.close();
        } catch (Exception exc) {
            System.out.println("ERROR");
            exc.printStackTrace();
        }
    }
}
