package QuestLog.Eccezioni;

public class NotYetUnlocked extends RuntimeException {
    public NotYetUnlocked(String message) {
        super(message);
    }
}
