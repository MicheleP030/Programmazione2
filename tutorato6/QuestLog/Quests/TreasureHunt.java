package QuestLog.Quests;

import QuestLog.Luogo;

public class TreasureHunt extends Contract{
    protected Luogo luogoLoot;

    public TreasureHunt(String nome, int livelloMinimo, int ricompensa, String mostri[], Luogo luogoLoot) {
        super(nome, livelloMinimo, ricompensa, mostri);
        this.luogoLoot = luogoLoot;
    }
}
