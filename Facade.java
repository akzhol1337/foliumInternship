import java.util.List;

class Developer {
    private boolean vacation;

    Developer(boolean vacation) {
        this.vacation = vacation;
    }

    public boolean isVacation() {
        return vacation;
    }

    public void setVacation(boolean vacation) {
        this.vacation = vacation;
    }

    public void work() {
        System.out.println("Writing code...");
    }   
}

class Task {
    private boolean started;

    Task(boolean started) {
        this.started = started;
    }

    public boolean isStarted() {
        return started;
    }
    
    public void setStarted(boolean started) {
        this.started = started;
    }
}

class ProjectFacade {
    List<Developer> developers;
    Task task;

    ProjectFacade(List<Developer> developers, Task task) {
        this.developers = developers;
        this.task = task;
    }
    
    public boolean startProject() {
        if(task.isStarted()) {
            return false;
        }
        for(Developer developer : developers) {
            if(developer.isVacation()) {
                return false;
            }
        }
        return true;
    }
}


public class Facade {
    public static void main(String[] args) {
        ProjectFacade searchEngineFacade = new ProjectFacade(List.of(new Developer(false), new Developer(false), new Developer(true)), new Task(false));
        System.out.println(searchEngineFacade.startProject());

        ProjectFacade serverOptimizationFacade = new ProjectFacade(List.of(new Developer(false),new Developer(false), new Developer(false), new Developer(false)), new Task(false));
        System.out.println(serverOptimizationFacade.startProject());
        
    }
}