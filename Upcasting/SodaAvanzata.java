package Upcasting;

public class SodaAvanzata extends Soda{
    @Override
    public void scattaFoto() {
        System.out.println("scatto foto avanzata, metodo normale");
    }

    //public static void calcolaTraiettoria(){}

    public static void inviaPing(){
        System.out.println("invio ping alla sonda avanzata, hiding metodo base");
    }
}
