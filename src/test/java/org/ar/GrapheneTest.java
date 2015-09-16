package org.ar;

import junit.framework.Assert;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@RunWith(Arquillian.class)
public class GrapheneTest {

    //https://docs.jboss.org/author/display/ARQGRA2/Getting+Started

    @Drone
    WebDriver browser;

    @FindBy
    private WebElement userName;

    @Test
    public void testGoogle() {

        browser.get("http://www.google.com/");

        List<WebElement> elements = browser.findElements(
                By.xpath("//span[contains(text(), 'Google Search')]"));

        Assert.assertTrue("Page not loaded", elements.size() == 0);
    }

    @Test
    public void testOpeningHomePage() {
        browser.get("http://www.google.com");

        String pageTitle = browser.getTitle();

        Assert.assertEquals(pageTitle, "Google");
    }
}
