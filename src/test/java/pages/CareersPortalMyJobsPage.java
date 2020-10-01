package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CareersPortalMyJobsPage extends CareersPortalHeader {

    private List<WebElement> positions (){
        return getAllByXpath("//div [@style='position: relative;']/li/span/a/div/h4");
    }
    @FindBy (xpath = "//div [@style='position: relative;']/li/span/a/div/h4")
    private WebElement position;

    public String confirmPosition (){
        waitForVisible(position);
        String a ="";
        for (WebElement card : positions()){
            a = a+card.getText();
        }
        return a;
    }
}
