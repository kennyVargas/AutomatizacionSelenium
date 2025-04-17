package com.demoproject.pages;


import com.demoproject.actiondriver.ActionDriver;
import com.demoproject.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private ActionDriver actionDriver;

    private By adminTable = By.xpath("//span[text()='Admin']");
    private By pimTable = By.xpath("//span[text()='PIM']");
    private By userIdButton = By.className("oxd-userdropdown-name");
    private By logoutButton = By.xpath("//a[text()='Logout']");
    private By logoPage = By.xpath("//div[@class='oxd-brand-banner']//img");

    public HomePage(WebDriver driver){
        //this.actionDriver = new ActionDriver(driver);
        this.actionDriver = BaseClass.getActionDriver();
    }

    public boolean isAdminTabVisible(){
        return actionDriver.isDisplayed(adminTable);
    }

    public boolean verifyLogoPage(){
        return actionDriver.isDisplayed(logoPage);
    }

    public void logout(){
        actionDriver.click(userIdButton);
        actionDriver.click(logoutButton);
    }
}
