package pages;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersPortalRecruitPage extends CareersPortalHeader {

    private WebElement positionCard (String title){
        return getByXpath("//h4[text()='" + title + "']/ancestor::div[contains(@class,'card-body')]");
    }

    private WebElement closePositionButton (String str) {
        return  getByXpath("//h4[text()='" + str + "']/ancestor::div[contains(@class,'card')]//button");
    }

    @FindBy (xpath = "//h4[contains(text(),'')]")
    private WebElement allPositionCards;

    public void goToJob(String value){
        waitForAllVisible(allPositionCards);
        WebElement card = positionCard(value);
        mouseOver(card);

    }

    public void removeJob (String title){
        WebElement closeButton = closePositionButton(title);
        waitForElementIsClickable(closeButton);
        click(closeButton);
        waitForDisappear(positionCard(title));
    }

    public boolean isPositionVisible(String title) {
        try {
            return positionCard(title).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getAllJobs (){
        return allPositionCards.getText();
    }

}
