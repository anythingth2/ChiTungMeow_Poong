package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.util.Date;

public class Main extends Application {

    public void eiei(String ss, Date ssd) {


    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        ImageView imgv = new ImageView("bin\\logo-kmitl.jpg");


        Pane root = new Pane();


        root.getChildren().add(imgv);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();


        while (true) {


            root.setTranslateX(root.getTranslateX() + 1);
        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}
