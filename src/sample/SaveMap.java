package sample;

/**
 * Created by ChiChaChai on 30/3/2560.
 */


import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import sun.java2d.Surface;

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

    public static MapObj[][] mapBG;
    public static MapObj[][] mapTree;
    public static MapObj[][] mapWall;

    private int rateDropItem = 15;
    private Random rand = new Random(System.currentTimeMillis());


    public char[][] wall;
    public char[][] tree;


    public SaveMap(int widthBlock, int heightBlock, double widthResolution, double heightResolution) {
        this.widthBlock = widthBlock;
        this.heightBlock = heightBlock;
        this.widthResolution = widthResolution;
        this.heightResolution = heightResolution;
        widthEachSprite = widthResolution / widthBlock;
        heightEachSprite = heightResolution / heightBlock;

        mapBG = new MapObj[heightBlock][widthBlock];
        mapWall = new MapObj[heightBlock][widthBlock];
        mapTree = new MapObj[heightBlock][widthBlock];

        wall = new char[heightBlock][widthBlock];
        tree = new char[heightBlock][widthBlock];


        readMapWall();
        readMapTree();

        init();

    }


    public static MapObj[][] getMapTree() {
        return mapTree;
    }

    public static MapObj[][] getMapWall() {
        return mapWall;
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

                mapBG[i][j] = new MapObj(SourceDir.GROUND1, true, false);

                switch (tree[i][j]) {
                    //BIG_SAKURA
                    case '1':
                        mapTree[i][j] = new MapObj(SourceDir.BIG_SAKURA1, false, false);
                        break;
                    case '2':
                        mapTree[i][j] = new MapObj(SourceDir.BIG_SAKURA2, false, false);
                        break;
                    case '3':
                        mapTree[i][j] = new MapObj(SourceDir.BIG_SAKURA3, false, false);
                        break;
                    case '4':
                        mapTree[i][j] = new MapObj(SourceDir.BIG_SAKURA4, false, false);
                        break;
                    case '5':
                        mapTree[i][j] = new MapObj(SourceDir.BIG_SAKURA5, false, false);
                        break;
                    case '6':
                        mapTree[i][j] = new MapObj(SourceDir.BIG_SAKURA6, false, false);
                        break;
                    case '7':
                        mapTree[i][j] = new MapObj(SourceDir.BIG_SAKURA7, false, false);
                        break;
                    case '8':
                        mapTree[i][j] = new MapObj(SourceDir.BIG_SAKURA8, false, false);
                        break;
                    case '9':
                        mapTree[i][j] = new MapObj(SourceDir.BIG_SAKURA9, false, false);
                        break;
                    case '-':
                        mapTree[i][j] = new MapObj(SourceDir.BIG_SAKURA10, false, false);
                        break;
                    case '=':
                        mapTree[i][j] = new MapObj(SourceDir.BIG_SAKURA11, false, false);
                        break;
                    case '+':
                        mapTree[i][j] = new MapObj(SourceDir.BIG_SAKURA12, false, false);
                        break;
                    case '_':
                        mapTree[i][j] = new MapObj(SourceDir.BIG_SAKURA13, false, false);
                        break;
                    case ')':
                        mapTree[i][j] = new MapObj(SourceDir.BIG_SAKURA14, false, false);
                        break;
                    case '(':
                        mapTree[i][j] = new MapObj(SourceDir.BIG_SAKURA15, false, false);
                        break;
                    case '*':
                        mapTree[i][j] = new MapObj(SourceDir.BIG_SAKURA16, false, false);
                        break;
                    case '&':
                        mapTree[i][j] = new MapObj(SourceDir.BIG_SAKURA17, false, false);
                        break;
                    case '^':
                        mapTree[i][j] = new MapObj(SourceDir.BIG_SAKURA18, false, false);
                        break;
                    case '%':
                        mapTree[i][j] = new MapObj(SourceDir.BIG_SAKURA19, false, false);
                        break;
                    case '$':
                        mapTree[i][j] = new MapObj(SourceDir.BIG_SAKURA20, false, false);
                        break;
                    case '#':
                        mapTree[i][j] = new MapObj(SourceDir.BIG_SAKURA21, false, false);
                        break;
                    case '@':
                        mapTree[i][j] = new MapObj(SourceDir.BIG_SAKURA22, false, false);
                        break;
                    case '!':
                        mapTree[i][j] = new MapObj(SourceDir.BIG_SAKURA23, false, false);
                        break;
                    case '[':
                        mapTree[i][j] = new MapObj(SourceDir.BIG_SAKURA24, false, false);
                        break;
//                    SAKURA
                    case 'a':
                        mapTree[i][j] = new MapObj(SourceDir.SAKURA1, false, false);
                        break;
                    case 's':
                        mapTree[i][j] = new MapObj(SourceDir.SAKURA2, false, false);
                        break;
                    case 'd':
                        mapTree[i][j] = new MapObj(SourceDir.SAKURA3, false, false);
                        break;
                    case 'f':
                        mapTree[i][j] = new MapObj(SourceDir.SAKURA4, false, false);
                        break;
                    case 'g':
                        mapTree[i][j] = new MapObj(SourceDir.SAKURA5, false, false);
                        break;
                    case 'h':
                        mapTree[i][j] = new MapObj(SourceDir.SAKURA6, false, false);
                        break;
                    case 'j':
                        mapTree[i][j] = new MapObj(SourceDir.SAKURA7, false, false);
                        break;
                    case 'k':
                        mapTree[i][j] = new MapObj(SourceDir.SAKURA8, false, false);
                        break;
                    case 'l':
                        mapTree[i][j] = new MapObj(SourceDir.SAKURA9, false, false);
                        break;
                    case 'L':
                        mapTree[i][j] = new MapObj(SourceDir.SAKURA10, false, false);
                        break;
                    case 'K':
                        mapTree[i][j] = new MapObj(SourceDir.SAKURA11, false, false);
                        break;
                    case 'J':
                        mapTree[i][j] = new MapObj(SourceDir.SAKURA12, false, false);
                        break;
                    case 'H':
                        mapTree[i][j] = new MapObj(SourceDir.SAKURA13, false, false);
                        break;
                    case 'G':
                        mapTree[i][j] = new MapObj(SourceDir.SAKURA14, false, false);
                        break;
                    case 'F':
                        mapTree[i][j] = new MapObj(SourceDir.SAKURA15, false, false);
                        break;


                    //FLOWER
                    case 'z':
                        mapTree[i][j] = new MapObj(SourceDir.FLOWER1, true, false);
                        break;
                    case 'x':
                        mapTree[i][j] = new MapObj(SourceDir.FLOWER2, true, false);
                        break;
                    case 'c':
                        mapTree[i][j] = new MapObj(SourceDir.FLOWER3, true, false);
                        break;

                    case 'V':
                        mapTree[i][j] = new MapObj(SourceDir.ROCK, SourceDir.ALL_ITEM[rand.nextInt(4)], false, true);

                        break;
                    case 'B':
                        mapTree[i][j] = new MapObj(SourceDir.BUSH, SourceDir.ALL_ITEM[rand.nextInt(4)], false, true);
                        break;

                    case '0':
                        mapTree[i][j] = new MapObj();
                        break;
                    default:
                        mapTree[i][j] = new MapObj();

                }


                switch (wall[i][j]) {
                    //WALL_BUTTOM
                    case 'q':
                        mapWall[i][j] = new MapObj(SourceDir.WALL_BD, false, false);
                        break;
                    case 'w':
                        mapWall[i][j] = new MapObj(SourceDir.WALL_BL, false, false);
                        break;
                    case 'e':
                        mapWall[i][j] = new MapObj(SourceDir.WALL_BR, false, false);
                        break;
                    case 'r':
                        mapWall[i][j] = new MapObj(SourceDir.WALL_BU, false, false);
                        break;

                    //WALL_CORNER
                    case 't':
                        mapWall[i][j] = new MapObj(SourceDir.WALL_LD, false, false);
                        break;
                    case 'y':
                        mapWall[i][j] = new MapObj(SourceDir.WALL_LU, false, false);
                        break;
                    case 'u':
                        mapWall[i][j] = new MapObj(SourceDir.WALL_RD, false, false);
                        break;
                    case 'i':
                        mapWall[i][j] = new MapObj(SourceDir.WALL_RU, false, false);
                        break;

                    //WALL_HEAD
                    case 'Q':
                        mapWall[i][j] = new MapObj(SourceDir.WALL_HD, false, false);
                        break;
                    case 'W':
                        mapWall[i][j] = new MapObj(SourceDir.WALL_HL, false, false);
                        break;
                    case 'E':
                        mapWall[i][j] = new MapObj(SourceDir.WALL_HR, false, false);
                        break;
                    case 'R':
                        mapWall[i][j] = new MapObj(SourceDir.WALL_HU, false, false);
                        break;
                    //WALL_MIDDLE
                    case 'T':
                        mapWall[i][j] = new MapObj(SourceDir.WALL_MD, false, false);
                        break;
                    case 'Y':
                        mapWall[i][j] = new MapObj(SourceDir.WALL_ML, false, false);
                        break;
                    case 'U':
                        mapWall[i][j] = new MapObj(SourceDir.WALL_MR, false, false);
                        break;
                    case 'I':
                        mapWall[i][j] = new MapObj(SourceDir.WALL_MU, false, false);
                        break;

                    //CHAIR&&LAMP
                    case 'C':
                        mapWall[i][j] = new MapObj(SourceDir.CHAIRUP, false, false);
                        break;
                    case 'L':
                        mapWall[i][j] = new MapObj(SourceDir.LAMP1, false, false);
                        break;
                    case 'l':
                        mapWall[i][j] = new MapObj(SourceDir.LAMP2, false, false);
                        break;

                    case '0':
                        mapWall[i][j] = new MapObj();
                        break;
                    default:
                        mapWall[i][j] = new MapObj();
                        break;
                }

                mapBG[i][j].getItemCore().setFitWidth(widthEachSprite);
                mapBG[i][j].getItemCore().setFitHeight(heightEachSprite);
                mapBG[i][j].getItemCore().setX(widthEachSprite * j);
                mapBG[i][j].getItemCore().setY(heightEachSprite * i);

                mapTree[i][j].getItemCore().setFitWidth(widthEachSprite);
                mapTree[i][j].getItemCore().setFitHeight(heightEachSprite);
                mapTree[i][j].getItemCore().setX(widthEachSprite * j);
                mapTree[i][j].getItemCore().setY(heightEachSprite * i);


                mapWall[i][j].getItemCore().setFitWidth(widthEachSprite);
                mapWall[i][j].getItemCore().setFitHeight(heightEachSprite);
                mapWall[i][j].getItemCore().setX(widthEachSprite * j);
                mapWall[i][j].getItemCore().setY(heightEachSprite * i);


            }
    }

    public void addItem(Pane pane) {

        for (int i = 0; i < heightBlock; i++)
            for (int j = 0; j < widthBlock; j++)
                pane.getChildren().add(mapBG[i][j].getItemCore());


        for (int i = 0; i < heightBlock; i++)
            for (int j = 0; j < widthBlock; j++)
                pane.getChildren().add(mapWall[i][j].getItemCore());

        for (int i = 0; i < heightBlock; i++)
            for (int j = 0; j < widthBlock; j++)
                pane.getChildren().add(mapTree[i][j].getItemCore());

    }


    private void readMapWall() {


        try {
            Scanner scanner = new Scanner(new File("Wall.txt"));

            for (int row = 0; scanner.hasNextLine(); row++) {
                char[] chars = scanner.nextLine().toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    try {
                        wall[row][i] = chars[i];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("row " + row + "   :::: i " + i);
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private void readMapTree() {

        try {
            Scanner scanner = new Scanner(new File("Object.txt"));
            for (int row = 0; scanner.hasNextLine(); row++) {
                char[] chars = scanner.nextLine().toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    tree[row][i] = chars[i];
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }


}