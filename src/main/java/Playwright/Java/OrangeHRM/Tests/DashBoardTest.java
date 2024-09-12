package Playwright.Java.OrangeHRM.Tests;

import com.microsoft.playwright.*;
import org.testng.Assert;
import org.testng.annotations.*;
import Playwright.Java.OrangeHRM.Pages.DashBoardPage;
import Playwright.Java.OrangeHRM.Pages.LoginPage;

public class DashBoardTest {
    private Playwright playwright;
    private Browser browser;
    private Page page;
    private DashBoardPage dashBoardPage;

    @BeforeClass
    public void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateToLoginPage("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage.login("Admin", "admin123");
        dashBoardPage = new DashBoardPage(page);
    }

    @Test
    public void testDashboardHeaderElements() {
        String title = dashBoardPage.getDashboardTitle();
        Assert.assertEquals(title, "Dashboard", "Dashboard title is not as expected.");

        Assert.assertTrue(dashBoardPage.isUpgradeButtonVisible(), "Upgrade button is not visible.");

        Assert.assertTrue(dashBoardPage.isUserProfilePictureVisible(), "User profile picture is not visible.");

        String userName = dashBoardPage.getUserName();
        Assert.assertTrue(userName.contains("user"), "User name is not as expected.");

        Assert.assertTrue(dashBoardPage.isHelpButtonVisible(), "Help button is not visible.");
    }

    @Test
    public void testTimeAtWorkWidget() {
        String widgetTitle = dashBoardPage.getTimeAtWorkWidgetTitle();
        Assert.assertEquals(widgetTitle, "Time at Work", "Time at Work widget title is not as expected.");

        Assert.assertTrue(dashBoardPage.isTimeAtWorkProfileImageVisible(), "Profile image in Time at Work widget is not visible.");

        String stateText = dashBoardPage.getTimeAtWorkState();
        Assert.assertEquals(stateText, "Punched Out", "Time at Work state text is not as expected.");

        String detailsText = dashBoardPage.getTimeAtWorkDetails();
        Assert.assertTrue(detailsText.contains("Punched Out"), "Time at Work details text is not as expected.");

        String fullTimeText = dashBoardPage.getTimeAtWorkFullTime();
        Assert.assertTrue(fullTimeText.contains("0h 2m"), "Time at Work full time text is not as expected.");

        Assert.assertTrue(dashBoardPage.isTimeAtWorkActionButtonVisible(), "Action button in Time at Work widget is not visible.");
    }
    
    @Test
    public void testClickAdminMenuItem() {
        dashBoardPage.clickAdminMenuItem();
        
        String currentUrl = page.url();
        Assert.assertTrue(currentUrl.contains("/admin/viewAdminModule"), "Failed to navigate to Admin page.");
    }

    @AfterClass
    public void tearDown() {
        browser.close();
        playwright.close();
    }
}
