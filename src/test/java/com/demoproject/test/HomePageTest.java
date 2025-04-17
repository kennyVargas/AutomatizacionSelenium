package com.demoproject.test;

import com.demoproject.base.BaseClass;
import com.demoproject.pages.HomePage;
import com.demoproject.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeMethod
    private  void setupPages(){
        loginPage = new LoginPage(getDriver());
        homePage = new HomePage(getDriver());
    }

    @Test
    public void verifyLogoPage(){
        loginPage.login("Admin","admin123");
        staticWait(3);
        if(homePage.verifyLogoPage()) System.out.println("Logo encontrado");
        Assert.assertTrue(homePage.verifyLogoPage(),"El logo no esta visible");
    }
}
