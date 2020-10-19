package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import static support.TestContext.getDriver;

public class CareersPortalLandingPage extends CareersPortalHeader {
    @FindBy (xpath = "//div[@class='position-front']")
    private WebElement allPositions;

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

    private WebElement selectedPosition (String title){
        return getByXpath("//h4[text()='" + title + "']/ancestor::li[contains(@class,'li-selected')]");
    }

    public void selectPosition (String title){
        waitForAllVisible(allPositions);
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

    public boolean isPositionSelected (String title){
        getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        try {
            return selectedPosition(title).isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }
}
