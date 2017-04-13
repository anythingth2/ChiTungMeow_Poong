package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Game extends Application implements Sound {

    private double width = 800;
    private double height = 600;
    private Stage theStage;
    private Scene menu = initMainMenuScene();
    Scene game = initGame();
    Scene howto = initHowTo();

    Scene credit = initCredit();

    @Override
    public void start(Stage primaryStage) throws Exception {
        theStage = primaryStage;
        changeScene(menu);
    }

    private Scene initMainMenuScene() {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, width, height);
        ImageView BG = new ImageView(ImgSprite.BG);
        BG.setFitHeight(height);
        BG.setFitWidth(width);
        BG.relocate(0, 0);

        ImageView start = new ImageView(ImgSprite.startBut);
        start.relocate(width / 100 * 25, height / 100 * 45);

        ImageView howto = new ImageView(ImgSprite.howtoBut);
        howto.relocate(width / 100 * 28, height / 100 * 58);

        ImageView exit = new ImageView(ImgSprite.exitBut);
        exit.relocate(width / 100 * 25, height / 100 * 70);

        ImageView credit = new ImageView(ImgSprite.creditBut);
        credit.relocate(width / 100 * 79, height / 100 * 83);

        pane.getChildren().addAll(BG, start, howto, exit, credit);

        start.setOnMouseClicked(this::CS1);
        howto.setOnMouseClicked(this::CS2);
        exit.setOnMouseClicked(this::CS3);
        credit.setOnMouseClicked(this::CS4);


        return scene;
    }

    private Scene initGame() {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, width, height);

        SaveMap saveMap = new SaveMap(12, 12, width, height);

        PlayerObj player1 = new PlayerObj(pane,ImgSprite.poringUp[0]) {
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

        PlayerObj player2 = new PlayerObj(pane,ImgSprite.catRight[0]) {
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

        Input inputPlayer = new Input(scene, player1, player2);
        inputPlayer.startLoopInput();


        pane.getChildren().add(player1.getCharacterCore());
        pane.getChildren().add(player2.getCharacterCore());
        saveMap.addItem(pane);



        return scene;
    }

    private Scene initHowTo() {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, width, height);
        ImageView BGhowto = new ImageView(ImgSprite.howtoBG);
        BGhowto.setFitWidth(width);
        BGhowto.setFitHeight(height);

        ImageView home = new ImageView(ImgSprite.homeBut);
        home.relocate(width / 100 * 85, height / 100 * 80);
        home.setFitHeight(width * 0.10);
        home.setFitWidth(width * 0.10);
        home.setOnMouseClicked(this::CS0);

        pane.getChildren().addAll(BGhowto, home);
        return scene;
    }

    private Scene initCredit() {

        Pane pane = new Pane();
        Scene scene = new Scene(pane, width, height);
        ImageView BGcredit = new ImageView(ImgSprite.creditBG);
        BGcredit.setFitWidth(width);
        BGcredit.setFitHeight(height);

        ImageView home = new ImageView(ImgSprite.homeBut);
        home.relocate(width / 100 * 85, height / 100 * 80);
        home.setFitHeight(width * 0.10);
        home.setFitWidth(width * 0.10);
        home.setOnMouseClicked(this::CS0);

        pane.getChildren().addAll(BGcredit, home);
        return scene;
    }

    private void changeScene(Scene scene) {
        Pane pane = new Pane();
        Scene loadingScene = new Scene(pane, width, height);
        ImageView loading = new ImageView(ImgSprite.loadingBG);
        loading.setFitWidth(width);
        loading.setFitHeight(height);
        pane.getChildren().addAll(loading);
        theStage.setScene(loadingScene);
        theStage.show();

        Timeline waitloading = new Timeline(new KeyFrame(Duration.millis(0)));
           waitloading.setOnFinished(event -> {
               theStage.setScene(scene);
               theStage.show();
           });
        waitloading.playFromStart();

    }
    private void CS0(MouseEvent e) {


        changeScene(menu);
    }

    private void CS1(MouseEvent e) {
        changeScene(game);
    }

    private void CS2(MouseEvent e) {
        changeScene(howto);
    }

    private void CS3(MouseEvent e) {
        System.exit(0);
    }

    private void CS4(MouseEvent e) {
        changeScene(credit);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
