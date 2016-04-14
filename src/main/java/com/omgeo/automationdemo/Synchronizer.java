/**
* Author:  Yawo Amegadje
* Function: This class is the Synchronizer 
* It defines takes WebDriver & WebElement as input the uses the WebDriver style fluent wait.
* The wait condition used is the Visibility of the WebElement passed to it
* On long term it can even be customized further so that the polling & time-out are parametized or read from a property file
*/
package com.omgeo.automationdemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Synchronizer {

    private WebDriver driver;

    public Synchronizer(WebDriver driver) {
        this.driver = driver;
    }

    public boolean waitForVisibilityOfElement(WebDriver driver, WebElement element) {
        boolean visibilityStatus = false;
        WebDriverWait webwait = new WebDriverWait(driver, 10000);
        webwait.withTimeout(60, TimeUnit.SECONDS);
        webwait.pollingEvery(500, TimeUnit.MILLISECONDS);
        webwait.until(ExpectedConditions.visibilityOf(element));
        try {
            Pause.pause(driver, 1);
        } catch (Exception e) {
            System.out.println("There was an issue pausing the browser");
        }
        return visibilityStatus;
    }

}
