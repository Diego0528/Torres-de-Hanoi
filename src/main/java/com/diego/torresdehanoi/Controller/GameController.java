package com.diego.torresdehanoi.Controller;
import com.diego.torresdehanoi.Model.HanoiGame;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.scene.layout.AnchorPane;
import java.util.*;

public class GameController {

    @FXML
    private AnchorPane root;

    private HanoiGame juego;

    private int numTorres;
    private int numDiscos;

    private final List<Stack<Rectangle>> torresVisuales = new ArrayList<>();
    private final Queue<int[]> colaMovimientos = new LinkedList<>();

    private double anchoTorre = 10;
    private double altoTorre = 200;
    private double baseY = 320;

    // 🔹 ESTE MÉTODO LO LLAMAS DESDE SceneManager
    public void initJuego(int torres, int discos) {

        this.numTorres = torres;
        this.numDiscos = discos;

        juego = new HanoiGame(torres, discos);

        crearTorres();
        crearDiscos();

        generarMovimientos(numDiscos, 0, 1, 2);
        ejecutarAnimacion();
    }

    // =========================================================
    // CREAR TORRES
    // =========================================================
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

    // =========================================================
    // CREAR DISCOS
    // =========================================================
    private void crearDiscos() {

        double anchoMax = 120;
        double alto = 20;

        for (int i = numDiscos; i >= 1; i--) {

            Rectangle disco = new Rectangle(
                    anchoMax - (i * 10),
                    alto
            );

            disco.setFill(colorRandom());

            Stack<Rectangle> torre0 = torresVisuales.get(0);

            double xCentro = root.getPrefWidth() / (numTorres + 1);

            disco.setLayoutX(xCentro - disco.getWidth() / 2);
            disco.setLayoutY(baseY - (torre0.size() + 1) * alto);

            torre0.push(disco);
            root.getChildren().add(disco);
        }
    }

    private Color colorRandom() {
        return Color.color(Math.random(), Math.random(), Math.random());
    }

    // =========================================================
    // GENERAR MOVIMIENTOS (RECURSIVO)
    // =========================================================
    private void generarMovimientos(int n, int origen, int auxiliar, int destino) {

        if (n == 1) {
            colaMovimientos.add(new int[]{origen, destino});
            return;
        }

        generarMovimientos(n - 1, origen, destino, auxiliar);
        colaMovimientos.add(new int[]{origen, destino});
        generarMovimientos(n - 1, auxiliar, origen, destino);
    }

    // =========================================================
    // EJECUTAR ANIMACIÓN
    // =========================================================
    private void ejecutarAnimacion() {

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), e -> ejecutarMovimiento())
        );

        timeline.setCycleCount(colaMovimientos.size());
        timeline.play();
    }

    // =========================================================
    // MOVER DISCO VISUAL + MODELO
    // =========================================================
    private void ejecutarMovimiento() {

        int[] mov = colaMovimientos.poll();

        int origen = mov[0];
        int destino = mov[1];

        Stack<Rectangle> torreOrigen = torresVisuales.get(origen);
        Stack<Rectangle> torreDestino = torresVisuales.get(destino);

        Rectangle disco = torreOrigen.pop();

        double separacion = root.getPrefWidth() / (numTorres + 1);
        double nuevoCentroX = separacion * (destino + 1);

        disco.setLayoutX(nuevoCentroX - disco.getWidth() / 2);
        disco.setLayoutY(baseY - (torreDestino.size() + 1) * disco.getHeight());

        torreDestino.push(disco);

        juego.mover(origen, destino);
    }
}
