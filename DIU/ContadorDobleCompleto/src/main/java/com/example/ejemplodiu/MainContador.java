package com.example.ejemplodiu;

import com.example.ejemplodiu.controller.ContadorController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainContador extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainContador.class.getResource("hello-view.fxml"));

        Scene contador1 = new Scene(fxmlLoader.load(), 320, 240);
        contador1.getStylesheets().add(getClass().getResource("/styles/estilo.css").toExternalForm());

        ContadorController controlador1 = fxmlLoader.getController();

        stage.setTitle("CONTADOR 1");
        stage.setScene(contador1);
        stage.show();

        Stage stage2 = new Stage();
        FXMLLoader fxmlLoader2 = new FXMLLoader(MainContador.class.getResource("hello-view.fxml"));
        Scene contador2 = new Scene(fxmlLoader2.load(), 320, 240);
        contador2.getStylesheets().add(getClass().getResource("/styles/estilo.css").toExternalForm());
        ContadorController controlador2 = fxmlLoader2.getController();

        //Conectamos el número de veces que se ha pulsado el contador entre los dos contadores
        controlador1.numpulsaciones.bindBidirectional(controlador2.numpulsaciones);

        stage2.setTitle("CONTADOR 2");
        stage2.setScene(contador2);
        stage2.show();
    }

    // Metodo principal para iniciar la aplicación
    public static void main(String[] args) {
        launch(args); // Lanzo la aplicación
    }
}