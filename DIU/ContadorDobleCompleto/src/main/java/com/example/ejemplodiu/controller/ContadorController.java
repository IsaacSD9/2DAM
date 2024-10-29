package com.example.ejemplodiu.controller;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class ContadorController {


    @FXML
    private Label contador;

    @FXML
    private ProgressBar barra;

    @FXML
    private TextField texto1;

    public IntegerProperty numpulsaciones = new SimpleIntegerProperty(0);

    @FXML
   public void botonMas() {
        numpulsaciones.set(numpulsaciones.get() + 1);
        contador.setText(String.valueOf(numpulsaciones.get()));
        barra.setProgress(numpulsaciones.get()*0.02);
    }

    @FXML
    void botonMenos() {
        numpulsaciones.set(numpulsaciones.get() - 1);
        contador.setText(String.valueOf(numpulsaciones.get()));
        barra.setProgress(numpulsaciones.get()*0.02);

    }

    @FXML
    void botonCero() {
        numpulsaciones.set(0);
        contador.setText(String.valueOf(numpulsaciones.get()));
        barra.setProgress(numpulsaciones.get()*0.02);

    }


    // Este metodo se llama al inicializar el controlador
    @FXML
    void initialize() {
        texto1.setOnKeyPressed(event -> {
            if (event.getCode().getName().equals("Enter")) {
                // Cuando se presione el Enter, convierto el texto introducido en el TextField a Integer y actualizo el contador
                numpulsaciones.set(Integer.parseInt(texto1.getText()));
                contador.setText(String.valueOf(numpulsaciones.get()));
                barra.setProgress(numpulsaciones.get()*0.02);
            }
        });

        numpulsaciones.addListener((obs, oldValue, newValue) -> {
            contador.setText(String.valueOf(numpulsaciones.get()));
            barra.setProgress(numpulsaciones.get()*0.02);});
    }
}








