package com.example.negozio;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import factory.pattern.Factory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class pagamentoOverviewController implements Initializable {

    Factory metodoScelto;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML // fx:id="radioPayPal"
    private RadioButton radioPayPal;

    @FXML // fx:id="radioCarta"
    private RadioButton radioCarta;

    @FXML // fx:id="backButton"
    private Button backButton;

    @FXML // fx:id="avantiButton"
    private Button avantiButton;

    private ToggleGroup rbGroup = new ToggleGroup();

    @FXML
    Parent root;

    private double importoDaPagare;
    private String codRicevutaDaPagare;


    @Override
    public void initialize(URL location,ResourceBundle resources)
    {    }

    public void initPagamento(double prezzo, String codRicevuta){
        importoDaPagare = prezzo;
        codRicevutaDaPagare = codRicevuta;
        radioPayPal.setToggleGroup(rbGroup);
        radioCarta.setToggleGroup(rbGroup);
    }

    @FXML
    public void handleTipoPagamento() {

        if(radioPayPal.isSelected()){
            avantiButton.setDisable(false);
        }
        if(radioCarta.isSelected()){
            avantiButton.setDisable(false);
        }

    }

    // Gestione backButton per tornare indietro
    @FXML
    public void handleBackButton(ActionEvent event)  throws Exception {

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("controlloStatoRiparazione.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();

    }

    // Gestione metodo paga in base alla scelta del cliente
    @FXML
    public void handlePaga(ActionEvent event) {

        if(radioPayPal.isSelected()){

            try {
                Parent tableViewParent = FXMLLoader.load(getClass().getResource("pagaPayPal.fxml"));
                Scene tableViewScene = new Scene(tableViewParent);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(tableViewScene);
                window.setResizable(false);
                window.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(radioCarta.isSelected()){

            try {
                Parent tableViewParent = FXMLLoader.load(getClass().getResource("pagaCarta.fxml"));
                Scene tableViewScene = new Scene(tableViewParent);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(tableViewScene);
                window.setResizable(false);
                window.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
