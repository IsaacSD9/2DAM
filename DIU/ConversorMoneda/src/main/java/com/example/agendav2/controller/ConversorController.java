package com.example.agendav2.controller;

import Modelo.ExcepcionMoneda;
import Modelo.repository.MonedaRepository;
import com.example.agendav2.model.ConversorModelo;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class ConversorController {
    private ConversorModelo modelo;

    public void setModelo(ConversorModelo modelo) {
        this.modelo = modelo;
    }

    @FXML
    private TextField cajaEuros;

    @FXML
    private TextField cajaDolares;

    @FXML
    public void initialize() {
        cajaEuros.setText("0");
    }

    public void cambioCaja() throws ExcepcionMoneda{
            cajaEuros.setOnKeyPressed(event -> {
                if (event.getCode().getName().equals("Enter")) {
                    try {
                            cajaDolares.setText(String.valueOf(modelo.cambioMoneda(Integer.parseInt(cajaEuros.getText()), modelo.setMonedas().get(0).getMultiplicador())));


                    } catch (ExcepcionMoneda e) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("ERROR");
                        alert.setHeaderText("No se ha podido recuperar información de cambio de monedas");
                        alert.setContentText("Por favor, intentelo más tarde");
                        alert.showAndWait();
                    }

                }
            });
        }


    }

