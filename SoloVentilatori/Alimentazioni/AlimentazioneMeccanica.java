package SoloVentilatori.Alimentazioni;

import SoloVentilatori.TipoAlimentazione;

public class AlimentazioneMeccanica extends Alimentazione {
    public AlimentazioneMeccanica(){
        super.moltiplicatore = 1;
        super.al = TipoAlimentazione.MECCANICA;
    }
}
