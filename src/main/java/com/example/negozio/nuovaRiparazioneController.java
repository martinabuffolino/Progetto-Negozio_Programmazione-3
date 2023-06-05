package com.example.negozio;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
//import application.Prenotazione;
//import database.PrenotazioneDB;
import com.sun.javafx.charts.Legend;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;
import singleton.pattern.Database;

import javax.swing.*;

public class nuovaRiparazioneController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    private TextField codice;

    @FXML
    private TextField emailCliente;

    @FXML
    private TextField cellCliente;

    @FXML
    private PasswordField passwordCliente;

    @FXML
    private TextField nomeCliente;

    @FXML
    private TextField seriale;

    @FXML
    private TextField modello;

    @FXML
    private TextField cognomeCliente;


    @FXML
    private RadioButton tipoRip1;

    @FXML
    private RadioButton tipoRip2;

    @FXML
    private Button backButton;

    @FXML
    private Button avantiButton;

    private Database db;
    private String tipo;
    private String costo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try
        {
            db = new Database();
        }
        catch(Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    @FXML
    void getTipo1(ActionEvent event) {
        tipo="Sostituzione Display";
        costo="100";
    }

    @FXML
    void getTipo2(ActionEvent event) {
        tipo="Sostituzione Batteria";
        costo="80";
    }

    @FXML
    void handleNuovaRiparazione(ActionEvent event) throws Exception, Custom_Exception {
        String cod,nom,cogn,em,pass,cell,serial,mod;

        cod=codice.getText();
        nom=nomeCliente.getText();
        cogn=cognomeCliente.getText();
        em=emailCliente.getText();
        pass=passwordCliente.getText();
        cell=cellCliente.getText();
        serial=seriale.getText();
        mod=modello.getText();

        //Controllo valori
        if( cod.isEmpty() || nom.isEmpty() || cogn.isEmpty() || em.isEmpty() || pass.isEmpty() || cell.isEmpty() || serial.isEmpty() || mod.isEmpty()) {
            throw new Custom_Exception("ERRORE DURANTE L'INSERIMENTO\nCompilare tutti i campi.");
        }

        // al posto dei valori metto ?
        // anche se il valore contiene caratteri speciali non ho problemi
        String sql="INSERT INTO negozio.prenotazione (codice,nomecliente,cognomecliente,email,password,cellulare,seriale,modello,tipo,costo)"+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
        //PreparedStatement--> prepariamo lo statement
        PreparedStatement preparedStmt = db.insert(sql);
        //ad ogni ? assegniamo una stringa
        preparedStmt.setString (1, cod);
        preparedStmt.setString (2, nom);
        preparedStmt.setString (3, cogn);
        preparedStmt.setString (4, em);
        preparedStmt.setString (5, pass);
        preparedStmt.setString (6, cell);
        preparedStmt.setString (7, serial);
        preparedStmt.setString (8, mod);
        preparedStmt.setString (9, tipo);
        preparedStmt.setString (10, costo);
        preparedStmt.execute(); //eseguo lo statement

        JOptionPane.showMessageDialog(null,"Registrazione andata a buon fine");
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
}