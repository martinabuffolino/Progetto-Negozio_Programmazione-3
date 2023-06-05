package com.example.negozio;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import factory.pattern.CreditCard;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class pagaCartaController  implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML // fx:id="fullNameLabel"
    private TextField fullNameLabel;

    @FXML // fx:id="numeroCarta"
    private TextField numeroCarta;

    @FXML // fx:id="cvvLabel"
    private TextField cvvLabel;


    @FXML // fx:id="nextButton"
    private Button nextButton;

    @FXML // fx:id="backButton"
    private Button backButton;

    private double prezzo;
    private String codiceRicevuta;

    Parent root;

    @Override
    public void initialize(URL location,ResourceBundle resources)
    {    }

    public void initCartaPaga(double costo, String codRicevuta){
        codiceRicevuta = codRicevuta;
        prezzo = costo;
        System.out.println(prezzo);

    }

    @FXML
    void handleBackButton(ActionEvent event) throws Exception {

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("homeOverview.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();
    }

    // Gestione metodo paga dove l'utente compila tutti i parametri
    @FXML
    void handlePaga(ActionEvent actionEvent) throws SQLException, ClassNotFoundException{

        if(enablePaga()) {
            String nomeCompleto = fullNameLabel.getText();
            String numCarta = (numeroCarta.getText());
            String codiceCVV = (cvvLabel.getText());
            System.out.println("Nome Completo:" + nomeCompleto);
            System.out.println("Numero Carta:" + numCarta);
            System.out.println("Numero CVV:" + codiceCVV);

            CreditCard carta = new CreditCard(nomeCompleto,numCarta, codiceCVV);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("CONFERMA PAGAMENTO");
            alert.setHeaderText(null);
            alert.setContentText("Confermi di voler procedere al pagamento?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK)
            {
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("PAGAMENTO RIUSCITO");
                alert1.setHeaderText(null);
                alert1.setContentText("Pagamento avvenuto con successo\nGrazie per averci scelto!");
                alert1.showAndWait();
            } else {
                System.out.println("Pagamento cancellato");
            }
        }
    }

    public boolean enablePaga() {

        if(fullNameLabel.getText().isEmpty() | numeroCarta.getText().isEmpty() | cvvLabel.getText().isEmpty()){
            System.out.println("Tutto Vuoto");
            //pop up campi obblicatori
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ATTENZIONE");
            alert.setHeaderText(null);
            alert.setContentText("Attenzione tutti i campi sono obbligari per il pagamento");
            alert.showAndWait();
            return false;
        }

        if (cvvLabel.getText().length() < 3 | cvvLabel.getText().length() > 3){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ATTENZIONE");
            alert.setHeaderText(null);
            alert.setContentText("Attenzione CVV errato");
            alert.showAndWait();
            return false;
        }
        return true;
    }
}