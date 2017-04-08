package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Game extends Application implements Sound {

    private double width = 800;
    private double height = 600;

    @Override
    public void start(Stage primaryStage) throws Exception {

        SaveMap saveMap = new SaveMap(12, 12, width, height);

        PlayerObj player1 = new PlayerObj(ImgSprite.red) {
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

            @Override
            public KeyCode getDeployBombKey() {
                return KeyCode.SPACE;
            }
        };

        PlayerObj player2 = new PlayerObj(ImgSprite.blue) {
            @Override
            public KeyCode getMoveUPkey() {
                return KeyCode.UP;
            }

            @Override
            public KeyCode getMoveRIGHTkey() {
                return KeyCode.RIGHT;
            }

            @Override
            public KeyCode getMoveDownkey() {
                return KeyCode.DOWN;
            }

            @Override
            public KeyCode getMoveLEFTkey() {
                return KeyCode.LEFT;
            }

            @Override
            public KeyCode getDeployBombKey() {
                return KeyCode.ENTER;
            }
        };

        Pane pane = new Pane();
        Scene scene = new Scene(pane, width, height);
        pane.getChildren().add(player1.getCharacterCore());
        pane.getChildren().add(player2.getCharacterCore());
        for (int i = 0; i < 12; i++)
            for (int j = 0; j < 12; j++)
                pane.getChildren().add(saveMap.getMapObjCore(i, j));

        primaryStage.setTitle("ChiTungMeowPoong");
        primaryStage.setScene(scene);
        primaryStage.show();
        Input inputPlayer1 = new Input(scene, player1,player2);
        inputPlayer1.startLoopInput();




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
