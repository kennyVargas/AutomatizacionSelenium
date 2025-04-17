package com.demoproject.test;

import com.demoproject.base.BaseClass;
import com.demoproject.pages.HomePage;
import com.demoproject.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass {
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeMethod
    public void setupPages(){
        loginPage = new LoginPage(getDriver());
        homePage = new HomePage(getDriver());
    }

    @Test
    public void verifyValidLoginTest(){
        loginPage.login("Admin","admin123");
        staticWait(3);
        Assert.assertTrue(homePage.isAdminTabVisible(),"Login exitoso siuuuuu");
        homePage.logout();
        staticWait(3);
    }

    @Test
    public void inValidLoginTest(){
        loginPage.login("admin222","admin");
        String expectedErrorMessage = "Credenciales invalidas";
        staticWait(3);
        Assert.assertTrue(loginPage.verifyErrorMessage(expectedErrorMessage),"no se pueded logear");
    }
}
