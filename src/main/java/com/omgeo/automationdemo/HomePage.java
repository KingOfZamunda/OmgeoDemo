/**
* Author:  Yawo Amegadje
* Function: This class represents the HOME Page Object used in PageFactory style. 
* It defines the various WebElements on that page, define the constructor, initializes the PageFactory Elements
* It also contains various methods designed to promote code readability & method re-usability across the project.
*/
package com.omgeo.automationdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    @FindBy(css = ".first [href='/aboutomgeo']")
    protected WebElement aboutTab;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToPage(String url) {
        driver.get(url);
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void clickAboutTab() {
        aboutTab.click();
    }

}
