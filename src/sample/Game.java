package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Game extends Application implements Sound {

    private double width;
    private double height;

    @Override
    public void start(Stage primaryStage) throws Exception {


        PlayerObj player1 = new PlayerObj("ChiChaChai", "dog") {
            @Override
            public KeyCode getMoveUPkey() {
                return KeyCode.W;
            }

            @Override
            public KeyCode getMoveRIGHTkey() {
                return KeyCode.D;
            }

            @Override
            public KeyCode getMoveDownkey() {
                return KeyCode.S;
            }

            @Override
            public KeyCode getMoveLEFTkey() {
                return KeyCode.A;
            }
        };

        Pane pane = new Pane();
        pane.getChildren().add(player1.getCharacterCore());
        Scene scene = new Scene(pane, 800, 600);
        primaryStage.setTitle("ChiTungMeowPoong");
        primaryStage.setScene(scene);
        primaryStage.show();
        Input inputPlayer1 = new Input(scene, player1);
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(convertFPStoMilliSecond(60)),
                event -> {
                    if (inputPlayer1.isMoveUp()) {
                        player1.move(Direction.UP);
                        player1.Up.play();
                    }
                    if (inputPlayer1.isMoveRight()) {
                        player1.move(Direction.RIGHT);
                        player1.Right.play();
                    }
                    if (inputPlayer1.isMoveDown()) {
                        player1.move(Direction.DOWN);
                        player1.Down.play();
                    }
                    if (inputPlayer1.isMoveLeft()) {
                        player1.move(Direction.LEFT);
                        player1.Left.play();
                    }
                }
        ));
        timeline.playFromStart();


        width = primaryStage.getWidth();
        height = primaryStage.getHeight();


    }

    private void changeScene(Stage stage, Scene scene) {
        stage.setScene(scene);
    }

    private double convertFPStoMilliSecond(int FPS) {
        return 1000 / FPS;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
