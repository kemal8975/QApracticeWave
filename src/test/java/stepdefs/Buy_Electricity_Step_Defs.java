package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BuyEnergyPage;
import utils.Driver;

import java.time.Duration;

public class Buy_Electricity_Step_Defs {

    BuyEnergyPage buyEnergyPage = new BuyEnergyPage();

    @Given("I am on the Energy Purchase Page")
    public void i_am_on_the_energy_purchase_page() {
        Driver.getDriver().get("https://ensekautomationcandidatetest.azurewebsites.net/Energy/Buy");
    }

    @Given("I press the Reset button on the Energy Purchase Page")
    public void i_press_the_reset_button_on_the_energy_purchase_page() {
        buyEnergyPage.reset.click();
    }

    @When("I purchase {int} units of Electricity energy")
    public void i_purchase_units_of_electricity_energy(Integer units) {
        buyEnergyPage.electirictybox.clear();
        buyEnergyPage.electirictybox.sendKeys(units.toString());
        buyEnergyPage.buyelectirity.click();
    }

    @Then("I should see the electricity purchase confirmation message:")
    public void i_should_see_the_electricity_purchase_confirmation_message(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement confirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'Thank you for your purchase')]")));
        String actualMessage = confirmation.getText();
        Assert.assertEquals(expectedMessage.trim(), actualMessage.trim());
    }

}
