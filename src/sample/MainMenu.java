
package sample;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MainMenu extends Application {
    Stage thestage;
    Scene mainmenu;
    private double width;
    private double height;
    @Override
    public void start(Stage primaryStage) {
        thestage=primaryStage;

        ImageView BG = new ImageView("BG.jpg");

        ImageView Menu = new ImageView("Menu.png");
        Menu.relocate(174, 211);

        ImageView Howto = new ImageView("Howto.png");
        Howto.relocate(218, 278);

        ImageView exit = new ImageView("Exit.png");
        exit.relocate(157, 342);

        ImageView wood = new ImageView("normalwood.png");
        wood.relocate(288 , 412);


        ImageView credit = new ImageView("credit.png");
        credit.relocate(649 , 316);

        Menu.setOnMouseClicked(e-> CS1(e));
        Howto.setOnMouseClicked(e-> CS2(e));
        exit.setOnMouseClicked(e-> CS3(e));
        credit.setOnMouseClicked(e-> CS4(e));
        Group root = new Group();
        root.setOnMousePressed(mouseHandler);
        root.setOnMouseReleased(mouseHandler2);
        root.getChildren().addAll(BG , Menu , Howto , exit , wood, credit);
        mainmenu = new Scene(root, 850, 511);
        Image imag = new Image("curssor\\foot_steps_feet.png");
        mainmenu.setCursor(new ImageCursor(imag,imag.getWidth() /3,imag.getHeight() /3));
        thestage.setScene(mainmenu);
        thestage.setTitle("fubukai1");
        thestage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    public void CS1(MouseEvent e)
    {
        /// Change to startgame
        //thestage.setScene(***);
    }
    public void CS2(MouseEvent e)
    {
        /// Change to howto
        //thestage.setScene(***);
    }
    public void CS3(MouseEvent e)
    {
        System.exit(0);
    }
    public void CS4(MouseEvent e)
    {
        /// Change to credit
        // thestage.setScene(***);
    }
    EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent mouseEvent) {
            Image image2 = new Image("curssor\\cat_animal.png");
            mainmenu.setCursor(new ImageCursor(image2,image2.getWidth() /3,image2.getHeight() /3));
        }

    };
    EventHandler<MouseEvent> mouseHandler2 = new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent mouseEvent) {
            Image image = new Image("curssor\\foot_steps_feet.png");
            mainmenu.setCursor(new ImageCursor(image,image.getWidth() /3,image.getHeight() /3));
        }

    };

}
