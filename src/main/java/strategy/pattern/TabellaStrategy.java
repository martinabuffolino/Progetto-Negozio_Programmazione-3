package strategy.pattern;

import javafx.collections.ObservableList;

/*
 * Interfaccia che rappresenta la "TabellaStrategy" del Pattern Strategy
 * @param <E> prende come parametro Prenotazioni
 */

public interface TabellaStrategy<E> {

    public ObservableList<E> crea();
}
