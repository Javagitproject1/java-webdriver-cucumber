package pages;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import static support.TestContext.getDriver;

public class CareersPortalRecruitPage extends CareersPortalHeader {

    private WebElement positionCard(String title) {
        return getByXpath("//h4[text()='" + title + "']/ancestor::div[@class='card-body']/*");
    }

    private WebElement positionTitle (String title){
        return getByXpath("//h4[text()='" + title + "']");
    }

    private WebElement closePositionButton(String str) {
        return getByXpath("//h4[text()='" + str + "']/ancestor::div[contains(@class,'card')]//button");
    }

    @FindBy(xpath = "//h4[contains(text(),'')]/ancestor::div[@class='card-body']")
    private WebElement allPositionCards;

    @FindBy(xpath = "//h4[text()='New Position']")
    private WebElement newPosition;

    public void goToJob(String value) {
        waitForAllVisible(allPositionCards);
        WebElement card = positionCard(value);
        mouseOver(card);
    }

    public void removeJob(String title) {
        WebElement closeButton = closePositionButton(title);
        waitForElementIsClickable(closeButton);
        click(closeButton);
        waitForDisappear(positionCard(title));
    }

    public boolean positionVisible(String title) {
        getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        try {
            return positionCard(title).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getAllJobs() {
        waitForAllVisible(allPositionCards);
        return allPositionCards.getText();
    }

    public void clickOnNewPosition() {
        waitForAllVisible(allPositionCards);
        click(newPosition);
    }

    public void clickOnPosition (String title){
        click(positionTitle(title));
    }
}
