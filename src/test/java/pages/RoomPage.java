package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class RoomPage {
    public RoomPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
@FindBy(id="jh-create-entity") public WebElement createNewRoom;
@FindBy(id="room-roomNumber") public WebElement roomNumber;
@FindBy(id="room-roomType") public WebElement roomType;
@FindBy(id="room-status") public WebElement roomStatus;
@FindBy(id="room-price") public WebElement roomPrice;
@FindBy(id="room-description") public WebElement roomDescription;
@FindBy(id="room-createdDate") public WebElement roomCreatedDate;
@FindBy(id="save-entity") public WebElement saveEntity;
    @FindBy(xpath = "//tbody//td[2]")
    public List<WebElement> roomNumberlist;
    @FindBy(xpath = "//tbody/tr[1]/td[1]")
    public WebElement fistId;

}
