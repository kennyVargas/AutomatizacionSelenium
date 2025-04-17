package com.demoproject.pages;

import com.demoproject.actiondriver.ActionDriver;
import com.demoproject.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private ActionDriver actionDriver;
    private By userNameField  = By.name("username");
    private By passwordField = By.cssSelector("input[type='password']");
    private By loginButton = By.xpath("//button[text()=' Login ']");
    private By errorMenssage = By.xpath("//p[text()='Invalid credentials']");

    public LoginPage(WebDriver driver){
        //this.actionDriver = new ActionDriver(driver);
        this.actionDriver = BaseClass.getActionDriver();
    }

    public void login(String userName,String password){
        actionDriver.enterText(userNameField,userName);
        actionDriver.enterText(passwordField,password);
        actionDriver.click(loginButton);
    }
    public boolean isErrorMessageDisplay(){
        return actionDriver.isDisplayed(errorMenssage);
    }
    public String getErrorMessageText(){
        return actionDriver.getText(errorMenssage);
    }
    public boolean verifyErrorMessage(String expectedError){
        return actionDriver.compareText(errorMenssage,expectedError);
    }
}
