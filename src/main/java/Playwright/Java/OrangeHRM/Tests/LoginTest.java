package Playwright.Java.OrangeHRM.Tests;

import com.microsoft.playwright.*;

import org.testng.Assert;
import org.testng.annotations.*;
import Playwright.Java.OrangeHRM.Pages.LoginPage;

public class LoginTest {
    private Playwright playwright;
    private Browser browser;
    private Page page;
    private LoginPage loginPage;

    @BeforeClass
    public void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        loginPage = new LoginPage(page);
    }

    @Test
    public void testLoginSuccess() {
        loginPage.navigateToLoginPage("https://your-orangehrm-url.com");
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();
        
        boolean isDashboardVisible = page.isVisible("div[class='dashboard']"); 
        Assert.assertTrue(isDashboardVisible, "Login failed. Dashboard is not visible after login.");
    }

    @Test
    public void testLoginFailure() {
        loginPage.navigateToLoginPage("https://your-orangehrm-url.com");

        loginPage.enterUsername("InvalidUser");
        loginPage.enterPassword("InvalidPassword");

        loginPage.clickLogin();

        String errorMessage = loginPage.getLoginErrorMessage();
        assert errorMessage.contains("Invalid credentials") : "Error message not as expected!";
        
        boolean isLoginPageStillVisible = page.isVisible("input[name='username']");
        Assert.assertTrue(isLoginPageStillVisible, "Login page should still be visible after failed login.");
    }

    @AfterClass
    public void tearDown() {
        browser.close();
        playwright.close();
    }
}

