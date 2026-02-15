package com.diego.torresdehanoi.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.function.Consumer;

public class SceneManager {

    private static Stage stagePrincipal;

    public static void setStage(Stage stage) {
        stagePrincipal = stage;
    }

/*    public static void cambiarEscena(String rutaFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource(rutaFXML));
            Parent root = loader.load();
            stagePrincipal.setScene(new Scene(root));
            stagePrincipal.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
//test
    public static void cambiarEscena(String rutaFXML, Consumer<Object> controladorInit) {

        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource(rutaFXML));
            Parent root = loader.load();

            Object controller = loader.getController();
            controladorInit.accept(controller);

            stagePrincipal.setScene(new Scene(root));
            stagePrincipal.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void cambiarContenido(Pane destino, String rutaFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource(rutaFXML));
            Parent vista = loader.load();
            destino.getChildren().setAll(vista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //test
/*    public static <T> T cambiarEscenaConController(String rutaFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource(rutaFXML));
            Parent root = loader.load();

            stagePrincipal.setScene(new Scene(root));
            stagePrincipal.show();

            return loader.getController();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }*/

}
