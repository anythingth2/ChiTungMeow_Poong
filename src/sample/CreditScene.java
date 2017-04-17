package sample;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * Created by ChiChaChai on 16/4/2560.
 */
public abstract class CreditScene extends Scene {
    private static Pane pane = new Pane();
    private ImageView BGcredit = new ImageView(SourceDir.CREDIT_BG);
    ImageView home = new ImageView(SourceDir.HOME_BUT);

    public CreditScene(double width, double height) throws IllegalResolutionException {
        super(pane, width, height);
        if (width < 800 || width > 1920
                || height < 600 || height > 1200)
            throw new IllegalResolutionException();
        BGcredit.setFitWidth(width);
        BGcredit.setFitHeight(height);

        home.relocate(width / 100 * 85, height / 100 * 80);
        home.setFitHeight(width * 0.10);
        home.setFitWidth(width * 0.10);
        home.setOnMouseClicked(this::setHome);

        pane.getChildren().addAll(BGcredit, home);
    }

    public abstract void setHome(MouseEvent e);

    public void delete(){
        pane = null;
    }
}
