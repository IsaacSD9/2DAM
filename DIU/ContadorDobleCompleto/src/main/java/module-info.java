module com.example.ejemplodiu {
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
    requires java.desktop;

    opens com.example.ejemplodiu to javafx.fxml;
    exports com.example.ejemplodiu;
    exports com.example.ejemplodiu.controller;
    opens com.example.ejemplodiu.controller to javafx.fxml;
}