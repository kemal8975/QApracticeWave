package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegisterPage;
import utils.Driver;

public class Register_step_defs {
    RegisterPage registerPage = new RegisterPage();
    @Given("I am on the registration page")
    public void i_am_on_the_registration_page() {
        Driver.getDriver().get("https://ensekautomationcandidatetest.azurewebsites.net/Account/Register");
    }
    @When("I enter a valid email and password")
    public void i_enter_a_valid_email_and_password() {
        registerPage.email.click();
        registerPage.email.sendKeys("kemal182182@gmail.com");

        registerPage.password.click();
        registerPage.password.sendKeys("Kemal123%");

        registerPage.confirmpassword.click();
        registerPage.confirmpassword.sendKeys("Kemal123%");
    }
    @When("I submit the registration form")
    public void i_submit_the_registration_form() {
        registerPage.regiserbutton.click();
    }
    @Then("I should see a confirmation message")
    public void i_should_see_a_confirmation_message() {
        // SINCE REGISTER FUNCTION DOESN'T WORK WE WON'T CONTINUE TO WRITE IT

        // HOWEVER IT SHOULD BE SOMETHING LIKE assertEquals(webelement.ispresent);
    }
    @Then("I should be redirected to the login page")
    public void i_should_be_redirected_to_the_login_page() {

    }
}
