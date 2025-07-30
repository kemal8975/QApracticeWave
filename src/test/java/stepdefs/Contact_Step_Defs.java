package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Driver;

import java.util.List;

public class Contact_Step_Defs {
    @Given("I open the homepage for contact tests")
    public void i_am_on_the_homepage() {
        Driver.getDriver().get("https://ensekautomationcandidatetest.azurewebsites.net/");
    }

    @When("I navigate to the Contact page via navbar")
    public void i_navigate_to_the_contact_page_via_navbar() {
        WebElement contactLink = Driver.getDriver().findElement(By.linkText("Contact"));
        contactLink.click();
    }

    @Then("the Contact page title should be {string}")
    public void the_contact_page_title_should_be(String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Then("the error image with src {string} should NOT be present")
    public void the_error_image_with_src_should_not_be_present(String src) {
        List<WebElement> errorImages = Driver.getDriver().findElements(By.xpath("//img[@src='" + src + "']"));
        Assert.assertTrue("Error image is displayed!", errorImages.isEmpty());
    }
}
