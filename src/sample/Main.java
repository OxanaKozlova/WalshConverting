package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{




        Parent root = FXMLLoader.load(getClass().getResource("fastConversion.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Digital Conversion");
      //  FastConversion functionPhase = new FastConversion();

        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
