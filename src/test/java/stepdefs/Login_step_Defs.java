package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import utils.Driver;

public class Login_step_Defs {
    LoginPage loginPage = new LoginPage();
    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        Driver.getDriver().get("https://ensekautomationcandidatetest.azurewebsites.net/Account/Login");
        String s  = Driver.getDriver().getTitle();

        Assert.assertEquals(s,"Log in - Candidate Test");
    }
    @When("I enter valid email and password")
    public void i_enter_valid_email_and_password() {
        loginPage.email.click();
        loginPage.email.sendKeys("kemal182182@gmail.com");

        loginPage.password.click();
        loginPage.password.sendKeys("Kemal123%");
    }
    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.loginbutton.click();
    }
    @Then("I should be redirected to the homepage")
    public void i_should_be_redirected_to_the_homepage() {

        // login doesn't work, won't continue

    }

}
