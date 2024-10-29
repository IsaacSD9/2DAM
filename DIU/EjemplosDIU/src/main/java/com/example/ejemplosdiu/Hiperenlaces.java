package com.example.ejemplosdiu;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Hiperenlaces extends Application {

    @Override
    public void start(Stage escenarioPrincipal) {
        try {
            VBox raiz = new VBox();
            raiz.setPadding(new Insets(40));
            raiz.setSpacing(10);

            Label lbElige;
            lbElige = new Label("Puedes visitar los siguientes enlaces:");

            Hyperlink hlSevillaFC = new Hyperlink("Sevilla FC");
            Hyperlink hlMarca = new Hyperlink("Marca");
            Hyperlink hlValleInclan = new Hyperlink("IES Valle-Inclán");

            hlValleInclan.setVisited(true);

            VBox.setMargin(hlSevillaFC, new Insets(0, 0, 0, 30));
            VBox.setMargin(hlMarca, new Insets(0, 0, 0, 30));
            VBox.setMargin(hlValleInclan, new Insets(0, 0, 0, 30));

            raiz.getChildren().addAll(lbElige, hlSevillaFC, hlMarca, hlValleInclan);

            Scene escena = new Scene(raiz, 350, 200);
            escenarioPrincipal.setTitle("Hiperenlaces");
            escenarioPrincipal.setScene(escena);
            escenarioPrincipal.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}