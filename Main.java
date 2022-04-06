import java.util.ArrayList;

class Address {}

class Citizen {}

class Building {
    Address address;
    ArrayList<Citizen> citizens;

    Building(ArrayList<Citizen> citizens){
        this.citizens = citizens;
        address = new Address();
    }
}

public class Main {
    public static void main(String args[]){
        Citizen akzhol = new Citizen();
        Citizen take = new Citizen();
        Citizen sanjik = new Citizen();

        ArrayList<Citizen> citizens = new ArrayList<>();
        citizens.add(akzhol);
        citizens.add(take);
        citizens.add(sanjik);

        Building building = new Building(citizens);
    }
}