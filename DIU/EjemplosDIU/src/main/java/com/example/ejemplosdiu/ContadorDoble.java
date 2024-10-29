package com.example.ejemplosdiu;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.Objects;

public class ContadorDoble  extends Application {




    @Override
    public void start(Stage escenarioPrincipal) {

        try {
            Stage escenario2= new Stage();
        EscenaContador c1= new EscenaContador();
        EscenaContador c2= new EscenaContador();
        c1.setStage(escenarioPrincipal);
        c2.setStage(escenario2);

            escenarioPrincipal.show();
            escenario2.show();
            c1.numpulsaciones.bindBidirectional(c2.numpulsaciones);


        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}