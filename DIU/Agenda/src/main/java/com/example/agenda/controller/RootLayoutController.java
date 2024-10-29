package com.example.agenda.controller;

import javafx.fxml.FXML;
import javafx.stage.FileChooser;

import java.io.File;

public class RootLayoutController {
    private MainApp mainApp;

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }




    @FXML
    private void handleShowBirthdayStatistics() {
        MainApp.showBirthdayStatistics();
    }
}
