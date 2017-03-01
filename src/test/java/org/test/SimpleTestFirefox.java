package org.test;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import com.vaadin.testbench.TestBench;
import com.vaadin.testbench.TestBenchTestCase;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.LabelElement;

public class SimpleTestFirefox extends TestBenchTestCase {

    private final String FIREFOX_PATH="/media/dmitrii/Data/install/Firefoxes/45 ESR/firefox";
    private final String URL="http://localhost:8080";

    public void setUp() {

    }

    //CHANGE PATH TO YOU CHROME DRIVER
    @Test
    public void test1() {
        FirefoxBinary binary =
            new FirefoxBinary(new File(FIREFOX_PATH));
        driver = TestBench.createDriver(
            new FirefoxDriver(binary, new FirefoxProfile()));
        setDriver(driver);
        getDriver().get(URL);
        ButtonElement button = $(ButtonElement.class).first();
        button.click();
        LabelElement label = $(LabelElement.class).id("result");

        Assert.assertEquals("Thanks , it works!",label.getText());
        driver.quit();
    }
}
