package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Driver;

public class About_Step_Defs {
    @When("I click the {string} link in the navbar")
    public void i_click_the_link_in_the_navbar(String linkText) {
        WebElement link = Driver.getDriver().findElement(By.linkText(linkText));
        link.click();
    }

    @Then("the page title should {string}")
    public void the_page_title_should_be(String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @When("I click the {string} button")
    public void i_click_the_button(String buttonText) {
        WebElement button = Driver.getDriver().findElement(By.linkText(buttonText));
        button.click();
    }

    @Then("the page should not be a 404 error")
    public void the_page_should_not_be_a_404_error() {
        String pageSource = Driver.getDriver().getPageSource().toLowerCase();

        Assert.assertFalse("Page shows 404 error",
                pageSource.contains("404") ||
                        pageSource.contains("not found") ||
                        pageSource.contains("error"));
    }

}
