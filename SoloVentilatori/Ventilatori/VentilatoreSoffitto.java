package SoloVentilatori.Ventilatori;

import SoloVentilatori.Alimentazioni.Alimentazione;
import SoloVentilatori.TipoAlimentazione;
import SoloVentilatori.TipoVentilatore;

public class VentilatoreSoffitto extends Ventilatori{
    public VentilatoreSoffitto(int costo, String marca, Alimentazione al) throws Exception {
        super.costo = costo;
        super.marca = marca;
        setAl(al);
        super.ve = TipoVentilatore.SOFFITTO;
    }

    void setAl(Alimentazione al) throws Exception {
        if(al.getAl() == TipoAlimentazione.MECCANICA) {
            throw new Exception("non puoi avere meccanico soffitto");
        }
        this.al = al;
    }
}
