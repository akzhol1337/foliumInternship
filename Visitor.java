interface Developer {
	public void create(ProjectClass projectClass);

	public void create(Database database);

	public void create(Test test);
}

interface ProjectElement {
	public void beWritten(Developer developer);
}

class ProjectClass implements ProjectElement {
	public void beWritten(Developer developer) {
		developer.create(this);
	}
}

class Database implements ProjectElement {
	public void beWritten(Developer developer) {
		developer.create(this);
	}
}

class Test implements ProjectElement {
	public void beWritten(Developer developer) {
		developer.create(this);
	}
}

class Project implements ProjectElement {
	ProjectElement[] projectElements;
	Project() {
		this.projectElements = new ProjectElement[] {
			new ProjectClass(),
			new Database(),
			new Test()
		};
	}
	public void beWritten(Developer developer) {
		for(ProjectElement element : projectElements) {
			element.beWritten(developer);
		}
	}
}

class JuniorDeveloper implements Developer {
	public void create(ProjectClass projectClass) {
		System.out.println("Writing poor class...");
	}

	public void create(Database database) {
		System.out.println("Drop database...");
	}

	public void create(Test test) {
		System.out.println("Creating not reliable test");
	}
}

class SeniorDeveloper implements Developer {
	public void create(ProjectClass projectClass) {
		System.out.println("Rewriting class after junior...");
	}

	public void create(Database database) {
		System.out.println("Fixing database...");
	}

	public void create(Test test) {
		System.out.println("Creating reliable tests");
	}
}

public class Visitor {
	public static void main(String[] args) {
		Project project = new Project();

		Developer junior = new JuniorDeveloper();
		Developer senior = new SeniorDeveloper();

		System.out.println("junior: ");
		project.beWritten(junior);

		System.out.println("senior: ");
		project.beWritten(senior);
	}
}