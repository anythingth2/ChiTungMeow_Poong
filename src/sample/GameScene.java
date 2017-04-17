package sample;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * Created by ChiChaChai on 16/4/2560.
 */
public class GameScene extends Scene {
    private static Pane pane = new Pane();
    private ImageView bg = new ImageView(SourceDir.EMPTY_BG);
    private SaveMap saveMap;
    private Pane bar = new Pane();
    private Pane bar2 = new Pane();
    private ImageView status = new ImageView(SourceDir.STATUS_BG);
    private ImageView status2 = new ImageView(SourceDir.STATUS_BG);
    private ImageView[] life = new ImageView[6];
    private ImageView[] life2 = new ImageView[6];
    private int startLife = 3;
    private int lifes = startLife;
    private int lifes2 = startLife;
    private double resP1posX, resP2posX, resP1posY, resP2posY;
    private static PlayerObj player1, player2;
    private ImageView win, lose;
    private ImageView homeBut = new ImageView(SourceDir.HOME_BUT);
    private Input inputPlayer;

    public GameScene(double width, double height)

    {
        super(pane, width, height);
        saveMap = new SaveMap(20, 20, width, height);
        win = new ImageView(SourceDir.WIN);
        lose = new ImageView(SourceDir.LOSE);
        win.setFitWidth(375);
        win.setFitHeight(275);
        lose.setFitWidth(325);
        lose.setFitHeight(250);
        resP1posX = width * 0.25 - win.getFitWidth() / 2;
        resP1posY = height / 2 - win.getFitHeight() / 2;
        resP2posY = width * 0.75 - lose.getFitWidth() / 2;
        resP2posY = height / 2 - lose.getFitHeight() / 2;

        homeBut.setFitWidth(width * 0.1);
        homeBut.setFitHeight(height * 0.1);
        homeBut.relocate(width * 0.8, height * 0.8);
        homeBut.setVisible(false);
        homeBut.setOnMouseClicked(event -> Game.changeScene(Game.getMenu()));
        win.relocate(width * 0.25 - win.getFitWidth() / 2, height / 2 - win.getFitHeight() / 2);
        lose.relocate(width * 0.75 - lose.getFitWidth() / 2, height / 2 - lose.getFitHeight() / 2);

        player1 = new PlayerObj(pane, Game.getCharacterSelect().getTypeCharP1()) {
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

            @Override
            public void onDie() {
                lose.relocate(width * 0.25 - win.getFitWidth() / 2, height / 2 - win.getFitHeight() / 2);
                win.relocate(width * 0.75 - lose.getFitWidth() / 2, height / 2 - lose.getFitHeight() / 2);

                win.setVisible(true);
                lose.setVisible(true);
                homeBut.setVisible(true);
            }
        };
        player2 = new PlayerObj(pane, Game.getCharacterSelect().getTypeCharP2()) {
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

            @Override
            public void onDie() {
                win.relocate(width * 0.25 - win.getFitWidth() / 2, height / 2 - win.getFitHeight() / 2);
                lose.relocate(width * 0.75 - lose.getFitWidth() / 2, height / 2 - lose.getFitHeight() / 2);

                win.setVisible(true);
                lose.setVisible(true);
                homeBut.setVisible(true);
            }
        };

        player1.setX(width / 2 - player1.getCharacterCore().getFitWidth());
        player1.setY(height * 0.3);

        player2.setX(width / 2 - player2.getCharacterCore().getFitWidth());
        player2.setY(height * 0.8);
        player1.setHp(startLife);
        player2.setHp(startLife);

        bg.setFitWidth(width);
        bg.setFitHeight(height);
        pane.getChildren().add(bg);


        bar = new Pane();
        bar2 = new Pane();
        bar.setTranslateX(0);
        bar.setTranslateY(0);
        bar2.setTranslateX(width * 0.9);
        bar2.setTranslateY(0);

        status.setFitHeight(height * 0.1);
        status.setFitWidth(width * 0.1);

        status2.setFitHeight(height * 0.1);
        status2.setFitWidth(width * 0.1);


        win.setVisible(false);
        lose.setVisible(false);


        bar.getChildren().add(status);
        bar2.getChildren().add(status2);


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

            bar.getChildren().add(life[i]);
            bar2.getChildren().add(life2[i]);
        }


        inputPlayer = new Input(this, player1, player2);
        inputPlayer.startLoopInput();

        saveMap.addItem(pane);

        pane.getChildren().add(player1.getCharacterCore());
        bar.addEventHandler(EventType.ROOT, event -> {

        });
        pane.getChildren().add(player2.getCharacterCore());
        pane.getChildren().addAll(bar, bar2);
        pane.getChildren().addAll(win, lose, homeBut);


    }

    public static PlayerObj getPlayer1() {
        return player1;
    }

    public static PlayerObj getPlayer2() {
        return player2;
    }

    public ImageView[] getLife() {
        return life;
    }

    public ImageView[] getLife2() {
        return life2;
    }

    public void delete() {
        pane = null;
    }

    public void syncLife() {
        player1.syncLife();
        player2.syncLife();
        lifes = player1.getHp();
        lifes2 = player2.getHp();

    }

    @Override
    public String toString() {

        return super.toString() + "THIS IS A GAME";
    }
}
