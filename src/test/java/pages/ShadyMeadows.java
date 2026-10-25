package pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShadyMeadows {

    @Autowired
    private ShadyMeadows instance;

    @Autowired
    private HomePage homePage;

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private AdminDashboardPage adminDashboardPage;

    @Autowired
    private RoomPage roomPage;

    public HomePage welcomePage() {
        return homePage;
    }

    public LoginPage loginPage() {
        return loginPage;
    }

    public AdminDashboardPage adminDashboardPage() {
        return adminDashboardPage;
    }

    public RoomPage roomPage() {
        return roomPage;
    }
}
