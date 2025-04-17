package com.demoproject.pages;

import io.fluentlenium.core.FluentPage;
import io.fluentlenium.core.annotation.PageUrl;
import io.fluentlenium.core.domain.FluentWebElement;
import io.fluentlenium.core.hook.wait.Wait;
import org.openqa.selenium.support.FindBy;

@PageUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
@Wait
public class DemoFlut extends FluentPage {
    @FindBy(name = "username")
    public FluentWebElement user;

    @FindBy(name = "password")
    public FluentWebElement password;

    @FindBy(xpath = "//button[text()=' Login ']")
    public FluentWebElement buttonLogin;

    public DemoFlut initLogin(String username,String password){
        this.user.fill().with(username);
        //this.user.write(username);
        //this.password.fill().with(password);
        this.password.write(password);
        System.out.println("Iniciando login de la pagina");
        return this;
    }
}
