package com.omgeo.automationdemo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Author: Yawo Amegadje Function: This class represents the ABOUT Page Object used in PageFactory style. It defines the
 * various WebElements on that page, define the constructor, initializes the PageFactory Elements It also contains
 * various methods designed to promote code readability & method re-usability across the project.
 */
public class AboutPage {

    private WebDriver driver;

    @FindBy(css = "#selectContainerProduct b")
    private WebElement productDropDownLink;

    @FindBy(css = ".chzn-results li")
    private List<WebElement> dropDownList;

    @FindBy(css = ".HeroHeaderOrange")
    public WebElement aboutPageHeadline;

    public AboutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectProductOption(String option) throws Exception {
        productDropDownLink.click();
        Pause.pause(driver, 2);
        getElement(dropDownList, option).click();
    }

    // Framework Method to promote re-usability
    private WebElement getElement(List<WebElement> elementList, String elementName) {
        for (WebElement we : elementList) {
            if (we.getText().equals(elementName)) {
                return we;
            }
        }
        // throw new Exception("Element not Found");
        return null;
    }
}
