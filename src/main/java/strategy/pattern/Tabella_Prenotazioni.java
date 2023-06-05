package strategy.pattern;

import application.Prenotazione;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import singleton.pattern.Database;

import java.sql.ResultSet;

public class Tabella_Prenotazioni implements TabellaStrategy<Prenotazione>{
    @FXML
    private ObservableList<Prenotazione> data;

    public Tabella_Prenotazioni()
    {
        data = FXCollections.observableArrayList();
    }

    /**
     * Metodo che ritorna la lista di prenotazioni presenti nel database
     */
    @Override
    public ObservableList<Prenotazione> crea()
    {
        try
        {
            Database db = new Database();
            String sql="Select * from negozio.prenotazione";
            ResultSet rs=db.query(sql);
            while(rs.next())
            {
                data.add(new Prenotazione(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)));
            }
        }
        catch(Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return data;
    }
}
