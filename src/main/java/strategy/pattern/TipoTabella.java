package strategy.pattern;

import javafx.collections.ObservableList;

/*
 * Interfaccia che rappresenta "TipoTabella" del Pattern Strategy
 *  A seconda del tipo di "TabellaStrategy" ricevuta in input, esegue un algoritmo specifico
 * @param <E> Prenotazioni
 */

public class TipoTabella<E> {

    /**
     * Attributo che rappresenta l'interfaccia IStrategy del Pattern Strategy
     */
    private TabellaStrategy<E> tab;

    public TipoTabella(TabellaStrategy<E> x)
    {
        tab=x;
    }

    /**
     * Metodo che ritorna la lista di elementi da inserire nella tabella
     */
    public ObservableList<E> getElements()
    {
        return tab.crea();
    }

}
