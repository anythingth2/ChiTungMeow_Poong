package sample;

/**
 * Created by ChiChaChai on 30/3/2560.
 */


import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

public class SaveMap {

    private int widthBlock;
    private int heightBlock;
    private double widthResolution;
    private double heightResolution;
    private static double widthEachSprite;
    private static double heightEachSprite;

    public static MapObj[][] mapObj;
    public static MapObj[][] mapItem;

    private Random rand = new Random(System.currentTimeMillis());

    public SaveMap(int widthBlock, int heightBlock, double widthResolution, double heightResolution) {
        this.widthBlock = widthBlock;
        this.heightBlock = heightBlock;
        this.widthResolution = widthResolution;
        this.heightResolution = heightResolution;
        widthEachSprite = widthResolution / widthBlock;
        heightEachSprite = heightResolution / heightBlock;
        mapObj = new MapObj[heightBlock][widthBlock];
        mapItem = new MapObj[heightBlock][widthBlock];
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
                mapObj[i][j] = new MapObj(SourceDir.RABBIT_LEFT[0],false);
                mapObj[i][j].getItemCore().setFitWidth(widthEachSprite);
                mapObj[i][j].getItemCore().setFitHeight(heightEachSprite);
                mapObj[i][j].getItemCore().setX(widthEachSprite*j);
                mapObj[i][j].getItemCore().setY(heightEachSprite*i);

            }
        for (int i = 0; i < heightBlock; i++)
            for (int j = 0; j < widthBlock; j++) {
                if (rand.nextInt(100) < 20) {
                    switch (rand.nextInt(4)) {
                        case 0:
                            mapItem[i][j] = new MapObj(SourceDir.AMOUNT_BOMB_ITEM,true);
                            break;
                        case 1:
                            mapItem[i][j] = new MapObj(SourceDir.FAST_ITEM,true);
                            break;
                        case 2:
                            mapItem[i][j] = new MapObj(SourceDir.POTION_ITEM,true);
                            break;
                        case 3:
                            mapItem[i][j] = new MapObj(SourceDir.SHIELD_ITEM,true);
                            break;
                    }


                } else {
                    mapItem[i][j] = new MapObj(true);
                }

                mapItem[i][j].getItemCore().setX(widthEachSprite * j);
                mapItem[i][j].getItemCore().setY(heightEachSprite * i);
                mapItem[i][j].setVisible(false);
            }
    }

    public void addItem(Pane pane) {
        for (int i = 0; i < heightBlock; i++)
            for (int j = 0; j < widthBlock; j++)
                pane.getChildren().add(mapObj[i][j].getItemCore());

        for (int i = 0; i < heightBlock; i++)
            for (int j = 0; j < widthBlock; j++)
                pane.getChildren().add(mapItem[i][j].getItemCore());

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
            exc.printStackTrace();
        }

    }
}
