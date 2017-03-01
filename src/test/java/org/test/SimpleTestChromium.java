package org.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vaadin.testbench.TestBenchTestCase;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.LabelElement;

public class SimpleTestChromium extends TestBenchTestCase {

    private final String DRIVER_PATH="/media/dmitrii/Data/install/libs/chromedriver";
    private final String URL="http://localhost:8080";

    public void setUp() {

    }

    //CHANGE PATH TO YOU CHROME DRIVER
    @Test
    public void test1() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        WebDriver driver = new ChromeDriver();
        setDriver(driver);
        getDriver().get(URL);
        ButtonElement button = $(ButtonElement.class).first();
        button.click();
        LabelElement label = $(LabelElement.class).id("result");

        Assert.assertEquals("Thanks , it works!",label.getText());
        driver.quit();
    }
}
