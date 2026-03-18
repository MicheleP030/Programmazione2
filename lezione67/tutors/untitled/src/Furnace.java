public class Furnace {
    private int carbone, temperatura;

    int getCarbone(){
        return carbone;
    }
    int getTemperatura(){
        return carbone;
    }

    void setCarbone(int carbone){
        if(carbone < 0){
            System.out.println("non puoi mettere carbone negativo");
        }
        else {
            this.carbone = carbone;
        }
    }

    void setTemperatura(int temperatura){
        if(temperatura < 0 || temperatura > 100){
            System.out.println("non puoi mettere questa temperatura");
        }
        else {
            this.temperatura = temperatura;
        }
    }

    void aggiungiCarbone(int carbone){
        if(carbone< 0 ){
            System.out.println("non puoi togliere carbone con la funzione aggiungi carbone");
        }
        else {
            this.carbone += carbone;
        }
    }

    void accendi(){
        if(carbone >0){
            carbone--;
            temperatura = 100;
        }
        else {
            System.out.println("non c'è abbastanza carbone");
        }
    }

    void tick(){
        if(temperatura >= 10){
            temperatura -= 10;
            System.out.println("la temperatura è: " + temperatura);
        }
        else {
            System.out.println("fornace spenta");
        }
    }
}
