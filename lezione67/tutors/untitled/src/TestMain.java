public class TestMain {
    public static void main(){
        Spada spadaG = new Spada(50);
        Spada spadaC = spadaG;
        spadaC.durabilita = 100;
        System.out.println("Spadac: "+spadaC.durabilita + " Spadag: "+spadaG.durabilita);

        Combattente combats[] = new Combattente[3];
        for (int i = 0; i < 2; i++){
            combats[i] = new Combattente((i+1)*10,"cac"+i);
        }
        combats[2] = new Cavaliere(30,"marcos venezioal",1);

        for (int i = 0; i < 3; i++){
            combats[i].subisciDanno(15);
        }
        for (int i = 0; i < 3; i++){
            System.out.println(combats[i].salute);
        }

        Item items[] = new Item[3];
        items[0] = new Item("cacca");
        items[1] = new Arma("cacca di glg",10);
        items[2] = new Pozione("piscia di glg",2);

        for (int i = 0; i < 3; i++) {
            items[i].usa();
        }
        items[2].usa();
        items[2].usa();
    }
}
