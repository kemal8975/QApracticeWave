package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;

public class Home_Step_Defs {
    @Given("I am on the homepage")
    public void i_am_on_the_homepage() {
        Driver.getDriver().get("https://ensekautomationcandidatetest.azurewebsites.net/");
    }

    @Then("the page title should be {string}")
    public void the_page_title_should_be(String expectedTitle) {
        Assert.assertEquals(expectedTitle, Driver.getDriver().getTitle());
    }

    @Then("the main heading should be {string}")
    public void the_main_heading_should_be(String expectedHeading) {
        WebElement h1 = Driver.getDriver().findElement(By.tagName("h1"));
        Assert.assertEquals(expectedHeading, h1.getText());
    }

    @When("I click the {string} link, it should be clickable")
    public void i_click_the_link_it_should_be_clickable(String linkText) {
        WebElement link = Driver.getDriver().findElement(By.linkText(linkText));
        Assert.assertTrue(link.isDisplayed() && link.isEnabled());
    }

}
