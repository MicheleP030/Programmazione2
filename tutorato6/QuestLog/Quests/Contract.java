package QuestLog.Quests;

public class Contract extends Quest {
    protected String[] listaMostri;

    public Contract(String nome, int livelloMinimo, int ricompensa, String[] listaMostri) {
        super(nome, livelloMinimo, ricompensa, false);
        this.listaMostri = listaMostri;
    }

    @Override
    public boolean controlla_condizioni_extra() {
        return true;
    }
}
