package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static support.TestContext.getDriver;

public class CareersPortalMyJobsPage extends CareersPortalHeader {

    private List<WebElement> positions (){
        return getAllByXpath("//div [@style='position: relative;']/li/span/a/div/h4");
    }
    @FindBy (xpath = "//div [@style='position: relative;']/li/span/a/div/h4")
    private WebElement position;

    @FindBy (xpath = "//li [@class='list-item']/h4[@class='position-name']")
    private WebElement noPositions;

    private WebElement positionCard(String title){
        return getByXpath("//h4[text()='"+title+"']/following::button[1]");
    }

    private WebElement selectedPosition(String title){
        return getByXpath("//h4[text()='"+title+"']");
    }

    public String confirmPosition (){
        waitForVisible(position);
        String a ="";
        for (WebElement card : positions()){
            a = a+card.getText();
        }
        return a;
    }

    public void withdrawButton (String title){
        mouseOver(selectedPosition(title));
        click(positionCard(title));
        waitForDisappear(positionCard(title));
        getDriver().navigate().refresh();
    }

    public boolean isPositionWithdrawn (String title){
        getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        if (noPositions.isDisplayed()){
            return true;
        }
        if (confirmPosition().contains(title)){
            return true;
        } else {
            return false;
        }
    }
}
