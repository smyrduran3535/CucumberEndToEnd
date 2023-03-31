package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="username") public WebElement username;
    @FindBy(id="password") public WebElement password;
    @FindBy(id = "rememberMe")
    public WebElement rememberMeCheckbox;
@FindBy(xpath = "(//*[text()='Sign in'])[3]") public WebElement signinButtonuserpass;

}
