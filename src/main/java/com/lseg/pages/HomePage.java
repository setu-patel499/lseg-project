package com.lseg.pages;


import com.lseg.Utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Utility {
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());//creation of log method

    public HomePage() {
        PageFactory.initElements(driver, this);//call page factory class

    }

    @CacheLookup//to store element and memory to run test quicker
    @FindBy(xpath = "//span[contains(text(),'Accept all')]")//locator , with FindBy- find element from web
    WebElement acceptCookies;//object name

    @CacheLookup
    @FindBy(xpath = "//li[@role='none']//a[@role='menuitem'][normalize-space()='Resources']")
    WebElement resoucesTab;

    @CacheLookup
    @FindBy(xpath = "//div[@class='field field-name-field-comco-lp-headline field-type-text field-wrapper']")
    WebElement verifyText;


    public void clickOnAcceptCookies() {//method creation - this method click on accept cookies
        clickOnElement(acceptCookies);
        log.info("Clicking on acceptCookies : " + acceptCookies);
    }

    public void clickOnResourcesTab() {//method creation for mouse hover & click on resorcesTab
        mouseHoverAndClickOnElement(resoucesTab);
        log.info("MouseHovering to resourcesTab  :" + resoucesTab);
    }


    public String getVerifyText() {// this method creation of verifying text
        String message = getTextFromElement(verifyText);
        log.info("Getting text from : " + verifyText.toString());
        return message;
    }

}

