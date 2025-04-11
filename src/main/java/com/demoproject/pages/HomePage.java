package com.demoproject.pages;

import com.demoproject.actiondriver.ActionDriver;
import org.openqa.selenium.By;

public class HomePage {
    private ActionDriver actionDriver;

    private By adminTable = By.xpath("//span[text()='Admin']");
    private By pimTable = By.xpath("//span[text()='PIM']");
    private By userIdButton = By.cssSelector("oxd-userdropdown-name");
    private By logoutButton = By.xpath("//a[text()='Logout']");
}
