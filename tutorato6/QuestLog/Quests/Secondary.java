package QuestLog.Quests;

import QuestLog.Gerardo;

public class Secondary extends Quest{
    protected String npc;

    public Secondary(String nome, int livelloMinimo, int ricompensa, String npc) {
        super(nome, livelloMinimo, ricompensa, false);
        this.npc = npc;
    }

    @Override
    public boolean controlla_condizioni_extra() {
        return true;
    }

    @Override
    public void completeQuest(Gerardo g) {
        super.completeQuest(g);
        g.livello++;
    }
}
