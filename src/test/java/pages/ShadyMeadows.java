package pages;

public class ShadyMeadows {

    private static ShadyMeadows instance;
    private static WelcomePage welcomePage;
    private static LoginPage loginPage;

    public static ShadyMeadows getInstance() {
        if (instance == null) instance = new ShadyMeadows();
        return instance;
    }

    public static WelcomePage welcomePage() {
        if (welcomePage == null) welcomePage = new WelcomePage();
        return welcomePage;
    }

    public static LoginPage loginPage() {
        if (loginPage == null) loginPage = new LoginPage();
        return loginPage;
    }

    public static void reset() {
        welcomePage = null;
        loginPage = null;
    }

}
