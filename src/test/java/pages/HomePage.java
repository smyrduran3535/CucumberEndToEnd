package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id="account-menu")
    public WebElement userIcon;
    @FindBy(xpath = "//*[text()='Sign in']")
    public WebElement signInButon;
@FindBy(xpath = "//*[text()='Items&Titles']") public WebElement itemsTitle;
    @FindBy(linkText = "Room")
    public WebElement roomOption;

}
