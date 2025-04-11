package com.demoproject.actiondriver;

import com.demoproject.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ActionDriver {
    private WebDriver driver;
    private WebDriverWait wait;

    public ActionDriver(WebDriver driver){
        int implicitWait = Integer.parseInt(BaseClass.getProp().getProperty("explicitWait"));
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(implicitWait));
    }

    public void click(By by){
        try {
            waitForElementToBeClickable(by);
            driver.findElement(by).click();
        } catch (Exception e) {
            System.out.println("Error elemento sin accion de click: "+ e.getMessage());
        }
    }

    public void enterText(By by, String value){
        try {
            waitForElementToBeVisible(by);
            WebElement element =  driver.findElement(by);
            element.clear();
            element.sendKeys(value);
        } catch (Exception e) {
            System.out.println("Error no es posible ingresar valores: "+ e.getMessage());
        }
    }

    public String getText(By by){
        try {
            waitForElementToBeVisible(by);
            return driver.findElement(by).getText();
        } catch (Exception e) {
            System.out.println("Error al optener texto de entrada: "+ e.getMessage());
            return "";
        }
    }

    public boolean compareText(By by, String textCompare){
        try {
            waitForElementToBeVisible(by);
            String text = driver.findElement(by).getText();
            return text.equals(textCompare);
        } catch (Exception e) {
            System.out.println("Error al optener texto de entrada: "+ e.getMessage());
            return false;
        }
    }

    public boolean idDisplayed(By by){
        try {
            waitForElementToBeVisible(by);
            return driver.findElement(by).isDisplayed();
        } catch (Exception e) {
            System.out.println("Error elemento no es clickable:\n "+ e.getMessage());
            return false;
        }
    }

    public void waitForPageLoad(int timeOutInsec){
        try {
            wait.withTimeout(Duration.ofSeconds(timeOutInsec)).until(
                    WebDriver-> ((JavascriptExecutor) WebDriver).executeScript("").equals("complete"));
            System.out.println("Pagina cargada por completo");
        } catch (Exception e) {
            System.out.println("Error al cargar la pagina :"+e.getMessage());
        }
    }

    public void scrollToElement(By by){
        try {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            WebElement element = driver.findElement(by);
            javascriptExecutor.executeScript("arguments[0],scrollIntoView(true);",element);
        } catch (Exception e) {
            System.out.println("Error al desplazarse a la pagina :"+e.getMessage());
        }
    }

    private void waitForElementToBeClickable(By by){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Exception e) {
            System.out.println("Error elemento no es clickable:\n "+ e.getMessage());
        }
    }

    private void waitForElementToBeVisible(By by){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
            System.out.println("Error elemento no es visible:\n "+ e.getMessage());
        }
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
