package QuestLog.Quests;

import QuestLog.Gerardo;

public abstract class Quest {
    String nome;
    int livelloMinimo;
    int ricompensa;
    boolean completata;

    public Quest(String nome, int livelloMinimo, int ricompensa, boolean completata) {
        this.nome = nome;
        this.livelloMinimo = livelloMinimo;
        this.ricompensa = ricompensa;
        this.completata = false;
    }

    @Override
    public String toString() {
        return nome+", Livello minimo: "+livelloMinimo+" Ricompensa: "+ricompensa+" Completata: "+completata;
    }

    public abstract boolean controlla_condizioni_extra();

    public void completeQuest(Gerardo g){
        g.livello++;
        g.soldi += ricompensa;
    }
}
