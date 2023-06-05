package com.example.negozio;

import application.Prenotazione;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import strategy.pattern.Tabella_Prenotazioni;
import strategy.pattern.TipoTabella;

import java.net.URL;
import java.util.ResourceBundle;

public class infoRicevutaController implements Initializable {

    @FXML
    private TableView<Prenotazione> tableView;

    @FXML
    private TableColumn<Prenotazione, String> nome;

    @FXML
    private TableColumn<Prenotazione, String> cognome;
    @FXML
    private TableColumn<Prenotazione, String> modelloSmartphone;

    @FXML
    private TableColumn<Prenotazione, String> serialeSmartphone;

    @FXML
    private Button backButton;

    @FXML
    private Button avantiButton;

    @FXML
    private TableColumn<Prenotazione, String> costoRip;

    ObservableList<Prenotazione> tab = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nome.setCellValueFactory(new PropertyValueFactory<Prenotazione,String>("nome"));
        cognome.setCellValueFactory(new PropertyValueFactory<Prenotazione,String>("cognome"));
        serialeSmartphone.setCellValueFactory(new PropertyValueFactory<Prenotazione,String>("seriale"));
        modelloSmartphone.setCellValueFactory(new PropertyValueFactory<Prenotazione,String>("modello"));
        costoRip.setCellValueFactory(new PropertyValueFactory<Prenotazione,String>("costo"));

        TipoTabella<Prenotazione> tab = new TipoTabella<Prenotazione>(new Tabella_Prenotazioni());
        tableView.setItems(tab.getElements());
    }

    @FXML
    void handleBackButton(ActionEvent event) throws Exception
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("homeOverview.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();
    }

    @FXML
    void handleAvanti(ActionEvent event) throws Exception {

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("pagamentoOverview.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();

    }
}
