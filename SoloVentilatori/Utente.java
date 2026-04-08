package SoloVentilatori;

import SoloVentilatori.Ventilatori.Ventilatori;

public class Utente {
    int balancio = 1000;
    Ventilatori v[] = new Ventilatori[5];
    public boolean pagaAbbonamento(int costo){
        balancio -= costo;
        if(balancio <= 0){
            System.out.println("SQUATTRINATOS");
            return false;
        }
        return true;
    }
}
