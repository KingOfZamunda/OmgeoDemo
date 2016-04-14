/**
* Author:  Yawo Amegadje
* Function: This class represents the main Test class that contains all the test performed for the project
* It defines some of the test variables like URL, expected pages etc.. 
* (Note: this can be improved further by reading some of these test params from a property file or from test input sheet
* The framework is based on PageFactory and TestNG & the project is a Maven type project
* Java compatibility: JDK 7
* Note: to get more details on the tests requirements please refer to the Exercise document
*/
package com.omgeo.automationdemo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//-- This class contains all the basic tests being performed
public class AutoEx {

    String browserType = "Firefox";
    String homePageUrl = "http://www.omgeo.com";
    String expectedAboutUrl = homePageUrl + "/aboutomgeo";
    String expectedAlertUrl = homePageUrl + "/alert";
    String expectedLeadershipUrl = homePageUrl + "/leadership_team";
    String execTonyName = "Tony Freeman";
    BrowserSelector brSelector = new BrowserSelector(browserType);
    WebDriver driver = brSelector.getDriver();
    HomePage homePage = new HomePage(driver);
    AboutPage aboutPage = new AboutPage(driver);
    AlertPage alertPage = new AlertPage(driver);
    Synchronizer synchronizer = new Synchronizer(driver);

    @BeforeTest
    public void StartTest() {
        System.out.println("\n >>>>>>>>>>>>>>>>>>> TEST RUN BEGINS- ENJOY   <<<<<<<<<<<<<<<<<<<<<<<<< \n\n");
    }

    @AfterTest
    public void closeBrowser() throws Exception {
        Pause.pause(driver, 3);
        System.out.println("\n\n >>>>>>>>>>>>>>>>>>> TEST RUN COMPLETE - THANK YOU !  <<<<<<<<<<<<<<<<<<<<<<<<<");
        driver.quit();
    }

    @Test
    public void navigateToHomePage() {
        System.out.println("\n ---------- Now navigating to HomePage ---------------");
        homePage.navigateToPage(homePageUrl);
        homePage.maximizeWindow();
        Assert.assertEquals(driver.getCurrentUrl(), homePageUrl + "/");
    }

    @Test(dependsOnMethods = { "navigateToHomePage" })
    public void clickAboutTab() {
        System.out.println("\n ---------- Now clicking About Tab on HomePage ---------------");
        synchronizer.waitForVisibilityOfElement(driver, homePage.aboutTab);
        homePage.clickAboutTab();
        Assert.assertEquals(driver.getCurrentUrl(), expectedAboutUrl);
    }

    @Test(dependsOnMethods = { "clickAboutTab" })
    public void selectProductOption() throws Exception {
        System.out.println("\n ---------- Now selecting ALERT option in dropdown ---------------");
        synchronizer.waitForVisibilityOfElement(driver, aboutPage.aboutPageHeadline);
        aboutPage.selectProductOption("ALERT");
        Assert.assertEquals(driver.getCurrentUrl(), expectedAlertUrl);
    }

    @Test(dependsOnMethods = { "selectProductOption" })
    public void clickLeadershipTeam() {
        System.out.println("\n ---------- Now clicking Leadership link on Alert Page ---------------");
        synchronizer.waitForVisibilityOfElement(driver, homePage.aboutTab);
        alertPage.mouseOverToAbout();
        synchronizer.waitForVisibilityOfElement(driver, alertPage.leadershipTeam);
        alertPage.clickLeadershipTeam();
        Assert.assertEquals(driver.getCurrentUrl(), expectedLeadershipUrl);
    }

    @Test(dependsOnMethods = { "clickLeadershipTeam" })
    public void clickOnTonyFreeman() throws Exception {
        System.out.println("\n ---------- Now clicking link for Tony Freeman ---------------");
        alertPage.clickTonyFreeman();
        String execNameDisplayed = alertPage.checkExecNameOnPopup(execTonyName);
        Assert.assertEquals(execNameDisplayed, execTonyName);
    }

}
