package pages;

public class ShadyMeadows {

    private static ShadyMeadows instance;
    private static HomePage homePage;
    private static LoginPage loginPage;
    private static AdminDashboardPage adminDashboardPage;

    public static ShadyMeadows getInstance() {
        if (instance == null) instance = new ShadyMeadows();
        return instance;
    }

    public static HomePage welcomePage() {
        if (homePage == null) homePage = new HomePage();
        return homePage;
    }

    public static LoginPage loginPage() {
        if (loginPage == null) loginPage = new LoginPage();
        return loginPage;
    }

    public static AdminDashboardPage adminDashboardPage() {
        if (adminDashboardPage == null) adminDashboardPage = new AdminDashboardPage();
        return adminDashboardPage;
    }

    public static void reset() {
        homePage = null;
        loginPage = null;
        adminDashboardPage = null;
    }

}
