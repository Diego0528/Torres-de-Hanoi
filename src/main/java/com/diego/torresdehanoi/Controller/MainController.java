package com.diego.torresdehanoi.Controller;

import com.diego.torresdehanoi.utils.Paths;
import com.diego.torresdehanoi.utils.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;


public class MainController {
//Objetos FXML
    @FXML
    private Button iniciarbtn;

    @FXML
    private Label lbContador;

    @FXML
    private Slider sdrTorres;

    @FXML
    private Slider sldDiscos;

    @FXML
    void cambioValDiscos(MouseEvent event) {
        lbContador.setText(String.valueOf(minMovimientos()));
    }

    @FXML
    void cambioValTorres(MouseEvent event) {
        lbContador.setText(String.valueOf(minMovimientos()));
    }

    //Inicializacion
    @FXML
    public void initialize(){
        lbContador.setText(String.valueOf(minMovimientos()));
        iniciarbtn.setOnMouseClicked(e -> iniciarHanoi());
    }

    private int minMovimientos(){
        int numTorres = (int) sdrTorres.getValue();
        int numDiscos = (int) sldDiscos.getValue();
        return (int) Math.pow(2, numDiscos) - 1;
    }

    public int getNumTorres(){
        return (int) sdrTorres.getValue();
    }
    public int getNumDiscos(){
        return (int) sldDiscos.getValue();
    }

    private void iniciarHanoi() {

        int torres = getNumTorres();
        int discos = getNumDiscos();

        SceneManager.cambiarEscena(Paths.GameView, controller -> {
            GameController game = (GameController) controller;
            game.initJuego(torres, discos);
        });
    }


}