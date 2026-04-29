package QuestLog.Quests;

import QuestLog.AbstractMainDlc;
import QuestLog.Luogo;

public class MainQuest extends AbstractMainDlc {
    protected MainQuest nextMainQuest;

    public MainQuest(String nome,int minLivello,MainQuest nextMainQuest, Luogo luogo) {
        this.nextMainQuest = nextMainQuest;
        super(nome,minLivello,10,false,luogo);
    }

    @Override
    public boolean controlla_condizioni_extra() {
        return true;
    }
}
