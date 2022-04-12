interface Developer {
    void writeCode();
}

interface Tester {
    void testCode();
}

interface ProjectManager {
    void manageProject();
}

interface ProjectTeamFactory {
    Developer getDeveloper();
    Tester getTester();
    ProjectManager getProjectManager();
}

class JavaDeveloper implements Developer {
    public void writeCode() {
        System.out.println("Writing code...");
    }
}

class QATester implements Tester {
    public void testCode() {
        System.out.println("Testing code...");
    }
}

class PM implements ProjectManager {
    public void manageProject() {
        System.out.println("Managing project...");
    }
}

class WebsiteFactory implements ProjectTeamFactory{
    public Developer getDeveloper() {
        return new JavaDeveloper();
    }

    public Tester getTester() {
        return new QATester();
    }

    public ProjectManager getProjectManager() {
        return new PM();
    }    
}

class AbstractFactory {
    public static void main(String[] args) {
        ProjectTeamFactory projectTeamFactory = new WebsiteFactory();
        Developer developer = projectTeamFactory.getDeveloper();
        Tester tester = projectTeamFactory.getTester();
        ProjectManager PM = projectTeamFactory.getProjectManager();

        developer.writeCode();
        tester.testCode();
        PM.manageProject();
        
    }
}