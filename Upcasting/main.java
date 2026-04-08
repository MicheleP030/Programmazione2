package Upcasting;//vuol dire usare classe figlio dentro dichiarazione padre

public class main {
    public static void main(){
        Soda s = new SodaAvanzata();
        SodaAvanzata sa = new SodaAvanzata();

        s.scattaFoto();
        s.calcolaTraiettoria();
        //Controlla il tipo statico e chiama il metodo statico su quel tipo
        s.inviaPing(); //Soda.inviaPing();
        sa.inviaPing(); //SodaAvanzata.inviaPing();
    }
}
