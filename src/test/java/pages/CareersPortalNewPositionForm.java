package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CareersPortalNewPositionForm extends CareersPortalHeader{
    @FindBy (xpath = "//label[@for='positionTitle']/following-sibling::input[@type='text']")
    private WebElement positionTitle;

    @FindBy (xpath ="//label[@for='positionDescription']/following-sibling::textarea[@type='text']")
    private WebElement positionDescription;

    @FindBy (xpath = "//label[@for='positionAddress']/following-sibling::input[@type='text']")
    private WebElement positionAddress;

    @FindBy (xpath ="//label[@for='positionCity']/following-sibling::input[@type='text']")
    private WebElement positionCity;

    @FindBy (xpath = "//select [@class='form-control']")
    private WebElement positionState;

    @FindBy (xpath ="//label[@for='positionZip']/following-sibling::input[@type='text']")
    private WebElement positionZip;

    @FindBy (xpath = "//input[@id='positionDateOpen']")
    private WebElement positionDate;

    @FindBy (xpath = "//div[@class='react-datepicker__today-button']")
    private WebElement currentDate;

    @FindBy (xpath ="//button[@id='positionSubmit']")
    private WebElement positionSubmit;

    @FindBy (xpath = "//label[@for='positionAddress']/following-sibling::span[@type='text']")
    private WebElement address;

    @FindBy (xpath = "//label[@for='positionCity']/following-sibling::span[@type='text']")
    private WebElement city;

    @FindBy (xpath ="//span[@type='text']")
    private WebElement card;

    public void setTitle (String value){
        positionTitle.sendKeys(value);
    }

    public void setDescription (String value){
        positionDescription.sendKeys(value);
    }

    public void setAddress (String value){
        positionAddress.sendKeys(value);
    }

    public void setCity (String value){
        positionCity.sendKeys(value);
    }

    public void setState (String value){
        new Select(positionState).selectByVisibleText(value);
    }

    public void setZip (String value){
        positionZip.sendKeys(value);
    }

    public void setDate (){
        positionDate.clear();
        click(positionDate);
        click(currentDate);
    }

    public void submitPosition(){
        click(positionSubmit);
    }

    public void clearAddress(){
        waitForElementIsClickable(positionAddress);
        positionAddress.clear();
    }

    public void clearCity(){
        waitForElementIsClickable(positionCity);
        positionCity.clear();
    }

    public String getPositionAddress (){
        waitForVisible(address);
        return address.getText();
    }

    public String getPositionCity (){
        waitForVisible(city);
        return city.getText();
    }

    public String getCardInfo(){
        waitForAllVisible(card);
        return card.getText();
    }
}
