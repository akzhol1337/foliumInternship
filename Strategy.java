interface Activity {
    void doJob();
}

class Person {
    Activity activity;
    
    void setActivity(Activity activity) {
        this.activity = activity;
    }

    void executeJob(){
        activity.doJob();
    }
}

class Eat implements Activity {
    public void doJob() {
        System.out.println("Eat...");
    }
}

class Sleep implements Activity {
    public void doJob() {
        System.out.println("Sleep...");
    }
}

class Code implements Activity {
    public void doJob() {
        System.out.println("Code...");
    }
}

class Repeat implements Activity {
    public void doJob() {
        System.out.println("Repeat...");
    }
}

class Strategy {
    public static void main(String[] args) {
        Person akzhol = new Person();
        
        akzhol.setActivity(new Eat());
        akzhol.executeJob();

        akzhol.setActivity(new Sleep());
        akzhol.executeJob();
        
        akzhol.setActivity(new Code());
        akzhol.executeJob();

        akzhol.setActivity(new Repeat());
        akzhol.executeJob();
    }
}