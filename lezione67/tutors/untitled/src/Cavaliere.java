public class Cavaliere extends Combattente{
    private int armatura;
    public Cavaliere(int salute, String nome,int armatura) {
        super(salute, nome);
        this.armatura = armatura;
    }

    @Override
    public void subisciDanno(int danno) {
        danno -= armatura;
        if(danno < 0){
            danno = 0;
        }
        super.subisciDanno(danno);
    }
}
