package singleton.pattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SingletonConnection
{
    /**
     Unica istanza della classe
     */
    private static SingletonConnection instance = null;
    public static Connection con= null;

    /**
     Costruttore Privato
     */
    private SingletonConnection() {}

    /**
     Connette la classe al Database
     @return connessione al database
     */
    private Connection connessione ( )
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/negozio","root","ciao");
            System.out.println("Connessione al database riuscita ");
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return con;
    }

    /**
     Metodo statico, accessibile globalmente
     @return l'unica istanza della classe
     */
    public static SingletonConnection getInstance ()
    {
        if(instance==null)
        {
            instance = new SingletonConnection();
            instance.con = instance.connessione();
        }
        return instance;
    }

}