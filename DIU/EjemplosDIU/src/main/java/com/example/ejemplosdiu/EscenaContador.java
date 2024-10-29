package com.example.ejemplosdiu;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
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

public class EscenaContador {
    Label lbElige; //Declaramos el label fuera para poder utilizarlo en el metodo y el programa principal
    //. Se utiliza para que otros objetos pueden "escuchar" los cambios en esta propiedad y reaccionar a ellos.
    SimpleIntegerProperty numpulsaciones = new SimpleIntegerProperty(0); // Contador como propiedad
    private void botones(int numero){
        numpulsaciones.set((numero == 0) ? 0 : numpulsaciones.get() + numero);


    }

    public void setStage(Stage escenario){

        try {


    HBox raiz2 = new HBox();
            raiz2.setPadding(new Insets(10));
            raiz2.setSpacing(40);

            raiz2.setAlignment(Pos.CENTER);

    Button btmas, btmenos, bt0;
    btmas = new Button();
    btmenos = new Button();
    bt0 = new Button();
            bt0.setId("fondonegro");

            btmas.setText("+");
            btmas.setOnAction(e -> botones(1)); // Si pulsamos en el botón más llamaremos a la función mas
            btmenos.setText("-");
            btmenos.setOnAction(e -> botones(-1));
            bt0.setText("0");
            bt0.setOnAction(e -> botones(0));

            raiz2.getChildren().addAll(btmas, btmenos, bt0);



    lbElige = new Label("0"); // Por defecto el texto será un 0 si no hemos pulsado
            lbElige.setFont(Font.font(40));
            lbElige.getStyleClass().add("textoazul");
    VBox principal = new VBox();
            principal.setPadding(new Insets(10));
            principal.setAlignment(Pos.TOP_CENTER);
            principal.setId("fondorojo");
            principal.getChildren().addAll(raiz2, lbElige);

            // Actualiza el Label cuando cambia el valor
            //Para poder cambiar el numpulsaciones
            //Estructura: obs(representa numpulsaciones), oldvalue(valor antes del cambio) y newValue(despues)
            numpulsaciones.addListener((obs, oldvalue, newValue) -> {
                lbElige.setText(String.valueOf(newValue));});

            Scene escena= new Scene(principal, 500, 200);
            escena.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/styles/contador.css")).toExternalForm());
            escenario.setTitle("Contador1");
            escenario.setScene(escena);
            escenario.show();

}catch(Exception e) {
            e.printStackTrace();
        }
}
}