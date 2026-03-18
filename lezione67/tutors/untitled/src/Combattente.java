public class Combattente {
    protected int salute;
    protected String nome;

    public Combattente(int salute,String nome){
        this.salute = salute;
        this.nome = nome;
    }

    public void subisciDanno(int danno){
        salute -= danno;
        if(salute < 0){
            salute = 0;
        }
    }
}
