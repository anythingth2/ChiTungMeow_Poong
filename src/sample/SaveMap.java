package sample;

/**
 * Created by ChiChaChai on 30/3/2560.
 */
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
                mapObj[i][j] = new MapObj(ImgSprite.cat[0]);
                mapObj[i][j].getItemCore().setFitWidth(widthEachSprite);
                mapObj[i][j].getItemCore().setFitHeight(heightEachSprite);
            }

    }

    public void save() {

    }

    public void readMap() {

    }
}
