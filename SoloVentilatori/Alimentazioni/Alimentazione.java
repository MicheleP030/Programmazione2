package SoloVentilatori.Alimentazioni;

import SoloVentilatori.TipoAlimentazione;

public abstract class Alimentazione {
    int moltiplicatore;
    TipoAlimentazione al;

    public int getMoltiplicatore() {
        return moltiplicatore;
    }

    public TipoAlimentazione getAl() {
        return al;
    }
}
