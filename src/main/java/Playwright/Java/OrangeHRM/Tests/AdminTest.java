package Playwright.Java.OrangeHRM.Tests;

import com.microsoft.playwright.*;
import org.testng.Assert;
import org.testng.annotations.*;
import Playwright.Java.OrangeHRM.Pages.AdminPage;
import Playwright.Java.OrangeHRM.Pages.DashBoardPage;
import Playwright.Java.OrangeHRM.Pages.LoginPage;

public class AdminTest {
    private Playwright playwright;
    private Browser browser;
    private Page page;
    private AdminPage adminPage;
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
        dashBoardPage.clickAdminMenuItem(); 

        adminPage = new AdminPage(page);
    }

    @Test
    public void testAdminHeaderElements() {
        String adminTitle = adminPage.getAdminTitle();
        Assert.assertEquals(adminTitle, "Admin", "Admin title is not as expected.");

        String userManagementTitle = adminPage.getUserManagementTitle();
        Assert.assertEquals(userManagementTitle, "User Management", "User Management title is not as expected.");

        Assert.assertTrue(adminPage.isUpgradeButtonVisible(), "Upgrade button is not visible.");

        Assert.assertTrue(adminPage.isUserProfilePictureVisible(), "User profile picture is not visible.");

        String userName = adminPage.getUserName();
        Assert.assertEquals(userName, "manda user", "User name is not as expected.");
    }

    @Test
    public void testAddUserFunctionality() {
        adminPage.clickAddButton();
        adminPage.selectUserRole("Admin"); 
        adminPage.enterEmployeeName("John Doe");
        adminPage.selectStatus("Enabled");
        adminPage.enterUsername("johndoe");
        adminPage.enterPassword("Password123!");
        adminPage.enterConfirmPassword("Password123!");
        adminPage.clickSaveButton();
    }

    @AfterClass
    public void tearDown() {
        browser.close();
        playwright.close();
    }
}
