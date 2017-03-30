package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Game extends Application implements Sound {

    private double width;
    private double height;
    private Pane pane;
    private SaveMap save;

    @Override
    public void start(Stage primaryStage) throws Exception {


        PlayerObj player1 = new PlayerObj(ImgSprite.rock) {
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

        pane = new Pane();


        Scene scene = new Scene(pane, 800, 600);
        primaryStage.setTitle("ChiTungMeowPoong");
        primaryStage.setFullScreen(true);
        primaryStage.setScene(scene);
        primaryStage.show();


        Input inputPlayer1 = new Input(scene, player1);
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(convertFPStoMilliSecond(60)),
                event -> {
                    if (inputPlayer1.isMoveUp()) {
                        player1.move(Direction.UP);
                        if (Collision.isOverlapWithMap(player1, save))
                            player1.move(Direction.DOWN);

                    }
                    if (inputPlayer1.isMoveRight()) {
                        player1.move(Direction.RIGHT);
                        if (Collision.isOverlapWithMap(player1, save))
                            player1.move(Direction.LEFT);
                    }
                    if (inputPlayer1.isMoveDown()) {
                        player1.move(Direction.DOWN);
                        if (Collision.isOverlapWithMap(player1, save))
                            player1.move(Direction.UP);
                    }
                    if (inputPlayer1.isMoveLeft()) {
                        player1.move(Direction.LEFT);
                        if (Collision.isOverlapWithMap(player1, save))
                            player1.move(Direction.RIGHT);
                    }
                }
        ));
        timeline.playFromStart();


        width = primaryStage.getWidth();
        height = primaryStage.getHeight();
        initMap(25, 25);
        pane.getChildren().add(player1.getCharacterCore());
    }

    private void initMap(int widthBlock, int heightBlock) {
        save = new SaveMap(widthBlock, heightBlock, width, height);
        for (int i = 0; i < 25; i++)
            for (int j = 0; j < 25; j++)
                pane.getChildren().add(save.mapObj[i][j].getItemCore());
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
