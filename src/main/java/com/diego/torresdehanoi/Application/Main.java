package com.diego.torresdehanoi.Application;

import com.diego.torresdehanoi.utils.SceneManager;
import com.diego.torresdehanoi.utils.Paths;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        SceneManager.setStage(primaryStage);
        Parent root = FXMLLoader.load((getClass().getResource(Paths.MainView)));
        Scene scene = new Scene(root);

        primaryStage.setTitle("Torres de Hanoi");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {launch(args);}
}