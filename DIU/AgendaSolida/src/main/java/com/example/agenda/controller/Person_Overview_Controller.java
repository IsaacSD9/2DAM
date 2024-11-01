package com.example.agenda.controller;
import com.example.agenda.MainApp;
import com.example.agenda.model.AgendaModel;
import com.example.agenda.model.ExcepcionPerson;
import com.example.agenda.model.repository.PersonRepository;
import com.example.agenda.model.repository.impl.PersonRepositoryImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import com.example.agenda.view.Person;
import com.example.agenda.util.DateUtil;

public class Person_Overview_Controller {
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label birthdayLabel;

    // Reference to the main application.
    private MainApp mainApp;
    private AgendaModel modeloAgenda;
    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */

    public void setAgendaModelo(AgendaModel modeloAgenda)  throws ExcepcionPerson{
        this.modeloAgenda = modeloAgenda;
    }

    public Person_Overview_Controller() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());

        showPersonDetails(null);

        // Listen for selection changes and show the person details when changed.
        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));

    }


    private void showPersonDetails(Person person) {
        if (person != null) {
            // Fill the labels with info from the person object.
            firstNameLabel.setText(person.getFirstName());
            lastNameLabel.setText(person.getLastName());
            streetLabel.setText(person.getStreet());
            postalCodeLabel.setText(Integer.toString(person.getPostalCode()));
            cityLabel.setText(person.getCity());
            birthdayLabel.setText(DateUtil.format(person.getBirthday()));

        } else {
            // Person is null, remove all the text.
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            streetLabel.setText("");
            postalCodeLabel.setText("");
            cityLabel.setText("");
            birthdayLabel.setText("");
        }
    }

    @FXML
    private void handleDeletePerson() {
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        Person selectedPerson = personTable.getSelectionModel().getSelectedItem();

        if (selectedIndex >= 0) {
            try {
                modeloAgenda.eliminarPersona(selectedPerson.getCodigo());
            } catch (ExcepcionPerson e) {
                throw new RuntimeException(e);
            }
            personTable.getItems().remove(selectedIndex);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Seleccionado");
            alert.setHeaderText("No hay persona seleccionada");
            alert.setContentText("Porfavor selecciona una persona en la tabla");
            alert.showAndWait();
        }
    }


    @FXML
    private void handleNewPerson() {
        Person tempPerson = new Person();
        boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
        try {
            if (okClicked) {
            if (modeloAgenda.setPersonas() != null){
                modeloAgenda.insertarPersona(tempPerson);
                tempPerson.setCodigo(modeloAgenda.obtenerId());

                    if (mainApp.getPersonData().size()<50){
                        mainApp.getPersonData().add(tempPerson);

                    }else {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("AGENDA LLENA");
                        alert.setHeaderText("No se ha podido insertar un nuevo contacto");
                        alert.setContentText("Has llegado al límite de contactos");
                        alert.showAndWait();
                    }
                }
            }
        } catch (ExcepcionPerson e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setHeaderText("No se ha podido insertar un nuevo contacto");
            alert.setContentText("Por favor, inicie el servidor con la base de datos para realizar la inserción");
            alert.showAndWait();        }

    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected person.
     */

    @FXML
    private void handleEditPerson() {
        Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);

            try {
                modeloAgenda.editarPersona(selectedPerson);
            } catch (ExcepcionPerson e) {
                throw new RuntimeException(e);
            }
            if (okClicked) {
                showPersonDetails(selectedPerson);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No seleccionado");
            alert.setHeaderText("No hay persona seleccionada");
            alert.setContentText("Porfavor selecciona una persona en la tabla");
            alert.showAndWait();
        }
    }
    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        personTable.setItems(mainApp.getPersonData());
    }
}