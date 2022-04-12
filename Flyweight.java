import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface Developer {

}


class JavaDeveloper implements Developer {

}

class CppDeveloper implements Developer {

}

class DeveloperFactory {
    private Map<String, Developer> developers = new HashMap<>();
    
    public Developer getDeveloper(String type) {
        Developer developer = developers.get(type);

        if(developer == null) {
            if(type == "java") {
                System.out.println("Hiring java developer...");
                developer = new JavaDeveloper();
            } else if(type == "cpp") {
                System.out.println("Hiring cpp developer");
                developer = new CppDeveloper();
            }
        }
        developers.put(type, developer);
        return developer;
    }
}

class Flyweight {
    public static void main(String[] args) {
        DeveloperFactory developerFactory = new DeveloperFactory();

        List<Developer> developers = new ArrayList<>();

        developers.add(developerFactory.getDeveloper("java"));
        developers.add(developerFactory.getDeveloper("java"));
        developers.add(developerFactory.getDeveloper("java"));
        developers.add(developerFactory.getDeveloper("java"));
        developers.add(developerFactory.getDeveloper("java"));


        developers.add(developerFactory.getDeveloper("cpp"));
        developers.add(developerFactory.getDeveloper("cpp"));
        developers.add(developerFactory.getDeveloper("cpp"));
        developers.add(developerFactory.getDeveloper("cpp"));
        developers.add(developerFactory.getDeveloper("cpp"));

        
    }
}