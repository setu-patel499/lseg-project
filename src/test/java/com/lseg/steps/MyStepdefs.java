package com.lseg.steps;

import com.lseg.pages.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class MyStepdefs {
    @Given("^I am on homepage$")
    public void iAmOnHomepage() {
    }

    @And("^I click on accept cookies$")
    public void iClickOnAcceptCookies() {
     new HomePage().clickOnAcceptCookies();
    }

    @When("^I mouse hover and click in resources tab$")
    public void iMouseHoverAndClickInResourcesTab() {
        new HomePage().clickOnResourcesTab();
    }

    @Then("^I should able to verify text$")
    public void iShouldAbleToVerifyText() {
        String expectedMessage = "Connect with the world’s financial markets";
        String actualMessage = new HomePage().getVerifyText();
        Assert.assertEquals("text not displayed", expectedMessage, actualMessage);

    }
}
