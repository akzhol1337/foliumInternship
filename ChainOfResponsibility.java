class Priority {
    public static final int LOW = 1;
    public static final int MEDIUM = 2;
    public static final int HIGH = 3;   
}

abstract class Notifier {
    private int priority;
    private Notifier nextNotifier;

    Notifier(int priority) {
        this.priority = priority;
    }

    public void setNextNotifier(Notifier nextNotifier){
        this.nextNotifier = nextNotifier;
    }

    public void notifyManager(String message, int level){
        if(level >= priority) {
            write(message);
        }
        if(nextNotifier != null){
            nextNotifier.notifyManager(message, level);
        }
    }
    
    public abstract void write(String message);
}

class WarningNotifier extends Notifier {

    WarningNotifier(int priority) {
        super(priority);
    }

    public void write(String message) {
        System.out.println("Warning: " + message);
    }
}

class KickNotifier extends Notifier {
    public KickNotifier(int priority) {
        super(priority);
    }

    public void write(String message) {
        System.out.println("Kick: " + message);
    }
}

class BanNotifier extends Notifier {
    public BanNotifier(int priority) {
        super(priority);
    }

    public void write(String message) {
        System.out.println("Ban: " + message);   
    }
}

class ChainOfResponsibility {
    public static void main(String[] args) {
        Notifier warningNotifier = new WarningNotifier(Priority.LOW);
        Notifier kickNotifier = new KickNotifier(Priority.MEDIUM);
        Notifier banNotifier = new BanNotifier(Priority.HIGH);

        warningNotifier.setNextNotifier(kickNotifier);

        kickNotifier.setNextNotifier(banNotifier);

        warningNotifier.notifyManager("msg1", Priority.LOW);
        warningNotifier.notifyManager("msg2", Priority.MEDIUM);
        warningNotifier.notifyManager("msg3", Priority.HIGH);
    }
}