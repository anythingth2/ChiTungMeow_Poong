package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

    public BoomEffect(Pane pane, ImageView img) {
        super();
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(75), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                img.setImage(new Image(ImgSprite.boomEff[i++]));

            }
        }));
        timeline.setOnFinished(event -> {
            pane.getChildren().remove(img);

        });
        timeline.setCycleCount(6);
    }

    public void start() {
        timeline.playFromStart();
    }
}
