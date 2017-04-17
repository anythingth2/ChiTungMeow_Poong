package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * Created by ChiChaChai on 12/4/2560.
 */
public class BoomEffect {
    private Timeline timeline = new Timeline();
    private int i = 0;
    private ImageView img;
    double rate = 0.75;

    public BoomEffect(Pane pane, ImageView img) {
        super();
        this.img = img;
        img.setFitHeight(SaveMap.getHeightEachSprite() * rate);
        img.setFitWidth(SaveMap.getWidthEachSprite() * rate);
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(75), event -> img.setImage(new Image(SourceDir.BOOM_EFF[i++]))));
        timeline.setOnFinished(event -> {
            destoryMap();
            pane.getChildren().remove(img);

        });
        timeline.setCycleCount(6);
    }

    public void start() {
        timeline.playFromStart();
    }

    public Timeline getTimeline() {
        return timeline;
    }

    private void destoryMap() {


        double px = img.getX() + img.getFitWidth() * (1 - rate);
        double py = img.getY() + img.getFitHeight() * (1 - rate);
        double pWidth = img.getFitWidth();
        double pHeight = img.getFitHeight();

        double mapx;
        double mapy;
        double mapWidth = SaveMap.getWidthEachSprite() * rate;
        double mapHeight = SaveMap.getHeightEachSprite() * rate;

        for (int i = 0; i < SaveMap.mapTree.length; i++)
            for (int j = 0; j < SaveMap.mapTree[i].length; j++) {
                if (!SaveMap.mapTree[i][j].isDestoryable()) {

                } else {
                    mapx = SaveMap.mapTree[i][j].getItemCore().getX() + SaveMap.mapTree[i][j].getItemCore().getFitWidth() * (1 - rate);
                    mapy = SaveMap.mapTree[i][j].getItemCore().getY() + SaveMap.mapTree[i][j].getItemCore().getFitHeight() * (1 - rate);

                    if (px < mapx + mapWidth
                            && px + pWidth > mapx
                            && py < mapy + mapHeight
                            && py + pHeight > mapy
                            ) {

                        if (SaveMap.mapTree[i][j].isItem()) {
                            SaveMap.mapTree[i][j].transformToItem();
                        } else {
                            SaveMap.mapTree[i][j].destroy();
                        }
                    }
                }

                if (!SaveMap.mapWall[i][j].isDestoryable() || SaveMap.mapWall[i][j].isDestroyed()) {

                } else {
                    mapx = SaveMap.mapWall[i][j].getItemCore().getX() + SaveMap.mapWall[i][j].getItemCore().getFitWidth() * (1 - rate);
                    mapy = SaveMap.mapWall[i][j].getItemCore().getY() + SaveMap.mapWall[i][j].getItemCore().getFitHeight() * (1 - rate);

                    if (px < mapx + mapWidth
                            && px + pWidth > mapx
                            && py < mapy + mapHeight
                            && py + pHeight > mapy
                            ) {
                        if (SaveMap.mapWall[i][j].isItem()) {
                            SaveMap.mapWall[i][j].transformToItem();
                        } else {
                            SaveMap.mapWall[i][j].destroy();
                        }
                    }
                }
            }

    }

    public boolean isTakeDamageToPlayer1() {
        double px = img.getX() + img.getFitWidth() * (1 - rate);
        double py = img.getY() + img.getFitHeight() * (1 - rate);
        double pWidth = img.getFitWidth();
        double pHeight = img.getFitHeight();

        double mapx = GameScene.getPlayer1().getX() + GameScene.getPlayer1().getCharacterCore().getFitWidth() * (1 - rate);
        double mapy = GameScene.getPlayer1().getY() + GameScene.getPlayer2().getCharacterCore().getFitHeight() * (1 - rate);
        double mapWidth = SaveMap.getWidthEachSprite() * rate;
        double mapHeight = SaveMap.getHeightEachSprite() * rate;

        return px < mapx + mapWidth
                && px + pWidth > mapx
                && py < mapy + mapHeight
                && py + pHeight > mapy;
    }

    public boolean isTakeDamageToPlayer2() {
        double px = img.getX() + img.getFitWidth() * (1 - rate);
        double py = img.getY() + img.getFitHeight() * (1 - rate);
        double pWidth = img.getFitWidth();
        double pHeight = img.getFitHeight();

        double mapx = GameScene.getPlayer2().getX() + GameScene.getPlayer2().getCharacterCore().getFitWidth() * (1 - rate);
        double mapy = GameScene.getPlayer2().getY() + GameScene.getPlayer2().getCharacterCore().getFitHeight() * (1 - rate);
        double mapWidth = SaveMap.getWidthEachSprite() * rate;
        double mapHeight = SaveMap.getHeightEachSprite() * rate;

        return px < mapx + mapWidth
                && px + pWidth > mapx
                && py < mapy + mapHeight
                && py + pHeight > mapy;
    }
}
