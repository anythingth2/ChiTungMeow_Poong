package sample;

/**
 * Created by ChiChaChai on 30/3/2560.
 */


import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.*;
import java.io.*;

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

    private int rateDropItem = 15;
    private Random rand = new Random(System.currentTimeMillis());

    public char[][] myArray = new char[15][15];

    public SaveMap(int widthBlock, int heightBlock, double widthResolution, double heightResolution) {
        this.widthBlock = widthBlock;
        this.heightBlock = heightBlock;
        this.widthResolution = widthResolution;
        this.heightResolution = heightResolution;
        widthEachSprite = widthResolution / widthBlock;
        heightEachSprite = heightResolution / heightBlock;
        mapObj = new MapObj[heightBlock][widthBlock];
        mapItem = new MapObj[heightBlock][widthBlock];
        readMap();
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

        for (int i = 0; i < 13; i++)
            for (int j = 0; j < 15; j++) {


                switch (myArray[i][j]) {
                    case '#':
                        mapObj[i][j] = new MapObj(SourceDir.COWALL, false);
                        break;
                    case 's':
                        mapObj[i][j] = new MapObj(SourceDir.GROUND, false);
                        mapObj[i][j].setPassable(true);
                        break;
                    case 'o':
                        mapObj[i][j] = new MapObj(SourceDir.T, false);
                        break;
                    case 'i':
                        mapObj[i][j] = new MapObj(SourceDir.B, false);
                        break;
                    case '5':
                        mapObj[i][j] = new MapObj(SourceDir.ROWALL, false);
                        break;
                    case 't':
                        mapObj[i][j] = new MapObj(SourceDir.TL, false);
                        break;
                    case 'b':
                        mapObj[i][j] = new MapObj(SourceDir.TR, false);
                        break;
                    case 'j':
                        mapObj[i][j] = new MapObj(SourceDir.BL, false);
                        break;
                    case 'h':
                        mapObj[i][j] = new MapObj(SourceDir.BR, false);
                        break;
                    default:
                        mapObj[i][j] = new MapObj( false);
                        break;
                }


                mapObj[i][j].getItemCore().setFitWidth(widthEachSprite);
                mapObj[i][j].getItemCore().setFitHeight(heightEachSprite);
                mapObj[i][j].getItemCore().setX(widthEachSprite * j);
                mapObj[i][j].getItemCore().setY(heightEachSprite * i);

            }
        for (int i = 0; i < heightBlock; i++)
            for (int j = 0; j < widthBlock; j++) {
                if (rand.nextInt(100) < rateDropItem) {
                    switch (rand.nextInt(4)) {
                        case 0:
                            mapItem[i][j] = new MapObj(SourceDir.AMOUNT_BOMB_ITEM, true);
                            break;
                        case 1:
                            mapItem[i][j] = new MapObj(SourceDir.FAST_ITEM, true);
                            break;
                        case 2:
                            mapItem[i][j] = new MapObj(SourceDir.POTION_ITEM, true);
                            break;
                        case 3:
                            mapItem[i][j] = new MapObj(SourceDir.SHIELD_ITEM, true);
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

            FileOutputStream saveFile = new FileOutputStream("SaveObj.txt");
            ObjectOutputStream save = new ObjectOutputStream(saveFile);
            save.writeObject(mapObj);
            save.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }


    }

    public void readMap() {


        try {
            Scanner scanner = new Scanner(new File("SaveObj.txt"));
            for (int row = 0; scanner.hasNextLine(); row++) {
                String string = scanner.nextLine();
                for (int i = 0; i < string.length(); i++)
                    myArray[row][i] = string.charAt(i);
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        for (int i = 0; i < myArray.length; i++)
            System.out.println(Arrays.toString(myArray[i]));
    }
}
