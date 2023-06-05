package application;

import javafx.beans.property.SimpleStringProperty;

public class Prenotazione {

    private SimpleStringProperty codice;
    private SimpleStringProperty nomeCliente;
    private SimpleStringProperty cognomeCliente;
    private SimpleStringProperty email;
    private SimpleStringProperty password;
    private SimpleStringProperty cellulare;

    private SimpleStringProperty seriale;

    private SimpleStringProperty modello;

    private SimpleStringProperty tipo;

    private SimpleStringProperty costo;

    public Prenotazione(String cod, String nomeC, String cognomeC, String em, String pass, String cell, String ser, String mod, String tipoRip, String cost) {
        codice = new SimpleStringProperty(cod);
        nomeCliente = new SimpleStringProperty(nomeC);
        cognomeCliente = new SimpleStringProperty(cognomeC);
        email = new SimpleStringProperty(em);
        password = new SimpleStringProperty(pass);
        cellulare = new SimpleStringProperty(cell);
        seriale = new SimpleStringProperty(ser);
        modello = new SimpleStringProperty(mod);
        tipo = new SimpleStringProperty(tipoRip);
        costo = new SimpleStringProperty(cost);
    }


    public String getCodice() {
        return codice.get();
    }
    public void setCodice(String cod) { codice.set(cod); }

    //utente
    public String getNome() {
        return nomeCliente.get();
    }
    public void setNome(String nomeC) {
        nomeCliente.set(nomeC);
    }

    public String getCognome() {
        return cognomeCliente.get();
    }
    public void setCognome(String cognomeC) {cognomeCliente.set(cognomeC);}

    public String getEmail() {
        return email.get();
    }
    public void setEmail(String em) {
        email.set(em);
    }

    public String getPassword() {
        return password.get();
    }
    public void setPassword(String pass){
        password.set(pass);
    }

    public String getCellulare() {return cellulare.get();}
    public void setCellulare(String cell) {
        cellulare.set(cell);
    }

    //smartphone
    public String getSeriale() {
        return seriale.get();
    }
    public void setSeriale(String ser) {
        seriale.set(ser);
    }


    public String getModello() {
        return modello.get();
    }
    public void setModello(String mod) {
        modello.set(mod);
    }

    //riparazione
    public String getTipoRiparazione() {
        return tipo.get();
    }
    public void setTipoRiparazione(String tipoRip) {
        tipo.set(tipoRip);
    }

    public String getCosto() {
        return costo.get();
    }
    public void setCosto(String cost) {
        costo.set(cost);
    }

}