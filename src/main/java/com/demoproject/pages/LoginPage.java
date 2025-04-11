package com.demoproject.pages;

import com.demoproject.actiondriver.ActionDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private ActionDriver actionDriver;
    private By userNameField  = By.name("username");
    private By passwordField = By.cssSelector("input[type='password']");
    private By loginButton = By.xpath("//button[text()=' Login ']");
    private By errorMenssage = By.xpath("//p[text()='Invalid credentials']");

    public LoginPage(WebDriver driver){
        this.actionDriver = new ActionDriver(driver);
    }

    public void login(String userName,String password){
        actionDriver.enterText(userNameField,"Admin");
        actionDriver.enterText(passwordField,"admin123");
        actionDriver.click(loginButton);
    }
    public boolean isErrorMessageDisplay(){
        return actionDriver.idDisplayed(errorMenssage);
    }
    public String getErrorMenssage(){
        return actionDriver.getText(errorMenssage);
    }
    public void verifyErrorMessage(String expectedError){
        actionDriver.compareText(errorMenssage,expectedError);
    }
}
