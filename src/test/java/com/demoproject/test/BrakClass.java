package com.demoproject.test;

import com.demoproject.base.BaseClass;
import org.testng.annotations.Test;

public class BrakClass extends BaseClass {
    @Test
    public void inicio(){
        String title = driver.getTitle();
        System.out.println("Titulo recuperado de sitio web: "+title);
        assert title.equals("OrangeHRM"): "Test Failed - Title is Not Matching";
        System.out.println("Test Passed - Title is Matching");
    }
}
