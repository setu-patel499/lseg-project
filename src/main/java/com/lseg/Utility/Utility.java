package com.lseg.Utility;


import com.google.common.base.Function;
import com.lseg.drivermanager.ManageDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Random;

public class Utility extends ManageDriver {//Inheritance concept by extending mangerDriver

    // customized method to eliminate repetitive contents when declaring x-path using find element and clicking on it.

    /**
     * ********************************* Basic Elements handling methods ******************************
     */


    public void verifyIfElementIsClickable(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public WebElement waitUntilVisibilityOfElementLocatedAndReturnElement(By by, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElement(by);
    }

    /**
     * verifying two strings are equal or not
     *

    public void verifyActualAndExpectedText(String actualText, String expectedText, String errorMessage) {
        Assert.assertEquals(actualText, expectedText, errorMessage);
    }

    /**
     * return true if getText matched with textToBeVarified text
     *
     *
     */
    public boolean verifyIfActualTextOfElementContainsExpectedText(WebElement element, String expectedText) {
        String actualText = getTextFromElement(element);
        return actualText.contains(expectedText);
    }

    /**
     * verify message from message box --> this is not alert box
     *
     * @param expectedTextContains
     * @return
     */
    public boolean verifyTheMessageFromPopUpWhichContainsText(WebElement element, String expectedTextContains) {
        return element.getText().toString().contains(expectedTextContains);
    }

    /**
     * @param expectedTextContains
     * @return
     */
    public boolean verifyPageTitleOfPage(WebElement element, String expectedTextContains) {
        Reporter.log("title of the page " + element.toString() + ("<br>"));
        return element.getText().trim().toString().contains(expectedTextContains);
    }

    /**
     * This method generated a random email
     *
     * @return
     */
    public String doRandomEmailGenerator() {
        String chars = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder email = new StringBuilder();
        Random randomEmail = new Random();
        while (email.length() < 10) {
            int index = (int) (randomEmail.nextFloat() * chars.length());
            email.append(chars.charAt(index));
        }
        String saltStr = (email.toString() + "@gmail.com");
        return saltStr;
    }


    // verify the title of the page
    public void verifyTitleOfThePageContains(WebElement pageTitleElement, String expectedText, String containsText) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.titleContains(containsText)); // this worked
        Assert.assertEquals(expectedTitleOfThePage(pageTitleElement), actualTitleOfThePage(expectedText), "Page title did not match");
    }

    public void waitUntilTitleOfThePageContains(String containsText) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.titleContains(containsText)); // this worked
    }

    public boolean verifyExpectedTextEqualsWithActual(WebElement element, String expectedText) {
        if (expectedText.equals(element.getText().trim())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyIfElementIsDisplayed(WebElement element) {
        if (element.isDisplayed()) {
            return true;
        } else
            return false;
    }

    /**
     * returns expected title text of the page
     */
    public String expectedTitleOfThePage(WebElement element) {
        waitUntilVisibilityOfElementLocated(element, 3);
        return element.getText();
    }

    /**
     * returns actual title text of the page
     */
    public String actualTitleOfThePage(String actualText) {
        return actualText;
    }


    // * This method will click on element
    public void clickOnElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }

    // * This method overloads click on element -- passing WebElement params
    public void clickOnElement(WebElement element) {
        element.click();
    }

    //  * This method will get text from element
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    //  * This method will get text from element --> using WebElement
    public String getTextFromElement(WebElement element) {
        return element.getText();
    }

    //  * This method will send text on element
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public void sendTextToElement(WebElement element, String text) {
        element.sendKeys(text);
    }

    // method to clear value
    public void clearValue(By by) {
        driver.findElement(by).clear();
    }

    public void clearValue(WebElement element) {
        element.clear();
    }

    /**
     * ********************************** Select Methods **********************************************
     */

    // dropdown selection- select by visible text
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    public void selectByVisibleTextFromDropDown(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    // dropdown selection - select by value
    public void selectByValueFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(text);
    }

    public void selectByValueFromDropDown(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByValue(text);
    }

    // dropdown selection - select by index
    public void selectByIndexFromDropdown(By by, int index) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByIndex(index);
    }

    public void selectByIndexFromDropdown(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    /**
     * ********************************** Action Methods **********************************************
     */

    // mouse hover to element
    public void mouseHoverToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    // mouse hover to element
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    // mouse hover to element and return target element
    public WebElement mouseHoverToElementAndReturnTargetWebElement(By by) {
        Actions actions = new Actions(driver);
        WebElement targetWebElement = driver.findElement(by);
        actions.moveToElement(targetWebElement).moveToElement(driver.findElement(by)).click().build().perform();
        return targetWebElement;
    }

/*    // method to select by Mouse Hover to element
    public void selectByMouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).moveToElement(driver.findElement(by)).click().build().perform();
    }*/

/*    //7. method to mouse hover action
    public WebElement mouseHoverActions(By by) {
        Actions actions = new Actions(driver);
        WebElement targetElement = driver.findElement(by);
        actions.moveToElement(targetElement).build().perform();
        return targetElement;
    }*/

    // method to mouse hover and click element
    public void mouseHoverAndClickOnElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }

    public void mouseHoverAndClickOnElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }

    // mouse hover on destination 1 then moved to destination 2 and click on destination 2
    public void mouseHoverOnFirstThenSecondAndClick(By by1, By by2) {
        Actions hover = new Actions(driver);
        WebElement destination1 = driver.findElement(by1);
        WebElement destination2 = driver.findElement(by2);
        hover.moveToElement(destination1).moveToElement(destination2).click().build().perform();
    }

    public void mouseHoverOnFirstThenSecondAndClick(WebElement element1, WebElement element2) {
        Actions hover = new Actions(driver);
        hover.moveToElement(element1).moveToElement(element2).click().build().perform();
    }

    // This method performs a Right Click Mouse Action at the current mouse location

    public void rightClick(By by) {
        Actions rightClick = new Actions(driver);
        WebElement a = driver.findElement(by);
        rightClick.contextClick().build().perform();
    }

    // Moves the slider from its current position to the desired position
    public void sliderMovement(By sliderBar, By sliderBox, int xAxis, int yAxis) {
        Actions moveSlider = new Actions(driver);
        WebElement mainSlider = driver.findElement(sliderBar);
        WebElement slider = driver.findElement(sliderBox);
        moveSlider.dragAndDropBy(slider, xAxis, yAxis).build().perform();
    }


    /**
     * ********************************** Alert Handling Methods *********************************************
     */

    /**
     * @param expectedText
     * @return
     */
    public boolean verifyIfActualMessageFromAlertContainsExpectedText(String expectedText) {
        String actualText = getTextFromAlert();
        if (actualText.contains(expectedText)) {
            return true;
        } else {
            return false;
        }
    }

    // method to switch to alert and accept --> meaning click on 'ok' button
    public void switchToAlertAndAccept() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    // this method will switch to alert and click on 'cancel' button
    public void switchToAlertAndDismiss() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    // this method will switch to alert and send keys (text in text (String) field --> within alert)
    public void sendTextToAlert(String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
    }

    // this method will switch to alert and get text
    public String getTextFromAlert() {
        Alert alert = driver.switchTo().alert();
        return alert.getText().trim();
    }

    /**
     * ****************************** Get URL methods ************************************************
     */
    // method to get current URL
    public String getCurrentUrl() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }

    /**
     * *************************** OTHER methods ****************************************************
     */

/*    // NOTE: This method needs to be revised due to Assert from jUnit and Maven are going to be different . check import before moving on with this method.
    // assert will compare expected and actual and verify element
    public void verifyElements(String expectedMessage, By by, String displayMessage ){
        String actualMessage = getTextFromElement(by);
      //  Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "Error message not displayed");
       // Assert.assertEquals(displayMessage, expectedMessage, actualMessage);
    }*/

    // random email generator
    public String randomEmailGenerator() {
        String chars = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder email = new StringBuilder();
        Random randomEmail = new Random();
        while (email.length() < 10) {
            int index = (int) (randomEmail.nextFloat() * chars.length());
            email.append(chars.charAt(index));
        }
        String saltStr = (email.toString() + "@gmail.com");
        return saltStr;
    }

    /**
     * ***************************** Wait Methods ***************************************************
     */

    /**
     * @param element
     */
    public void waitUntilElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    // wait until visibility of element located and find out the targeted text contains
    public boolean waitUntilVisibilityOfElementLocatedAndTextContains(WebElement element, String expectedTextContains, int seconds) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.wait(3);
        if (element.isDisplayed()) {
            return element.getText().trim().toString().contains(expectedTextContains);
        }
        return element.getText().trim().toString().contains(expectedTextContains);
    }

    // returning web element so return type is webelement
    public WebElement waitUntilVisibilityOfElementLocated(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    // wait before click on element --> wait until visibility of web element
    public void waitUntilVisibilityOfElementLocatedAndthenClickOnElement(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        waitUntilVisibilityOfElementLocated(by, time).click(); // will use wait until visibility of element located method mentioned above and then click
    }

    // wait before click on element --> wait until visibility of web element
    public void waitUntilVisibilityOfElementToBeClickableAndthenClickOnElement(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    // wait for element with Fluent Wait
    public WebElement waitForElementWithFluentWait(By by, int time, int pollingTime) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
        return element;
    }

    // wait for element with Fluent Wait
    public WebElement waitForElementWithFluentWait(By by, WebDriver driver) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
        return element;
    }

    // wait for element with Fluent Wait
    public WebElement waitForElementWithFluentWaitWithReturnOfWebElement(By by, WebDriver driver, int seconds, int pollingTime) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(seconds))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
        return element;
    }


    // the expected condition waits for an element to be clickable i.e. it should be present/displayed/visible on the screen as well as enabled
    public WebElement waitUntilElementToBeClickable(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.elementToBeClickable(by)); // if Expected condition is true then it will return WebElement of that locator used in the method
    }

    // This Method to be Tested --> will check if title is matched with the title you have passed as an argument
    public void waitUntilTitleIsMatched(By by, int time, String title) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.titleIs(title));
    }

    // This Method to be Tested --> will wait until presence of element located
    public void waitUntilpresenceOfElementLocated(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    // This Method to be Tested --> will wait until element is visible
    public void waitUntilVisibilityOfElementLocated(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // This Method to be Tested --> will wait until element is visible then click on element
    public void waitUntilVisibilityOfElementLocatedAndClickOnElement(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }


    // This Method to be Tested --> return nothing, if text to be present is true then it will click the element
    public void waitUntilTextToBePresenceInElementAndIfPresentThenClickOnElement(WebElement element, String text, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));// returns boolean value--> if true then will perform further statement in method
        element.click();
    }

    // This Method to be Tested --> return nothing, if text to be present is true then it will click the element
    public void waitUntilAttributeContains(By by, String attribute, String value, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.attributeContains(by, attribute, value)); // return boolean --> if true then perform further action
    }

    // This Method to be Tested --> return nothing, if attribute contains --> passing WelElement, String attribute and name
    public void waitUntilAttributeContains(WebElement element, String attribute, String value, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.attributeContains(element, attribute, value)); // return boolean --> if true then perform further action
    }

    // ****************** Random methods *****************************

    /**
     * This method will generate random string
     */
    public static String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    //************************** ScreenShot Methods *********************************************//

    /**
     * This method will take screenshot
     */
    public static void takeScreenShot() {
        String filePath = System.getProperty("user.dir") + "/src/test/java/resources/screenshots/";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scr1, new File(filePath + getRandomString(10) + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String currentTimeStamp() {
        Date d = new Date();
        return d.toString().replace(":", "_").replace(" ", "_");
    }

    public static String getScreenshot(WebDriver driver, String screenshotName) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // After execution, you could see a folder "FailedTestsScreenshots" under screenshot folder
        String destination = System.getProperty("user.dir") + "/src/test/java/resources/screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    /*
     *Screenshot methods
     */
    public static String takeScreenShot(String fileName) {
        String filePath = System.getProperty("user.dir") + "/test-output/html/";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        String imageName = fileName + currentTimeStamp() + ".jpg";
        String destination = filePath + imageName;
        try {
            FileUtils.copyFile(scr1, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }


}


