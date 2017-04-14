package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Game extends Application implements Sound {

    private static double width = 800;
    private static double height = 600;
    private static PlayerObj player1;
    private static PlayerObj player2;
    private String typeCharP1;
    private String typeCharP2;
    private Stage theStage;

    private Scene menu = initMainMenuScene();
    private Scene game;
    private Scene characterSelect = initSelectCharacter();
    private Scene howto = initHowTo();
    private Scene credit = initCredit();

    private int countClickChooseCharP1 = 0;
    private int countClickChooseCharP2 = 1;

    @Override
    public void start(Stage primaryStage) throws Exception {
        theStage = primaryStage;
        BACKGROUND_MUSIC.play(0.25);
        changeScene(menu);
    }
    private Scene winlose(){

        Pane pane = new Pane();
        ImageView bg = new ImageView(SourceDir.EMPTY_BG);
        bg.setFitWidth(width);
        bg.setFitHeight(height);
        pane.getChildren().add(bg);
        Scene scene = new Scene(pane, width, height);
        ImageView win = new ImageView("Win.png");
        win.relocate(width / 8 * 3,height / 3 );
        //เรียกรูปผู้ชนะ
        ImageView lose = new ImageView("Lose.png");
        win.relocate(width / 8 * 5,height / 3 );
        ImageView playagian = new ImageView("Next(Play).png");
        playagian.relocate(width / 8 * 5, height / 2);
        playagian.setOnMouseClicked(this::CS0);
    }

    private Scene initMainMenuScene() {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, width, height);
        ImageView BG = new ImageView(SourceDir.BG);
        BG.setFitHeight(height);
        BG.setFitWidth(width);
        BG.relocate(0, 0);

        ImageView start = new ImageView(SourceDir.START_BUT);
        start.relocate(width / 100 * 25, height / 100 * 45);

        ImageView howto = new ImageView(SourceDir.HOWTO_BUT);
        howto.relocate(width / 100 * 28, height / 100 * 58);

        ImageView exit = new ImageView(SourceDir.EXIT_BUT);
        exit.relocate(width / 100 * 25, height / 100 * 70);

        ImageView credit = new ImageView(SourceDir.CREDIT_BUT);
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
        ImageView bg = new ImageView(SourceDir.EMPTY_BG);
        bg.setFitWidth(width);
        bg.setFitHeight(height);
        pane.getChildren().add(bg);
        Scene scene = new Scene(pane, width, height);

        SaveMap saveMap = new SaveMap(12, 12, width, height);

        player1 = new PlayerObj(pane, typeCharP1) {
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

        player2 = new PlayerObj(pane, typeCharP2) {
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

    private Scene initSelectCharacter() {


        Pane pane = new Pane();
        Scene scene = new Scene(pane, width, height);
        ImageView bg = new ImageView(SourceDir.CHARACTER_SELECT_BG);
        bg.setFitWidth(width);
        bg.setFitHeight(height);
        pane.getChildren().add(bg);


        PlayerObj p1 = new PlayerObj(pane, SourceDir.CAT) {
            @Override
            public KeyCode getMoveUPkey() {
                return null;
            }

            @Override
            public KeyCode getMoveRIGHTkey() {
                return null;
            }

            @Override
            public KeyCode getMoveDownkey() {
                return null;
            }

            @Override
            public KeyCode getMoveLEFTkey() {
                return null;
            }

            @Override
            public KeyCode getDeployBombKey() {
                return null;
            }
        };
        p1.getCharacterCore().setFitHeight(height * 0.35);
        p1.getCharacterCore().setFitWidth(width * 0.3);
        p1.setX(width * 0.115);
        p1.setY(height * 0.4);
        p1.Down.play();


        PlayerObj p2 = new PlayerObj(pane, SourceDir.RABBIT) {
            @Override
            public KeyCode getMoveUPkey() {
                return null;
            }

            @Override
            public KeyCode getMoveRIGHTkey() {
                return null;
            }

            @Override
            public KeyCode getMoveDownkey() {
                return null;
            }

            @Override
            public KeyCode getMoveLEFTkey() {
                return null;
            }

            @Override
            public KeyCode getDeployBombKey() {
                return null;
            }
        };
        p2.getCharacterCore().setFitHeight(height * 0.35);
        p2.getCharacterCore().setFitWidth(width * 0.3);
        p2.setX(width * 0.115 + width * 0.45);
        p2.setY(height * 0.4);
        p2.Down.play();


        ImageView nextCharP1 = new ImageView(SourceDir.NEXT_BUT);
        nextCharP1.setFitWidth(width * 0.1);
        nextCharP1.setFitHeight(height * 0.1);
        nextCharP1.relocate(width / 2 - width * 0.1, height * 0.5);
        nextCharP1.setOnMouseClicked(event -> {
            if (countClickChooseCharP1 >= SourceDir.CHAR_TYPE.length - 1) countClickChooseCharP1 = -1;
            p1.setType(SourceDir.CHAR_TYPE[++countClickChooseCharP1]);

        });


        ImageView previousCharP1 = new ImageView(SourceDir.PREVIOUS_BUT);
        previousCharP1.setFitHeight(height * 0.1);
        previousCharP1.setFitWidth(width * 0.1);
        previousCharP1.relocate(width / 2 - width * 0.473, height * 0.5);
        previousCharP1.setOnMouseClicked(event -> {
            if (countClickChooseCharP1 < 1) countClickChooseCharP1 = SourceDir.CHAR_TYPE.length;
            p1.setType(SourceDir.CHAR_TYPE[--countClickChooseCharP1]);

        });

        ImageView nextCharP2 = new ImageView(SourceDir.NEXT_BUT);
        nextCharP2.setFitWidth(width * 0.1);
        nextCharP2.setFitHeight(height * 0.1);
        nextCharP2.relocate(width / 2 + width * 0.373, height * 0.5);
        nextCharP2.setOnMouseClicked(event -> {
            if (countClickChooseCharP2 >= SourceDir.CHAR_TYPE.length - 1) countClickChooseCharP2 = -1;
            p2.setType(SourceDir.CHAR_TYPE[++countClickChooseCharP2]);

        });

        ImageView previousCharP2 = new ImageView(SourceDir.PREVIOUS_BUT);
        previousCharP2.setFitHeight(height * 0.1);
        previousCharP2.setFitWidth(width * 0.1);
        previousCharP2.relocate(width / 2, height * 0.5);
        previousCharP2.setOnMouseClicked(event -> {
            if (countClickChooseCharP2 < 1) countClickChooseCharP2 = SourceDir.CHAR_TYPE.length;
            p2.setType(SourceDir.CHAR_TYPE[--countClickChooseCharP2]);

        });

        ImageView playBut = new ImageView(SourceDir.NEXT_BUT);
        playBut.setFitHeight(height * 0.1);
        playBut.setFitWidth(width * 0.1);
        playBut.relocate(width * 0.85, height * 0.85);
        playBut.setOnMouseClicked(event -> {
            typeCharP1 = SourceDir.CHAR_TYPE[countClickChooseCharP1];
            typeCharP2 = SourceDir.CHAR_TYPE[countClickChooseCharP2];
            game = initGame();
            changeScene(game);
        });

        ImageView homeBut = new ImageView(SourceDir.HOME_BUT);
        homeBut.setFitHeight(height * 0.1);
        homeBut.setFitWidth(width * 0.1);
        homeBut.relocate(width * 0.1, height * 0.85);
        homeBut.setOnMouseClicked(event -> changeScene(menu));

        pane.getChildren().addAll(nextCharP1
                , previousCharP1
                , nextCharP2
                , previousCharP2
                , p1.getCharacterCore()
                , p2.getCharacterCore()
                , playBut
                , homeBut);

        return scene;
    }

    private Scene initHowTo() {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, width, height);
        ImageView BGhowto = new ImageView(SourceDir.HOWTO_BG);
        BGhowto.setFitWidth(width);
        BGhowto.setFitHeight(height);

        ImageView home = new ImageView(SourceDir.HOME_BUT);
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
        ImageView BGcredit = new ImageView(SourceDir.CREDIT_BG);
        BGcredit.setFitWidth(width);
        BGcredit.setFitHeight(height);

        ImageView home = new ImageView(SourceDir.HOME_BUT);
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
        ImageView loading = new ImageView(SourceDir.LOADING_BG);
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
        changeScene(characterSelect);
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

    public static double getWidth() {
        return width;
    }

    public static double getHeight() {
        return height;
    }

    public static PlayerObj getPlayer1() {
        return player1;
    }

    public static PlayerObj getPlayer2() {
        return player2;
    }

    public static void main(String[] args) {
        launch(args);
    }


    private void bar1() {

        GridPane gridPane = new GridPane();
        gridPane.setHgap(1);
        gridPane.setVgap(1);
        gridPane.setStyle("-fx-background-color: rgb(217, 143, 48);");
        ImageView pic1 = new ImageView("player1.getCharacterCore()");
        for (int j =0 ; j < PlayerObj ; j++) {
            HBox b1 = new HBox(10);
            ImageView life1 = new ImageView("Life.png");
            gridPane.add(life1, 1, 1);
        }
        gridPane.setAlignment(Pos.TOP_RIGHT);



    }
    private void bar2() {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(1);
        gridPane.setVgap(1);
        gridPane.setStyle("-fx-background-color: rgb(217, 143, 48);");
        ImageView pic2 = new ImageView("player2.getCharacterCore()");
        gridPane.add(pic2, 0,1);
        for (int i =0 ; i < hp ; i++) {
            HBox b1 = new HBox(10);
            ImageView life2 = new ImageView("Life.png");
            gridPane.add(life2, 1, 1);
        }
        gridPane.setAlignment(Pos.TOP_LEFT);
    }
}
