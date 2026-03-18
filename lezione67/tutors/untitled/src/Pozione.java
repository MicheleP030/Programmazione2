public class Pozione extends Item{
    private int dosi;

    public Pozione(String nome,int dosi){
        super(nome);
        this.dosi = dosi;
    }
    @Override
    public void usa() {
        if(dosi > 0){
            dosi--;
            System.out.println("Bevo una pots: "+ nome + "ne ho ancora: "+dosi);
        }
        else{
            System.out.println("finite pos");
        }

    }
}
