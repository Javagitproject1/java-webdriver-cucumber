package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;

public class UspsPiorityMailPage extends UspsHeader {

    private WebElement priorityMailOption(String str) {
        return getDriver().findElement(By.xpath("//span[contains(text(),'" + str + "')]"));
    }

    @FindBy (xpath = "//a[@class='button--primary']")
    private WebElement shipNow;

    public void selectPriorityMail (String option){
        priorityMailOption(option).click();
        waitForVisible(shipNow);
    }

    public void clickShipNow (){
        shipNow.click();
        String firstWindow = getDriver().getWindowHandle();
        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
        }
    }
}
