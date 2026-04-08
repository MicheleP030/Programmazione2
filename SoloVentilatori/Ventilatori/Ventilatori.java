package SoloVentilatori.Ventilatori;

import SoloVentilatori.Alimentazioni.Alimentazione;
import SoloVentilatori.TipoVentilatore;

public abstract class Ventilatori {
    String marca;
    int costo;
    Alimentazione al;
    //per poterlo poi printare devo sapere il tipo
    TipoVentilatore ve;

    public int getCosto(){
        return costo*al.getMoltiplicatore();
    }

    @Override
    public String toString() {
        return marca +" : " +costo+"$ con alimentazione "+ al.getAl();
    }
}
