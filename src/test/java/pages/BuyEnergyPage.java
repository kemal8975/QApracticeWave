package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class BuyEnergyPage {
    public BuyEnergyPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@name='Reset']")
    public WebElement reset;

    // box
    @FindBy(xpath = "(//input[@name='energyType.AmountPurchased'])[1]\n")
    public WebElement gasbox;

    @FindBy(xpath = "(//input[@name='energyType.AmountPurchased'])[2]\n")
    public WebElement electirictybox;

    @FindBy(xpath = "(//input[@name='energyType.AmountPurchased'])[3]\n")
    public WebElement oilbox;

    // buybutton

    @FindBy(xpath = "(//input[@name='Buy'])[1]")
    public WebElement buygas;

    @FindBy(xpath = "(//input[@name='Buy'])[2]")
    public WebElement buyelectirity;

    @FindBy(xpath = "(//input[@name='Buy'])[3]")
    public WebElement buyoil;


}
