package SoloVentilatori;

import SoloVentilatori.Alimentazioni.AlimentazioneMeccanica;
import SoloVentilatori.Alimentazioni.AlimentazionePresa;
import SoloVentilatori.Alimentazioni.AlimentazioniBatteria;
import SoloVentilatori.Ventilatori.VentilatorePiantana;
import SoloVentilatori.Ventilatori.Ventilatori;

import java.util.Scanner;

public class Main {
    //sarebbe stato meglio dividere la parte di logica di iscrizione dalla parte di print della situazione tramite altre due classi
    public static void main(){
        Ventilatori Ventilatori[] = new Ventilatori[5];
        Ventilatori[0] = new VentilatorePiantana(60,"ARIETE",new AlimentazioniBatteria());
        Ventilatori[1] = new VentilatorePiantana(60,"BOSCH",new AlimentazionePresa());
        Ventilatori[2] = new VentilatorePiantana(30,"BOSCH",new AlimentazioneMeccanica());
        Ventilatori[3] = new VentilatorePiantana(36,"BOSCH",new AlimentazioniBatteria());
        Ventilatori[4] = new VentilatorePiantana(24,"PARKSIDE",new AlimentazionePresa());
        Utente u = new Utente();
        Scanner sc = new Scanner(System.in);
        int i = 0;
        while(u.balancio > 0){
            System.out.println("vuoi iscriverti ad un altro abbonamento (0-1-2-3-4) o vuoi pagare la rata mensile (invio)");
            System.out.println("current balancio: "+u.balancio);
            int input = sc.nextInt();
            //posso prendere l'invio facendo nextLine e il trim, poi se è un numero lo casto tramite Integer altrimenti è vuoto e calcolo il mese
            if(input == -1){
                pagaMese(u);
            }else if(input >= 0 && input <= 4){
                u.v[input] = Ventilatori[input];
            }
        }

        System.out.println("finito i dollars");
    }
    public static boolean pagaMese(Utente u){
        boolean flag = true;
        for (int i = 0; i < 5 && flag; i++) {
            System.out.println("provo a pagare " +i);
            if(u.v[i] != null){
                System.out.println("ce qualcosa da pagare");
                u.balancio -= u.v[i].getCosto();
                if(u.balancio < 0) {
                    System.out.println("mancato pagamento di "+ u.v[i].toString());
                    flag = false;
                }
            }
        }
        return flag;
    }
}
