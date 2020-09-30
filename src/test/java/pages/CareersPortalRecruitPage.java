package pages;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static support.TestContext.getWait;

public class CareersPortalRecruitPage extends CareersPortalHeader {

    private WebElement positionCard (String title){
        return getByXpath("//h4[text()='" + title + "']/ancestor::div[contains(@class,'card-body')]");
    }

    private WebElement closePositionButton (String str) {
        return  getByXpath("//h4[text()='" + str + "']/ancestor::div[contains(@class,'card')]//button");
    }

    @FindBy (xpath = "//div[@class='row']/div")
    private WebElement allPositionCards;

    public void goToJob(String value){
        WebElement card = positionCard(value);
        waitForVisible(card);
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
