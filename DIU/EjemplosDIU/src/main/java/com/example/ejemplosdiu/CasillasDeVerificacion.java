package com.example.ejemplosdiu;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CasillasDeVerificacion extends Application {

    @Override
    public void start(Stage escenarioPrincipal) {
        try {
            VBox raiz = new VBox();
            raiz.setPadding(new Insets(40));
            raiz.setSpacing(10);

            Label lbElige;
            lbElige = new Label("Elige los extras:");
            lbElige.setFont(Font.font(20));

            CheckBox cbNavegadorGPS, cbAltavocesStereo, cbLunas;
            cbNavegadorGPS = new CheckBox("NavegadorGPS");
            cbAltavocesStereo = new CheckBox("AltavocesStereo");
            cbLunas = new CheckBox("Lunas tintadas");
            cbLunas.setAllowIndeterminate(true);

            VBox.setMargin(cbNavegadorGPS, new Insets(0, 0, 0, 30));
            VBox.setMargin(cbAltavocesStereo, new Insets(0, 0, 0, 30));
            VBox.setMargin(cbLunas, new Insets(0, 0, 0, 30));

            raiz.getChildren().addAll(lbElige, cbNavegadorGPS, cbAltavocesStereo, cbLunas);

            Scene escena = new Scene(raiz, 350, 200);
            escenarioPrincipal.setTitle("Casillas de verificación(EXTRAS)");
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
