package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContext.getExecutor;
import static support.TestContext.getWait;

public class UspsHelpPage extends UspsHeader {

    @FindBy (xpath = "//input[@placeholder='Search for a topic']")
    private WebElement searchBar;


    public void runSearch (String value) {
        waitForVisible(searchBar);
        searchBar.sendKeys(value);
        searchBar.sendKeys(Keys.ENTER);
    }

}
