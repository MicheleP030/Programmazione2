package SoloVentilatori.Alimentazioni;

import SoloVentilatori.TipoAlimentazione;

public class AlimentazioniBatteria extends AlimentazioneElettrica{
    public AlimentazioniBatteria(){
        super.moltiplicatore = 3;
        super.al = TipoAlimentazione.BATTERIA;
    }
}
