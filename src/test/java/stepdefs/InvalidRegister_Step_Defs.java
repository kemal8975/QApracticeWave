package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.RegisterPage;
import utils.Driver;
import utils.Methods;

public class InvalidRegister_Step_Defs {
    RegisterPage registerPage = new RegisterPage();
    Methods methods = new Methods();
    @When("I enter an invalid email and a valid password")
    public void i_enter_an_invalid_email_and_a_valid_password() {
        Driver.getDriver().get("https://ensekautomationcandidatetest.azurewebsites.net/Account/Register");

        registerPage.email.click();
        registerPage.email.sendKeys("kemal182182");

        registerPage.password.click();
        registerPage.password.sendKeys("Kemal123%");

        registerPage.confirmpassword.click();
        registerPage.confirmpassword.sendKeys("Kemal123%");
        registerPage.regiserbutton.click();

    }
    @Then("I should see an email error message")
    public void i_should_see_an_error_message() {
        String actualMessage = registerPage.notvalidemailerrormessage.getText();

        Assert.assertEquals(actualMessage, "The Email field is not a valid e-mail address.");
    }
    @When("I enter a valid email and leave the password blank")
    public void i_enter_a_valid_email_and_leave_the_password_blank() {
        methods.clearAllFields();

        registerPage.email.click();
        registerPage.email.sendKeys("kemal182182@gmail.com");

        registerPage.regiserbutton.click();


    }
    @When("I should see an password required error message")
    public void i_enter_a_valid_email_and_a_password_less_than_characters() {
        String actualMessage = registerPage.passwordfieldrequired.getText();

        Assert.assertEquals(actualMessage, "The Password field is required.");
    }
    @When("I enter a valid email and a password less than six characters")
    public void i_enter_a_valid_email_and_a_password_with_only_numbers() {
        methods.clearAllFields();

        registerPage.email.click();
        registerPage.email.sendKeys("kemal182182@gmail.com");

        registerPage.password.click();
        registerPage.password.sendKeys("123");

        registerPage.regiserbutton.click();
    }
    @Then("I should see an password must be six char long error message")
    public void i_should_see_error_messages() {

        String actualMessage = registerPage.passwordmustbe6chars.getText();

        Assert.assertEquals(actualMessage, "The Password must be at least 6 characters long.");

    }
    @When("I enter a valid email and a password with only numbers")
    public void i_enter_a_valid_email_and_a_password_with_only_letters() {

        methods.clearAllFields();

        registerPage.email.click();
        registerPage.email.sendKeys("kemal182182@gmail.com");

        registerPage.password.click();
        registerPage.password.sendKeys("123456");

        registerPage.confirmpassword.click();
        registerPage.confirmpassword.sendKeys("123456");

        registerPage.regiserbutton.click();
    }
    @Then("I should see error messages")
    public void i_should_see_messages() {

        String actualMessage = registerPage.doubleerrormessages1.getText();

        Assert.assertEquals(actualMessage, "Passwords must have at least one non letter or digit character. Passwords must have at least one lowercase ('a'-'z'). Passwords must have at least one uppercase ('A'-'Z').");





    }

    @When("I enter a valid email and a password with only letters")
    public void iEnterAValidEmailAndAPasswordWithOnlyLetters() {
        methods.clearAllFields();

        registerPage.email.click();
        registerPage.email.sendKeys("kemal182182@gmail.com");

        registerPage.password.click();
        registerPage.password.sendKeys("ABCabc");

        registerPage.confirmpassword.click();
        registerPage.confirmpassword.sendKeys("ABCabc");




    }

    @Then("I should see double error message")
    public void iShouldSeeErrorMessages() {
        String actualMessage = registerPage.passwordmustcontain2.getText();
        Assert.assertEquals(actualMessage, "Passwords must have at least one non letter or digit character. Passwords must have at least one digit ('0'-'9').");

    }
}
