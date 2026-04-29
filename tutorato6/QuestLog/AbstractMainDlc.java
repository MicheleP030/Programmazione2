package QuestLog;

import QuestLog.Quests.Quest;

public abstract class AbstractMainDlc extends Quest {
    Luogo luogo;

    public AbstractMainDlc(String nome, int livelloMinimo, int ricompensa, boolean completata,Luogo luogo) {
        this.luogo = luogo;
        super(nome, livelloMinimo, ricompensa, completata);
    }

}
