package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UspsLookUpByZip extends UspsHeader {

    @FindBy(xpath="//a[text()='Find by Address']")
    private WebElement findByAddress;

    public void clickFindByAddress() {
        findByAddress.click();
    }
}
