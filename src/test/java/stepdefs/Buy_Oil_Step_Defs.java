package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BuyEnergyPage;
import utils.Driver;

import java.time.Duration;

public class Buy_Oil_Step_Defs {
    BuyEnergyPage buyEnergyPage = new BuyEnergyPage();
    WebDriver driver = Driver.getDriver();

    @Given("User is on the energy purchase page")
    public void user_is_on_the_energy_purchase_page() {
        driver.get("https://ensekautomationcandidatetest.azurewebsites.net/Energy/Buy");
    }

    @Given("User clicks the reset button")
    public void user_clicks_the_reset_button() {
        buyEnergyPage.reset.click();
    }

    @When("User purchases {int} units of Oil")
    public void user_purchases_units_of_oil(Integer units) {
        buyEnergyPage.oilbox.clear();
        buyEnergyPage.oilbox.sendKeys(String.valueOf(units));
        buyEnergyPage.buyoil.click();
    }

    @Then("User should see the confirmation for oil purchase:")
    public void user_should_see_the_confirmation_for_oil_purchase(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String xpath = "//*[contains(text(),'Thank you for your purchase')]";
        String actualMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(xpath))).getText();
        Assert.assertEquals(expectedMessage.trim(), actualMessage.trim());
    }}
