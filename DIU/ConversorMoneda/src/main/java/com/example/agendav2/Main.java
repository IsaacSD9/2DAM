package com.example.agendav2;

import Modelo.ExcepcionMoneda;
import Modelo.MonedaVO;
import Modelo.repository.impl.MonedaRepositoryImpl;
import com.example.agendav2.controller.ConversorController;
import com.example.agendav2.model.ConversorModelo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("conversorView.fxml"));

        Scene conversor = new Scene(fxmlLoader.load(), 620, 240);

        try{
            ConversorController conversorController = fxmlLoader.getController();

            ConversorModelo  conversorModelo= new ConversorModelo();

            conversorModelo.setMonedaRepository(new MonedaRepositoryImpl());

            conversorController.setModelo(conversorModelo);

            conversorController.cambioCaja();

        }catch (ExcepcionMoneda e) { //Excepción si no se puede conectar a la base de datos
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setHeaderText("No se ha conectar a la base de datos para el cambio de monedas");
            alert.setContentText("Por favor, inicie el servidor con la base de datos");
            alert.showAndWait();
        }


        stage.setTitle("Conversor");
        stage.setScene(conversor);
        stage.show();


    }

    public static void main(String[] args) {
        launch(args); // Lanzo la aplicación


    }
}
