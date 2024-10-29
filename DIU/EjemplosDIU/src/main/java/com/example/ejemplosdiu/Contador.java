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


public class Contador extends Application {
    private Button boton;
    Label lbElige; //Declaramos el label fuera para poder utilizarlo en el metodo y el programa principal
    private int numPulsaciones = 0; // Declaramos el contador de pulsaciones a 0

    private void botones(int numero){
        numPulsaciones= numPulsaciones + numero;
        numPulsaciones= (numero==0) ? 0 : numPulsaciones; // Comprobamos si es 0 con el operador ternario
        lbElige.setText(String.valueOf(numPulsaciones)); // Cambiamos el valor del label para imprimir la variable que contiene el número de veces que se ha pulsado el botón

        // if (numero==0){
     //   numPulsaciones=0;
   // }

    }

    //Estos tres métodos de abajo los hemos juntado en una sola función que hace las tres opciones dependiendo del parámetro

   // private void mas() {
     //   ++numPulsaciones; // Se incrementa el número de veces que hemos pulsado
      //  lbElige.setText(String.valueOf(numPulsaciones)); // Cambiamos el valor del label para imprimir la variable que contiene el número de veces que se ha pulsado el botón
    // Para poner una variable sola en un label hay que poner String.valueOf(variable)
   // }

  //  private void menos() {
     //   --numPulsaciones;
      //  lbElige.setText(String.valueOf(numPulsaciones)); // Cambiamos el valor del label para imprimir la variable que contiene el número de veces que se ha pulsado el botón
        // Para poner una variable sola en un label hay que poner String.valueOf(variable)
    //}

  //  private void cero() {
    //    numPulsaciones=0;
      //  lbElige.setText(String.valueOf(numPulsaciones)); // Cambiamos el valor del label para imprimir la variable que contiene el número de veces que se ha pulsado el botón
        // Para poner una variable sola en un label hay que poner String.valueOf(variable)
   // }

    @Override
    public void start(Stage escenarioPrincipal) {
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


            Scene escena = new Scene(principal, 500, 200);
            escena.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/styles/contador.css")).toExternalForm());
            escenarioPrincipal.setTitle("Contador");
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