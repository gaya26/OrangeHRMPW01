package Playwright.Java.OrangeHRM.Pages;

import com.microsoft.playwright.Page;

public class AdminPage {
    private Page page;

    // Selectors for Admin page elements
    private String adminTitle = "h6.oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module";
    private String userManagementTitle = "h6.oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-level";
    private String upgradeButton = "button.oxd-glass-button.orangehrm-upgrade-button";
    private String userProfilePicture = "img.oxd-userdropdown-img";
    private String userName = "p.oxd-userdropdown-name";
    private String addButton = "button.oxd-button.oxd-button--medium.oxd-button--secondary";
    private String userRoleSelect = "div.oxd-select-wrapper";
    private String employeeNameInput = "input[placeholder='Type for hints...']";
    private String statusSelect = "div.oxd-select-wrapper";
    private String usernameInput = "input.oxd-input.oxd-input--active";
    private String passwordInput = "input[type='password']";
    private String confirmPasswordInput = "input[type='password']";
    private String saveButton = "button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space";

    public AdminPage(Page page) {
        this.page = page;
    }

    public String getAdminTitle() {
        return page.textContent(adminTitle);
    }

    public String getUserManagementTitle() {
        return page.textContent(userManagementTitle);
    }

    public boolean isUpgradeButtonVisible() {
        return page.isVisible(upgradeButton);
    }

    public boolean isUserProfilePictureVisible() {
        return page.isVisible(userProfilePicture);
    }

    public String getUserName() {
        return page.textContent(userName);
    }

    public void clickAddButton() {
        page.click(addButton);
    }

    public void selectUserRole(String role) {
        page.click(userRoleSelect);
        page.click("text=" + role);
    }

    public void enterEmployeeName(String name) {
        page.fill(employeeNameInput, name);
    }

    public void selectStatus(String status) {
        page.click(statusSelect);
        page.click("text=" + status);
    }

    public void enterUsername(String username) {
        page.fill(usernameInput, username);
    }

    public void enterPassword(String password) {
        page.fill(passwordInput, password);
    }

    public void enterConfirmPassword(String password) {
        page.fill(confirmPasswordInput, password);
    }

    public void clickSaveButton() {
        page.click(saveButton);
    }
}
