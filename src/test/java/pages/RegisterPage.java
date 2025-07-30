package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class RegisterPage {


    public RegisterPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "Email")
    public WebElement email;

    @FindBy(id = "Password")
    public  WebElement password;

    @FindBy(id = "ConfirmPassword")
    public  WebElement confirmpassword;

    @FindBy(xpath = "//input[@class='btn btn-default']")
    public WebElement regiserbutton;

    @FindBy(xpath = "//li[text()='The Email field is not a valid e-mail address.']")
    public WebElement notvalidemailerrormessage;

    @FindBy(xpath = "//li[text()='The Password field is required.']")
    public WebElement passwordfieldrequired;

    @FindBy(xpath = "//li[text()='The Password must be at least 6 characters long.']")
    public WebElement passwordmustbe6chars;

    @FindBy(xpath = "//li[text()=\"Passwords must have at least one non letter or digit character. Passwords must have at least one lowercase ('a'-'z'). Passwords must have at least one uppercase ('A'-'Z').\"]")
    public  WebElement doubleerrormessages1;



    @FindBy(xpath = "//li[text()=\"Passwords must have at least one non letter or digit character. Passwords must have at least one digit ('0'-'9').\"]")
    public WebElement passwordmustcontain2;

}
