package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CareersPortalPositionPage extends CareersPortalHeader {

    @FindBy (xpath = "//label[@for='positionTitle']/following-sibling::span")
    private WebElement positionTitle;

    private WebElement button(String value){
        return getByXpath("//button[text()='" + value + "'][@type='submit']");
    }

    public String getTitle(){
        waitForVisible(positionTitle);
        return positionTitle.getText();
    }

    public void clickButton(String value){
        WebElement myButton = button(value);
        waitForVisible(myButton);
        click(myButton);
    }
}
