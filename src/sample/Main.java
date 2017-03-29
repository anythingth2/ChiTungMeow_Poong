package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
//        scene.setOnKeyPressed(ke -> {
//            KeyCode keyCode = ke.getCode();
//            if (keyCode.equals(KeyCode.UP)) {
//                System.out.println("UP");
//            }
//            if (keyCode.equals(KeyCode.DOWN)) {
//                System.out.println("down");
//            }
//            if (keyCode.equals(KeyCode.LEFT)) {
//                System.out.println("left");
//            }
//            if (keyCode.equals(KeyCode.RIGHT)) {
//                System.out.println("right");
//            }
//        });

        Pane pane=new Pane();
    }
    public static void main(String[] args) {
        launch(args);
    }

}
