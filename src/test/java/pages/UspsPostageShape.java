package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;

public class UspsPostageShape extends UspsHeader {

    @FindBy (xpath ="//input[@id='option_1']")
    private WebElement selectPostacrd;

    @FindBy (xpath ="//input[@id='option_2']")
    private WebElement selectEnvelope;

    @FindBy (xpath ="//input[@id='option_3']")
    private WebElement selectFlatRateBox;

    @FindBy (xpath ="//input[@id='option_4']")
    private WebElement selectCalculatePriceByBox;

    public void selectPostageByType (String shape){
        switch (shape){
            case("Postcard"):
                selectPostacrd.click();
                break;
            case ("Envelopes"):
                selectEnvelope.click();
                break;
            case"Flat Rate Boxes":
                selectFlatRateBox.click();
                break;
            case "Calculate price based on Shape and Size":
                selectCalculatePriceByBox.click();
        }
    }

    //dynamic element for shape

    private WebElement selectPostageByShape (String value){
        return getDriver().findElement(By.xpath("//input[@value=' " +value+"']"));
    }

}
