package com.demoproject.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
    protected static Properties prop;
    protected WebDriver driver;
    @BeforeMethod
    public void setup() throws IOException {
        System.out.println("Iniciando proceso...");
        launchBrowser();
        configureBrowser();
        staticWait(2);
    }

    @BeforeSuite
    public void loadConfig() throws IOException{
        prop = new Properties();
        FileInputStream file = new FileInputStream("src\\main\\resources\\config.properties");
        prop.load(file);
    }
    /**
     *Metodo iniciar el navegador
     *
    **/
    private void launchBrowser(){
        String browser = prop.getProperty("browser");
        if (browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Browser Not Supported: "+ browser);
        }
    }

    /**
     *Metodo para configurar opciones del navegador
    **/
    private void configureBrowser(){
        //Implicit Wait
        int implicitWait = Integer.parseInt(prop.getProperty("implicitWat"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));

        //maximize the browser
        driver.manage().window().maximize();
        //Navigate to url
        try {
            driver.get(prop.getProperty("url"));
        } catch (Exception e) {
            System.out.println("Error browser: "+e.getMessage());
        }
    }

    @AfterMethod
    public void tearDown(){
        if(driver!=null){
            try {
                driver.quit();
            } catch (Exception e) {
                System.out.println("Error browser: "+e.getMessage());
            }

        }
    }

    public void staticWait(int seconds){
        LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(seconds));
    }

    public WebDriver getDriver(){
        return this.driver;
    }
    public void setDrive(WebDriver driver){
        this.driver = driver;
    }

    public static Properties getProp() {
        return prop;
    }

    public void setProp(Properties prop) {
        BaseClass.prop = prop;
    }
}
