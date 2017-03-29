package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import javafx.stage.Stage;


public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {


        ImageView imgv = new ImageView("bin\\logo-kmitl.jpg");

        Pane root = new Pane();


        root.getChildren().add(imgv);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();




    }


    public static void main(String[] args) {
        launch(args);
    }
}
