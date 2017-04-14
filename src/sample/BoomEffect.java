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
        img.setFitHeight(SaveMap.getHeightEachSprite() * 0.75);
        img.setFitWidth(SaveMap.getWidthEachSprite() * 0.75);
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(75), event -> img.setImage(new Image(SourceDir.BOOM_EFF[i++]))));
        timeline.setOnFinished(event -> {
            if (isTakeDamageToPlayer1()) Game.getPlayer1().wasTakenDamage();
            if (isTakeDamageToPlayer2()) Game.getPlayer2().wasTakenDamage();
            destoryMap();
            pane.getChildren().remove(img);

        });
        timeline.setCycleCount(6);
    }

    public void start() {
        timeline.playFromStart();
    }

    private void destoryMap() {


        double px = img.getX() + img.getFitWidth() * (1 - rate);
        double py = img.getY() + img.getFitHeight() * (1 - rate);
        double pWidth = img.getFitWidth() * rate;
        double pHeight = img.getFitHeight() * rate;

        double mapx;
        double mapy;
        double mapWidth = SaveMap.getWidthEachSprite();
        double mapHeight = SaveMap.getHeightEachSprite();

        for (int i = 0; i < SaveMap.mapObj.length; i++)
            for (int j = 0; j < SaveMap.mapObj[i].length; j++) {
                mapx = SaveMap.mapObj[i][j].getItemCore().getX();
                mapy = SaveMap.mapObj[i][j].getItemCore().getY();
                if (px < mapx + mapWidth
                        && px + pWidth > mapx
                        && py < mapy + mapHeight
                        && py + pHeight > mapy
                        && !SaveMap.mapObj[i][j].isDestroyed()) {
                    if (!SaveMap.mapObj[i][j].isItem()) {
                        SaveMap.mapObj[i][j].destroy();
                        SaveMap.mapItem[i][j].appear();
                    }
                }
            }

    }

    private boolean isTakeDamageToPlayer1() {
        double px = img.getX();
        double py = img.getY();
        double pWidth = img.getFitWidth();
        double pHeight = img.getFitHeight();

        double mapx = Game.getPlayer1().getX();
        double mapy = Game.getPlayer1().getY();
        double mapWidth = SaveMap.getWidthEachSprite();
        double mapHeight = SaveMap.getHeightEachSprite();

        return px < mapx + mapWidth
                && px + pWidth > mapx
                && py < mapy + mapHeight
                && py + pHeight > mapy;
    }

    private boolean isTakeDamageToPlayer2() {
        double px = img.getX();
        double py = img.getY();
        double pWidth = SaveMap.getWidthEachSprite();
        double pHeight = SaveMap.getHeightEachSprite();

        double mapx = Game.getPlayer2().getX();
        double mapy = Game.getPlayer2().getY();
        double mapWidth = SaveMap.getWidthEachSprite();
        double mapHeight = SaveMap.getHeightEachSprite();

        return px < mapx + mapWidth
                && px + pWidth > mapx
                && py < mapy + mapHeight
                && py + pHeight > mapy;
    }
}
