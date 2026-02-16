package com.diego.torresdehanoi.Controller;
import com.diego.torresdehanoi.Model.HanoiGame;
import com.diego.torresdehanoi.utils.Paths;
import com.diego.torresdehanoi.utils.SceneManager;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.scene.layout.AnchorPane;
import java.util.*;

import javax.swing.*;

public class GameController {

    @FXML
    private AnchorPane root;
    @FXML
    private Label lblContador;

    private HanoiGame juego;

    private int numTorres;
    private int numDiscos;

    private final List<Stack<Rectangle>> torresVisuales = new ArrayList<>();
    private final Queue<int[]> colaMovimientos = new LinkedList<>();

    private final double anchoTorre = 10;
    private final double altoTorre = 200;
    private final double baseY = 360;
    int nMov = 0;

    public void initJuego(int torres, int discos) {

        this.numTorres = torres;
        this.numDiscos = discos;

        juego = new HanoiGame(torres, discos);

        crearTorres();
        crearDiscos();

        juego.resolver(numDiscos, 0, numTorres - 2, numTorres - 1);

        colaMovimientos.addAll(juego.getMovimientos());

        ejecutarAnimacion();
    }

    private void crearTorres() {

        double separacion = root.getPrefWidth() / (numTorres + 1);

        for (int i = 0; i < numTorres; i++) {

            Rectangle torre = new Rectangle(anchoTorre, altoTorre);
            torre.setLayoutX(separacion * (i + 1));
            torre.setLayoutY(baseY - altoTorre);
            torre.setFill(Color.DARKGRAY);

            root.getChildren().add(torre);
            torresVisuales.add(new Stack<>());
        }
    }

    private void crearDiscos() {

        double anchoMax = 120;
        double alto = 20;

        for (int i = 0; i < numDiscos; i++) {

            Rectangle disco = new Rectangle(
                    anchoMax - (i * 10),
                    alto
            );

            disco.setFill(colorRandom());

            Stack<Rectangle> torre0 = torresVisuales.getFirst();

            double separacion = root.getPrefWidth() / (numTorres + 1);
            double xCentro = separacion * 1;


            disco.setLayoutX(xCentro - disco.getWidth() / 2);
            disco.setLayoutY(baseY - (torre0.size() + 1) * alto);

            torre0.push(disco);
            root.getChildren().add(disco);
        }
    }

    private Color colorRandom() {
        return Color.color(Math.random(), Math.random(), Math.random());
    }

    private void ejecutarAnimacion() {

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), e -> ejecutarMovimiento())
        );

        timeline.setCycleCount(colaMovimientos.size());
        timeline.play();

    }

    private void ejecutarMovimiento() {

        int[] mov = colaMovimientos.poll();

        assert mov != null;
        int origen = mov[0];
        int destino = mov[1];

        if (!juego.mover(origen, destino)) {
            return;
        }

        Stack<Rectangle> torreOrigen = torresVisuales.get(origen);
        Stack<Rectangle> torreDestino = torresVisuales.get(destino);

        Rectangle disco = torreOrigen.pop();

        double separacion = root.getPrefWidth() / (numTorres + 1);
        double nuevoCentroX = separacion * (destino + 1);

        disco.setLayoutX(nuevoCentroX - disco.getWidth() / 2);
        disco.setLayoutY(baseY - (torreDestino.size() + 1) * disco.getHeight());

        torreDestino.push(disco);

        nMov++;
        lblContador.setText("Numero de Moviminetos: "+nMov);

        if(juego.resuelto(numDiscos)) {
            javafx.scene.control.Button btnRegresar = new javafx.scene.control.Button("Regresar");
            root.getChildren().add(btnRegresar);

            btnRegresar.setStyle("""
                    -fx-background-color: #3e9892;
                    -fx-text-fill: #1a0b46;
                    -fx-font-weight: bold;
                    -fx-font-size: 18px;
                    -fx-background-radius: 8;
                    -fx-padding: 10 40;
                    -fx-effect: dropshadow(three-pass-box, rgba(138,43,226,0.4), 20, 0, 0, 0);""");

            btnRegresar.setLayoutX(275);
            btnRegresar.setLayoutY(380);

            btnRegresar.setOnAction(e -> regresar());

        }
    }
    private void regresar(){
        SceneManager.cambiarEscena(Paths.MainView, controller -> {});
    }
}
