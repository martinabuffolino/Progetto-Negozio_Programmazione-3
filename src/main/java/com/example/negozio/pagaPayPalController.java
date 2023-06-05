package com.example.negozio;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import factory.pattern.PayPal;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class pagaPayPalController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML // fx:id="nome"
    private TextField nome;

    @FXML // fx:id="cognome"
    private TextField cognome;

    @FXML // fx:id="passwordPayPal"
    private PasswordField passwordPayPal;

    @FXML // fx:id="emailPayPal"
    private TextField emailPayPal;

    @FXML // fx:id="backButton"
    private Button backButton;

    @FXML // fx:id="confermaButton"
    private Button confermaButton;

    @FXML
    Parent root;

    private double prezzo;
    private String ricevuta;

    @Override
    public void initialize(URL location,ResourceBundle resources)
    {    }

    public void initPayPal(double importoDaPagare, String codRicevutaDaPagare) {
        ricevuta = codRicevutaDaPagare;
        prezzo = importoDaPagare;
        System.out.println(prezzo);
    }

    // Gestione backButton per tornare indietro
    @FXML
    void handleBackButton(ActionEvent event) throws Exception {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("homeOverview.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();
    }

    // Gestione controllo paramenti pagamento
    public boolean enablePayment(){
        System.out.println("Pagamento abilitato");
        if (nome.getText().isEmpty() | cognome.getText().isEmpty() | passwordPayPal.getText().isEmpty() | emailPayPal.getText().isEmpty()){

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Attenzione tutti i campi sono obbligatori");
            alert.showAndWait();
            return false;
        }

        if (!emailPayPal.getText().contains("@")){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Attenzione campo email non compilato correttamente");
            alert.showAndWait();
            return false;
        }

        return true;
    }

    // Gestione metodo paga
    @FXML
    void handlePaga(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        if (enablePayment()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("CONFERMA PAGAMENTO");
            alert.setHeaderText(null);
            alert.setContentText("Confermi di voler procedere al pagamento?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {

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
}