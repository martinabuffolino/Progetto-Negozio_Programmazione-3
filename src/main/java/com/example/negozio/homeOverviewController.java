package com.example.negozio;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class homeOverviewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML // fx:id="nuovaRiparazioneRadioButton"
    private RadioButton nuovaRiparazioneRadioButton;

    @FXML // fx:id="controlloRiparazioneRadioButton"
    private RadioButton controlloRiparazioneRadioButton;

    @FXML // fx:id="avantiButton"
    private Button avantiButton;

    @FXML
    Parent root;

    public homeOverviewController() {

    }

    @FXML
    public void handleInsert(ActionEvent event) throws IOException {

        if (nuovaRiparazioneRadioButton.isSelected()) {
            try {
                Parent tableViewParent = FXMLLoader.load(getClass().getResource("nuovaRiparazione.fxml"));
                Scene tableViewScene = new Scene(tableViewParent);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setResizable(false);
                window.setScene(tableViewScene);
                window.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(controlloRiparazioneRadioButton.isSelected()) {
            try {
                Parent tableViewParent = FXMLLoader.load(getClass().getResource("infoRicevuta.fxml"));
                Scene tableViewScene = new Scene(tableViewParent);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setResizable(false);
                window.setScene(tableViewScene);
                window.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}