package SoloVentilatori.Alimentazioni;

import SoloVentilatori.TipoAlimentazione;

public class AlimentazionePresa extends AlimentazioneElettrica{
    public AlimentazionePresa(){
        super.moltiplicatore = 2;
        super.al = TipoAlimentazione.PRESA;
    }
}
