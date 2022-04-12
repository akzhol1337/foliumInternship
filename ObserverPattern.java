import java.util.ArrayList;
import java.util.List;

interface Observer {
    public void handleEvent(List<String> vacancies);
}

interface Observed {
    public void addObserver(Observer observer);
    
    public void removeObserver(Observer observer);

    public void notifyObservers();
}

class Subscriber implements Observer {
    String name;
    Subscriber(String name) {
        this.name = name;
    }

    public void handleEvent(List<String> vacancies) {
        System.out.println("#" + name + " UPD : " + vacancies); 
    }
}

class CareersSite implements Observed {
    List<String> vacancies = new ArrayList<>();

    List<Observer> subscribers = new ArrayList<>();

    public void addVacancy(String vacancy) {
        vacancies.add(vacancy);
        notifyObservers();
    }

    public void removeVacancy(String vacancy) {
        vacancies.remove(vacancy);
        notifyObservers();
    }

    public void addObserver(Observer observer) {
        subscribers.add(observer);
    }

    public void removeObserver(Observer observer) {
        subscribers.remove(observer);
        
    }

    public void notifyObservers() {
        for(Observer observer : subscribers) {
            observer.handleEvent(vacancies);
        }
    }
}

class ObserverPattern {
    public static void main(String[] args) {
        CareersSite carrersSite = new CareersSite();

        Observer subscriberOne = new Subscriber("Talgat");
        Observer subsriberTwo = new Subscriber("Sanjik");

        carrersSite.addObserver(subscriberOne);
        carrersSite.addObserver(subsriberTwo);
        
        carrersSite.addVacancy("Java/Kotlin developer");


        carrersSite.addVacancy("Python developer");

    }
}