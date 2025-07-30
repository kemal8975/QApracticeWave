package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "Email")
    public WebElement email;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(xpath = "//input[@class='btn btn-default']")
    public WebElement loginbutton;
}
