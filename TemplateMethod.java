class WelcomePage extends WebsiteTemplate {
	public void showPageContent() {
		System.out.println("Welcome");
	}
}

class NewsPage extends WebsiteTemplate {
	public void showPageContent() {
		System.out.println("News");
	}
}

abstract class WebsiteTemplate {
	public void showPage() {
		System.out.println("Header");
		showPageContent();
		System.out.println("Footer");
	}

	public abstract void showPageContent();
}

public class TemplateMethod {
	public static void main(String[] args) {
		WebsiteTemplate welcomePage = new WelcomePage();
		WebsiteTemplate newsPage = new NewsPage();

		welcomePage.showPage();

		System.out.println();

		newsPage.showPage();
	}
}