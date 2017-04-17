package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;


public class Game extends Application implements Sound {

    private static final double width = 1280;
    private static final double height = 960;

    private static Stage theStage;

    private static MainMenuScene menu;
    private static GameScene game;
    private static SelectCharacterScene characterSelect;
    private static HowToScene howto;
    private static CreditScene credit;

    static int i = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        theStage = primaryStage;
        menu = new MainMenuScene(width, height) {

            @Override
            public void setStart(MouseEvent e) {
                CS1(e);
            }

            @Override
            public void setHowto(MouseEvent e) {
                CS2(e);
            }

            @Override
            public void setExit(MouseEvent e) {
                CS3(e);
            }

            @Override
            public void setCredit(MouseEvent e) {
                CS4(e);
            }
        };
        howto = new HowToScene(width, height) {
            @Override
            public void setHome(MouseEvent e) {
                CS0(e);
            }
        };
        credit = new CreditScene(width, height) {
            @Override
            public void setHome(MouseEvent e) {
                CS0(e);
            }
        };
        characterSelect = new SelectCharacterScene(width, height);
        BACKGROUND_MUSIC.setCycleCount(AudioClip.INDEFINITE);
        BACKGROUND_MUSIC.play(0.25);
        changeScene(menu);
    }


    public static void changeScene(Scene scene) {


        theStage.setScene(scene);
        theStage.show();

    }

    private static void CS0(MouseEvent e) {
        changeScene(menu);
    }

    private static void CS1(MouseEvent e) {
        changeScene(characterSelect);
    }

    private static void CS2(MouseEvent e) {
        changeScene(howto);
    }

    private static void CS3(MouseEvent e) {
        System.exit(0);
    }

    private static void CS4(MouseEvent e) {
        changeScene(credit);
    }

    public static MainMenuScene getMenu() {
        return menu;
    }

    public static GameScene getGame() {
        return game;
    }

    public static SelectCharacterScene getCharacterSelect() {
        return characterSelect;
    }

    public static void setGame(GameScene game) {
        Game.game = game;
    }

    public static double getWidth() {
        return width;
    }

    public static double getHeight() {
        return height;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
