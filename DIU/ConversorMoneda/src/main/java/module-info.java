module com.example.agendav2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires AccesoBBDDMoneda;
    requires java.sql;

    opens com.example.agendav2 to javafx.fxml;
    exports com.example.agendav2;
    exports com.example.agendav2.controller;
    opens com.example.agendav2.controller to javafx.fxml;
    exports com.example.agendav2.model;
    opens com.example.agendav2.model to javafx.fxml;
}