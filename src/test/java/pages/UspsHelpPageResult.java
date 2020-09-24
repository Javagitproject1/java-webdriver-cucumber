package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UspsHelpPageResult extends UspsHeader {

    @FindBy (xpath = "//h2/*[contains (text (), 'Articles')]")
    private WebElement helpResults;

    public String getHelpSearchResults (){
        waitForVisible(helpResults);
        return helpResults.getText();
    }
}
