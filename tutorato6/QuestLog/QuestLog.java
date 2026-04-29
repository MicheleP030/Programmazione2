package QuestLog;

import QuestLog.Eccezioni.AlreadyDone;
import QuestLog.Eccezioni.LevelToLow;
import QuestLog.Eccezioni.NotYetUnlocked;
import QuestLog.Eccezioni.QuestE;
import QuestLog.Quests.*;

public class QuestLog {
    Luogo velen = new Luogo("Velen");
    Luogo novigard = new Luogo("Novigard");
    Quest quest [] = new Quest[10];
    public QuestLog(){
        MainQuest p = new MainQuest("Pyres of Novigard",5,null,novigard);
        quest[1] = p;
        quest[0] = new MainQuest("The NilGaardian",3,p,velen);
        quest[2] = new Secondary("a favor for a friend",6,30,"Bloody baron");
        quest[3] = new Secondary("the last wish",2,10,"Keira metz");
        String l [] = {"drowned","froglet"};
        quest[4] = new Contract("Swamp Thing",12,40,l);
        quest[5] = new TreasureHunt("coast of wrecks",4,50,l,novigard);
        Dlc t = new Dlc("Capture the castle",9,10,velen,null,p);
        quest[6] = new Dlc("Envoys",8,20,velen,t,p);
    }

    public void printQuests(){
        for (int i = 0; i < 6; i++) {
            System.out.println(quest[i].toString());
        }
    }

    public void doQuest(int i,Gerardo g) throws QuestE {
        if(quest[i].completata)
            throw new AlreadyDone("gia fatta");
        if(quest[i].livelloMinimo > g.livello)
            throw new LevelToLow("livello troppo basso");
        if(!quest[i].controlla_condizioni_extra())
            throw new NotYetUnlocked("non sbloccata");

        quest[i].completeQuest(g);
    }
}
