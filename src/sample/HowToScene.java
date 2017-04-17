package sample;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * Created by ChiChaChai on 16/4/2560.
 */
public abstract class HowToScene extends Scene  {
    private static Pane pane = new Pane();
    ImageView BGhowto = new ImageView(SourceDir.HOWTO_BG);
    ImageView home = new ImageView(SourceDir.HOME_BUT);
    public HowToScene(double width, double height) throws IllegalResolutionException {
        super(pane, width, height);
        if (width < 800 || width > 1920
                || height < 600 || height > 1200)
            throw new IllegalResolutionException();
        BGhowto.setFitWidth(width);
        BGhowto.setFitHeight(height);

        home.relocate(width / 100 * 85, height / 100 * 80);
        home.setFitHeight(width * 0.10);
        home.setFitWidth(width * 0.10);
        home.setOnMouseClicked(this::setHome);

        pane.getChildren().addAll(BGhowto, home);
    }

    public abstract void setHome(MouseEvent e);
    public void delete(){
        pane = null;
    }
}
