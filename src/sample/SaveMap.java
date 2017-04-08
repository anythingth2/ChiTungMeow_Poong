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

    private MapObj[][] mapObj;

    public SaveMap(int widthBlock, int heightBlock, double widthResolution, double heightResolution) {
        this.widthBlock = widthBlock;
        this.heightBlock = heightBlock;
        this.widthResolution = widthResolution;
        this.heightResolution = heightResolution;
        widthEachSprite = widthResolution / widthBlock;
        heightEachSprite = heightResolution / heightBlock;
        mapObj = new MapObj[heightBlock][widthBlock];


    }


    private void init() {

        for (int i = 0; i < heightBlock; i++)
            for (int j = 0; j < widthBlock; j++) {
                mapObj[i][j] = new MapObj(ImgSprite.catUp[0]);
                mapObj[i][j].getItemCore().setFitWidth(widthEachSprite);
                mapObj[i][j].getItemCore().setFitHeight(heightEachSprite);
            }

    }

    public void save() {

        try{

            FileOutputStream saveFile=new FileOutputStream("SaveObj.sav");

            ObjectOutputStream save = new ObjectOutputStream(saveFile);
            //save.writeObject(ตัวแปร);
            //save.writeObject(ตัวแปร);
            //save.writeObject(ตัวแปร);
            //save.writeObject(ตัวแปร);
            //save.writeObject(ตัวแปร);
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

            //ตัวแปร = (Boolean) save.readObject();
            //ตัวแปร = (Integer) save.readObject();
            //ตัวแปร = (String) save.readObject();
            //ตัวแปร = (ArrayList) save.readObject();

            save.close();
        }
        catch(Exception exc){
            exc.printStackTrace();
        }

    }
}
