package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContext.getWait;

public class CareersPortalLandingPage extends CareersPortalHeader {
    public CareersPortalLandingPage() {
        url = "https://skryabin-careers.herokuapp.com/";
        title = "Careers Portal";
    }

    private WebElement positionCard (String title) {
        return getByXpath("//h4[text()='"+title+"']/ancestor::a[contains(@href,'positions')]");
    }

    private WebElement anotherPositionCard(String title){
        return getByXpath("//h4[text()='"+title+"']/following::button[1]");
    }
    public void selectPosition (String title){
        WebElement card = positionCard(title);
        click(card);
    }

    public void clickOnSelectPosition (String value){
        WebElement position = positionCard(value);
        waitUntilContainsText(position);
        mouseOver(position);

        WebElement checkButton = anotherPositionCard(value);
        waitForVisible(checkButton);
        click(checkButton);
    }
}
