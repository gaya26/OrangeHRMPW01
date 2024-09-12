package Playwright.Java.OrangeHRM.Pages;

import com.microsoft.playwright.Page;

public class DashBoardPage {
    private Page page;

    private String dashboardTitle = "h6.oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module";
    private String upgradeButton = "button.oxd-glass-button.orangehrm-upgrade-button";
    private String userProfilePicture = "img.oxd-userdropdown-img";
    private String userName = "p.oxd-userdropdown-name";
    private String helpButton = "button.oxd-icon-button[title='Help']";

    private String timeAtWorkWidgetTitle = "p.oxd-text.oxd-text--p";
    private String timeAtWorkProfileImage = "img.employee-image";
    private String timeAtWorkState = "p.orangehrm-attendance-card-state";
    private String timeAtWorkDetails = "p.orangehrm-attendance-card-details";
    private String timeAtWorkFullTime = "span.orangehrm-attendance-card-fulltime";
    private String timeAtWorkActionButton = "button.oxd-icon-button.oxd-icon-button--solid-main.orangehrm-attendance-card-action";

    private String adminMenuItem = "a.oxd-main-menu-item[href='/web/index.php/admin/viewAdminModule']";
    
    public DashBoardPage(Page page) {
        this.page = page;
    }

    public String getDashboardTitle() {
        return page.textContent(dashboardTitle);
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

    public boolean isHelpButtonVisible() {
        return page.isVisible(helpButton);
    }

    public String getTimeAtWorkWidgetTitle() {
        return page.textContent(timeAtWorkWidgetTitle);
    }

    public boolean isTimeAtWorkProfileImageVisible() {
        return page.isVisible(timeAtWorkProfileImage);
    }

    public String getTimeAtWorkState() {
        return page.textContent(timeAtWorkState);
    }

    public String getTimeAtWorkDetails() {
        return page.textContent(timeAtWorkDetails);
    }

    public String getTimeAtWorkFullTime() {
        return page.textContent(timeAtWorkFullTime);
    }

    public boolean isTimeAtWorkActionButtonVisible() {
        return page.isVisible(timeAtWorkActionButton);
    }
    
    public void clickAdminMenuItem() {
        page.click(adminMenuItem);
    }
}
