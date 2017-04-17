package sample;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * Created by ChiChaChai on 16/4/2560.
 */
abstract public class MainMenuScene extends Scene {

    private static Pane pane = new Pane();
    private ImageView BG = new ImageView(SourceDir.BG);
    private ImageView start = new ImageView(SourceDir.START_BUT);
    private ImageView howto = new ImageView(SourceDir.HOWTO_BUT);
    private ImageView exit = new ImageView(SourceDir.EXIT_BUT);
    private ImageView credit = new ImageView(SourceDir.CREDIT_BUT);

    public MainMenuScene(double width, double height) throws IllegalResolutionException {
        super(pane, width, height);
        if (width < 800 || width > 1920
                || height < 600 || height > 1200)
            throw new IllegalResolutionException();
        BG.setFitHeight(height);
        BG.setFitWidth(width);
        BG.relocate(0, 0);

        start.relocate(width / 100 * 25, height / 100 * 45);
        howto.relocate(width / 100 * 28, height / 100 * 58);
        exit.relocate(width / 100 * 25, height / 100 * 70);
        credit.relocate(width / 100 * 79, height / 100 * 83);


        BG.setOnMouseClicked(this::setStart);
        howto.setOnMouseClicked(this::setHowto);
        exit.setOnMouseClicked(this::setExit);
        credit.setOnMouseClicked(this::setCredit);

        pane.getChildren().addAll(BG,start,howto,exit,credit);
    }


    public abstract void setStart(MouseEvent e);

    abstract public void setHowto(MouseEvent e);

    abstract public void setExit(MouseEvent e);

    abstract public void setCredit(MouseEvent e);


}
