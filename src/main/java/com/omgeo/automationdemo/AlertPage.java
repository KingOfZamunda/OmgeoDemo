/**
* Author:  Yawo Amegadje
* Function: This class represents the ALERT Page Object used in PageFactory style. 
* It defines the various WebElements on that page, define the constructor, initializes the PageFactory Elements
* It also contains various methods designed to promote code readability & method re-usability across the project.
*/
package com.omgeo.automationdemo;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPage {

    private WebDriver driver;

    @FindBy(xpath = ".//*[@id='subNav']/ul/li[2]/a")
    protected WebElement leadershipTeam;

    @FindBy(css = ".first.mabout>a")
    private WebElement aboutAlert;

    @FindBy(css = "a[href*='tony-freeman-bio']")
    WebElement tonyFreeman;

    @FindBy(css = "#simplemodal-data>iframe")
    private WebElement leadershipPopup;

    @FindBy(css = "html>body>table>tbody>tr>td>strong")
    WebElement execsName;

    public void mouseOverToAbout() {
        Actions action = new Actions(driver);
        action.moveToElement(aboutAlert).build().perform();
    }

    public void clickLeadershipTeam() {
        leadershipTeam.click();
    }

    public AlertPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickTonyFreeman() {
        tonyFreeman.click();
    }

    public String checkExecNameOnPopup(String execName) throws Exception {
        Set<String> set1 = driver.getWindowHandles();
        Iterator<String> win1 = set1.iterator();
        String handle = win1.next();
        driver.switchTo().window(handle);
        Pause.pause(driver, 4);
        driver.switchTo().frame(leadershipPopup);
        String execNameDisplayed = execsName.getText();
        System.out.println("The name of the Executive displayed in the popup is ----> " + execNameDisplayed);
        return execNameDisplayed;
    }
}
