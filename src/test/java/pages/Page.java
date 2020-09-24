package pages;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.servlet.annotation.WebListener;
import java.sql.SQLOutput;

import static support.TestContext.*;
import static support.TestContext.getWait;

public class Page {

    @FindBy(xpath = "//div[@class='white-spinner-container']")
    private WebElement spinner;

    //fields
    protected String url;
    protected String title;

    // constructor
    public Page() {
        PageFactory.initElements(getDriver(), this);
    }

    public void open() {
        getDriver().get(url);
    }

    protected void mouseOver (WebElement element) {
        getActions().moveToElement(element).perform();
    }

    protected void waitForVisible (WebElement element){
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForInVisible (WebElement element){
        getWait().until(ExpectedConditions.invisibilityOf(element));
    }

    protected void waitUntilContainsText (WebElement element){
        getWait().until(driver ->!element.getText().isEmpty());
    }

    protected void waitForElementIsClickable (WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void click (WebElement element){
        waitForElementIsClickable(element);
        try {
            element.click();
        } catch(ElementClickInterceptedException e){
            System.err.println("Failed to click element. Used JS to click");
            clickWithJs(element);
        }
    }

    protected void sendKeys (WebElement element, String value){
        waitForVisible(element);
        element.sendKeys(value);
    }
    protected void clickWithJs (WebElement element){
        getExecutor().executeScript("arguments [0].click();", element);
    }

    protected void waitToBeSelected (WebElement element){
        getWait().until(ExpectedConditions.elementToBeSelected(element));
    }

    protected void waitSpinnerDisappear (){
    getWait().until(ExpectedConditions.invisibilityOf(spinner));
    }
}
