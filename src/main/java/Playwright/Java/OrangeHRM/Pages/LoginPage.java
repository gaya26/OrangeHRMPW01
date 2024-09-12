package Playwright.Java.OrangeHRM.Pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    private Page page;

    private String usernameField = "input[name='username']";
    private String passwordField = "input[name='password']";
    private String loginButton = "button[type='submit']";
    private String loginErrorMessage = ".oxd-alert-content";

    public LoginPage(Page page) {
        this.page = page;
    }

    public void navigateToLoginPage(String url) {
        page.navigate(url);
    }

    public void enterUsername(String username) {
        page.fill(usernameField, username);
    }

    public void enterPassword(String password) {
        page.fill(passwordField, password);
    }

    public void clickLogin() {
        page.click(loginButton);
    }

    public String getLoginErrorMessage() {
        return page.textContent(loginErrorMessage);
    }
    
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
