package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.BuyEnergyPage;
import utils.Driver;

public class Buy_Energy_Step_Defs {
    BuyEnergyPage buyEnergyPage = new BuyEnergyPage();

    @Given("I am on the energy buy page")
    public void i_am_on_the_energy_buy_page() {
        Driver.getDriver().get("https://ensekautomationcandidatetest.azurewebsites.net/Energy/Buy");
    }

    @Given("I press the reset button")
    public void i_press_the_reset_button() {
        buyEnergyPage.reset.click();
    }

    @When("I buy {int} units of Gas")
    public void i_buy_units_of_gas(Integer units) {
        buyEnergyPage.gasbox.clear();
        buyEnergyPage.gasbox.sendKeys(units.toString());
        buyEnergyPage.buygas.click();
    }

    @Then("I should see the confirmation message:")
    public void i_should_see_the_confirmation_message(String expectedMessage) {

        String actualMessage = Driver.getDriver().findElement(By.tagName("body")).getText();

        Assert.assertTrue("Confirmation message not found!", actualMessage.contains(expectedMessage.trim()));
    }
}
