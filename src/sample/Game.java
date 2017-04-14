package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Game extends Application implements Sound {

    private static double width = 1440;
    private static double height = 800;
    private static PlayerObj player1;
    private static PlayerObj player2;
    private static String typeCharP1;
    private static String typeCharP2;
    private Stage theStage;

    private Scene menu = initMainMenuScene();
    private Scene game;
    private Scene characterSelect = initSelectCharacter();
    private Scene howto = initHowTo();
    private Scene credit = initCredit();

    public static Pane bar;
    public static Pane bar2;
    public static ImageView[] life;
    public static ImageView[] life2;

    private int countClickChooseCharP1 = 0;
    private int countClickChooseCharP2 = 1;
    private int countHpP1;
    private int countHpP2;

    @Override
    public void start(Stage primaryStage) throws Exception {
        theStage = primaryStage;
        BACKGROUND_MUSIC.play(0.25);
        changeScene(menu);
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
        SaveMap saveMap = new SaveMap(15, 13, width, height);

        bar = new Pane();
        bar2 = new Pane();
        bar.setTranslateX(0);
        bar.setTranslateY(0);
        bar2.setTranslateX(width * 0.8);
        bar2.setTranslateY(0);


        ImageView status = new ImageView(SourceDir.STATUS_BG);
        status.setFitHeight(height * 0.1);
        status.setFitWidth(width * 0.1);

        ImageView status2 = new ImageView(SourceDir.STATUS_BG);
        status2.setFitHeight(height * 0.1);
        status2.setFitWidth(width * 0.1);

        bar.getChildren().add(status);
        bar2.getChildren().add(status2);

        life = new ImageView[6];
        life2 = new ImageView[6];
        for (int i = 0; i < 6; i++) {
            life[i] = new ImageView(SourceDir.LIFE);
            life2[i] = new ImageView(SourceDir.LIFE);

            life[i].setFitHeight(status.getFitWidth() / 8);
            life[i].setFitWidth(status.getFitWidth() / 8);

            life2[i].setFitHeight(status.getFitWidth() / 8);
            life2[i].setFitWidth(status.getFitWidth() / 8);

            life[i].setTranslateX(status.getFitWidth() * 0.2 + i * life[i].getFitWidth());
            life[i].setTranslateY(status.getFitHeight() * 0.5);

            life2[i].setTranslateX(status.getFitWidth() * 0.2 + i * life[i].getFitWidth());
            life2[i].setTranslateY(status.getFitHeight() * 0.5);

//            life[i].setVisible(false);
//            life2[i].setVisible(false);

            bar.getChildren().add(life[i]);
            bar2.getChildren().add(life2[i]);
        }


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
        player1.syncLife();
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
        player2.syncLife();
        Input inputPlayer = new Input(scene, player1, player2);
        inputPlayer.startLoopInput();

        saveMap.addItem(pane);

        pane.getChildren().add(player1.getCharacterCore());
        bar.addEventHandler(EventType.ROOT, new EventHandler<Event>() {
            @Override
            public void handle(Event event) {

            }
        });
        pane.getChildren().add(player2.getCharacterCore());
        pane.getChildren().addAll(bar, bar2);

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
    public static String getTypeCharP1() {
        return typeCharP1;
    }

    public static String getTypeCharP2() {
        return typeCharP2;
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
}
