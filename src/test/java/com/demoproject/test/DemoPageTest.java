package com.demoproject.test;

import io.fluentlenium.adapter.junit.FluentTest;
import com.demoproject.pages.DemoFlut;
import io.fluentlenium.configuration.FluentConfiguration;
import io.fluentlenium.core.annotation.Page;
import io.fluentlenium.core.hook.wait.Wait;
import org.testng.annotations.Test;

@FluentConfiguration(capabilities = "{\"goog:chromeOptions\": {\"args\": [\"headless\",\"disable-gpu\"]}}")
@Wait
public class DemoPageTest  extends FluentTest {
    @Page
    private DemoFlut demoFlut;

    @Test
    public void inicioLogin(){
        goTo(demoFlut).initLogin("Admin","admin123");
    }
}
