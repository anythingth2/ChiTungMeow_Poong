package sample;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;


/**
 * Created by ChiChaChai on 16/4/2560.
 */
public class SelectCharacterScene extends Scene {


    private static Pane pane = new Pane();
    private ImageView bg = new ImageView(SourceDir.CHARACTER_SELECT_BG);
    private ImageView nextCharP1 = new ImageView(SourceDir.NEXT_BUT);
    private ImageView previousCharP1 = new ImageView(SourceDir.PREVIOUS_BUT);
    private ImageView nextCharP2 = new ImageView(SourceDir.NEXT_BUT);
    private ImageView previousCharP2 = new ImageView(SourceDir.PREVIOUS_BUT);
    private PlayerObj p1 = new PlayerObj(pane, SourceDir.CAT) {
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

        @Override
        public void onDie() {

        }
    };
    private PlayerObj p2 = new PlayerObj(pane, SourceDir.RABBIT) {
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

        @Override
        public void onDie() {

        }
    };
    private ImageView playBut = new ImageView(SourceDir.NEXT_BUT);
    private ImageView homeBut = new ImageView(SourceDir.HOME_BUT);

    private String typeCharP1;
    private String typeCharP2;
    private int countClickChooseCharP1 = 0;
    private int countClickChooseCharP2 = 1;

    public SelectCharacterScene(double width, double height) throws IllegalResolutionException {
        super(pane, width, height);
        if (width < 800 || width > 1920
                || height < 600 || height > 1200)
            throw new IllegalResolutionException();
        bg.setFitWidth(width);
        bg.setFitHeight(height);
        pane.getChildren().add(bg);

        p1.getCharacterCore().setFitHeight(height * 0.35);
        p1.getCharacterCore().setFitWidth(width * 0.3);
        p1.setX(width * 0.115);
        p1.setY(height * 0.4);
        p1.Down.play();

        p2.getCharacterCore().setFitHeight(height * 0.35);
        p2.getCharacterCore().setFitWidth(width * 0.3);
        p2.setX(width * 0.115 + width * 0.45);
        p2.setY(height * 0.4);
        p2.Down.play();

        nextCharP1.setFitWidth(width * 0.1);
        nextCharP1.setFitHeight(height * 0.1);
        nextCharP1.relocate(width / 2 - width * 0.1, height * 0.5);
        nextCharP1.setOnMouseClicked(event -> {
            if (countClickChooseCharP1 >= SourceDir.CHAR_TYPE.length - 1) countClickChooseCharP1 = -1;
            p1.setType(SourceDir.CHAR_TYPE[++countClickChooseCharP1]);

        });

        previousCharP1.setFitHeight(height * 0.1);
        previousCharP1.setFitWidth(width * 0.1);
        previousCharP1.relocate(width / 2 - width * 0.473, height * 0.5);
        previousCharP1.setOnMouseClicked(event -> {
            if (countClickChooseCharP1 < 1) countClickChooseCharP1 = SourceDir.CHAR_TYPE.length;
            p1.setType(SourceDir.CHAR_TYPE[--countClickChooseCharP1]);

        });

        nextCharP2.setFitWidth(width * 0.1);
        nextCharP2.setFitHeight(height * 0.1);
        nextCharP2.relocate(width / 2 + width * 0.373, height * 0.5);
        nextCharP2.setOnMouseClicked(event -> {
            if (countClickChooseCharP2 >= SourceDir.CHAR_TYPE.length - 1) countClickChooseCharP2 = -1;
            p2.setType(SourceDir.CHAR_TYPE[++countClickChooseCharP2]);

        });

        previousCharP2.setFitHeight(height * 0.1);
        previousCharP2.setFitWidth(width * 0.1);
        previousCharP2.relocate(width / 2, height * 0.5);
        previousCharP2.setOnMouseClicked(event -> {
            if (countClickChooseCharP2 < 1) countClickChooseCharP2 = SourceDir.CHAR_TYPE.length;
            p2.setType(SourceDir.CHAR_TYPE[--countClickChooseCharP2]);

        });


        playBut.setFitHeight(height * 0.1);
        playBut.setFitWidth(width * 0.1);
        playBut.relocate(width * 0.85, height * 0.85);
        playBut.setOnMouseClicked(event -> {
            typeCharP1 = SourceDir.CHAR_TYPE[countClickChooseCharP1];
            typeCharP2 = SourceDir.CHAR_TYPE[countClickChooseCharP2];
            Game.setGame(new GameScene(width, height));
            Game.getGame().syncLife();
            Game.changeScene(Game.getGame());
        });

        homeBut.setFitHeight(height * 0.1);
        homeBut.setFitWidth(width * 0.1);
        homeBut.relocate(width * 0.1, height * 0.85);
        homeBut.setOnMouseClicked(event -> Game.changeScene(Game.getMenu()));

        pane.getChildren().addAll(nextCharP1
                , previousCharP1
                , nextCharP2
                , previousCharP2
                , p1.getCharacterCore()
                , p2.getCharacterCore()
                , playBut
                , homeBut);

    }

    public String getTypeCharP1() {
        return typeCharP1;
    }

    public String getTypeCharP2() {
        return typeCharP2;
    }
}
