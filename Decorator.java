interface Developer {
    void executeJob();
}

class DeveloperDecorator implements Developer {
    Developer developer;

    DeveloperDecorator(Developer developer) {
        this.developer = developer;
    }

    public void executeJob() {
        developer.executeJob();
    }
}

class JuniorDeveloper implements Developer {
    public void executeJob() {
        System.out.println("Write code...");
    }
}

class SeniorDeveloper extends DeveloperDecorator {
    SeniorDeveloper(Developer developer){
        super(developer);
    }

    public void executeJob() {
        developer.executeJob();
        System.out.println("code review... ");
    }
}

class TeamLead extends DeveloperDecorator {
    TeamLead(Developer developer) {
        super(developer);
    }

    public void executeJob() {
        developer.executeJob();
        System.out.println("Send report... ");
    }
}


class Decorator {
    public static void main(String[] args) {
        Developer developer = new TeamLead(new SeniorDeveloper(new JuniorDeveloper()));
        developer.executeJob();
    }
}