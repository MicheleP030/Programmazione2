package QuestLog.Quests;

import QuestLog.AbstractMainDlc;
import QuestLog.Luogo;

public class Dlc extends AbstractMainDlc {
    protected Dlc nextDlc;
    protected MainQuest mainQuestDipendenza;

    public Dlc(String nome, int livelloMinimo, int ricompensa, Luogo luogo, Dlc nextDlc, MainQuest mainQuestDipendenza) {
        super(nome, livelloMinimo, ricompensa, false, luogo);
        this.nextDlc = nextDlc;
        this.mainQuestDipendenza = mainQuestDipendenza;
    }

    @Override
    public boolean controlla_condizioni_extra() {
        return mainQuestDipendenza.completata;
    }
}
