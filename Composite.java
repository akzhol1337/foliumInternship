import java.util.ArrayList;
import java.util.List;

interface Entity {
    public void showEntityDetails();
}

class GPU implements Entity {
    private String name;
    private double balance;

    GPU(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void showEntityDetails() {
        System.out.println(name + ": " + balance);
    }
}

class CPU implements Entity {
    private String name;
    private double balance;

    CPU(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void showEntityDetails() {
        System.out.println(name + ": " + balance);
    }
}

class Monitor implements Entity {
    private String name;
    private double balance;

    Monitor(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void showEntityDetails() {
        System.out.println(name + ": " + balance);
    }
}

class Keyboard implements Entity {
    private String name;
    private double balance;

    Keyboard(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void showEntityDetails() {
        System.out.println(name + ": " + balance);
    }
}

class Mouse implements Entity {
    private String name;
    private double balance;

    Mouse(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void showEntityDetails() {
        System.out.println(name + ": " + balance);
    }
}

class SystemUnit implements Entity {
    private List<Entity> entities = new ArrayList<>();

    public void showEntityDetails() {
        for(Entity entity : entities) {
            entity.showEntityDetails();
        }
    }
    
    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }
}

class PC implements Entity {
    private List<Entity> entities = new ArrayList<>();

    public void showEntityDetails() {
        for(Entity entity : entities) {
            entity.showEntityDetails();
        }
    }
    
    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }
}

class Composite {
    public static void main(String[] args) {
        Entity CPU = new CPU("Intel", 130000);
        Entity GPU = new GPU("Nvidia", 200000);

        Entity monitor = new Monitor("Benq", 250000);
        Entity keyboard = new Keyboard("HyperX", 50000);
        Entity mouse = new Mouse("zowie", 60000);

        SystemUnit systemUnit = new SystemUnit();
        systemUnit.addEntity(CPU);
        systemUnit.addEntity(GPU);

        PC pc = new PC();
        pc.addEntity(monitor);
        pc.addEntity(keyboard);
        pc.addEntity(mouse);
        pc.addEntity(systemUnit);

        pc.showEntityDetails();

    }
}