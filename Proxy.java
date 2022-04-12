interface Project {
    public void run();
}

class RealProject implements Project {
    private String url;
    
    RealProject(String url) {
        this.url = url;
        load();
    }

    public void load() {
        System.out.println("Loading project...");
    }

    public void run() {
        System.out.println("Running project...");
    }
}

class ProxyProject implements Project {
    private String url;
    private RealProject realProject;

    ProxyProject(String url){
        this.url = url;
    }

    public void run() {
        if(realProject == null){
            realProject = new RealProject(url);
        }
        realProject.run(); 
    }

}

class Proxy {
    public static void main(String[] args) {
        Project project = new ProxyProject("https://www.link.com");
        //project.run();  

        Project project1 = new ProxyProject("https://www.link.com");
        project1.run();
    }
}