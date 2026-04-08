package SoloVentilatori.Ventilatori;

import SoloVentilatori.Alimentazioni.Alimentazione;
import SoloVentilatori.TipoVentilatore;

public class VentilatorePiantana extends Ventilatori{

    public VentilatorePiantana(int costo,String marca,Alimentazione al){
        super.costo = costo;
        super.marca = marca;
        super.al = al;
        super.ve = TipoVentilatore.PIANTANA;
    }
}
