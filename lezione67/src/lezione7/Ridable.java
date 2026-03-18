package lezione7;

public interface Ridable {
    //per raggruppare funzionalità
    //può avere solo metodi abstract
    //non possono essere istanziate(solo come classe anonima)
    //la relazione is-a tra gerarchie diverse c'è anche per le interfacce
    //possono estendere altre interfacce

    //anche con queste agevolazioni le interfacce hanno limiti:
    //1.nessuno stato (variabili di istanza)
    //2.nessun costruttore
    //3.api fragile(se 50 classi implementano questa, se la cambio devo cambiarle tutte, per questo esiste default)
    int x, y;
    //permette di dare implementazione di default
    //non ci si può accedere tramite super, se riscrivo l'implementazione allora perdo questa
    default void xy(){

    }
    //si possono implementare metodi void, in caso voglio aiutarmi con il default
    private void sound(){

    }
}