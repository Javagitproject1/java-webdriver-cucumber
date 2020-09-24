package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static support.TestContext.*;

public class UpsForm extends Page {
    //selectors

    public UpsForm() {
        url = "https://www.ups.com/us/en/Home.page";
        title = "Global Shipping & Logistics Services | UPS - United States";
    }

    @FindBy(xpath = "//a[@id='ups-menuLinks2']")
    private WebElement topMenu;

    @FindBy(xpath = "//a[@class='ups-analytics'][contains(text(),'Create a Shipment:')]")
    private WebElement menuOption;

    @FindBy(xpath = "//h2[contains(@class,'ups-section_heading ups-centered_header')]")
    private WebElement waitForHeaderToAppear;

    @FindBy(xpath = "//input[@id='originname']")
    private WebElement originName;

    @FindBy(xpath = "//input[@id='originaddress1']")
    private WebElement originAddress;

    @FindBy(xpath = "//input[@id='originpostal']")
    private WebElement originPostal;

    @FindBy(xpath = "//input[@id='origincity']")
    private WebElement originCity;

    @FindBy(xpath = "//select[@id='originstate']")
    private WebElement originState;

    @FindBy(xpath = "//input[@id='originemail']")
    private WebElement originEmail;

    @FindBy(xpath = "//input[@id='originphone']")
    private WebElement originPhone;

    @FindBy(xpath = "//button[contains (@class, 'ups-cta_primary')]")
    private WebElement continueButton;

    @FindBy(xpath = "//button[text()='Cancel Shipment']")
    private WebElement cancelButton;

    @FindBy(xpath = "//button[@id='nbsCancelShipmentWarningYes']")
    private WebElement popUpYes;

    public void openMenu() {
        topMenu.click();
    }

    public void openMenuOption() {
        menuOption.click();
    }

    public void waitForHeader() {
        getWait(7).until(ExpectedConditions.visibilityOf(waitForHeaderToAppear));
    }

    public void fillOriginName(String name) {
        originName.sendKeys(name);
    }

    public String fillOriginName() {
        return originName.getText();
    }

    public void fillOriginAddress(String address) {
        originAddress.sendKeys(address);
    }

    public String fillOriginAddress() {
        return originAddress.getText();
    }


    public void fillOriginPostal(String zip) {
        originPostal.sendKeys(zip);
    }

    public String fillOriginPostal() {
        return originPostal.getText();
    }

    public void fillOriginCity(String city) {
        originCity.sendKeys(city);
    }

    public String fillOriginCity() {
        return originCity.getText();
    }

    public void fillOriginState(String state) {
        Select stateOption = new Select(originState);
        stateOption.selectByVisibleText(state);
    }


    public String fillOriginState() {
        return originState.getText();
    }

    public void fillOriginEmail(String email) {
        originEmail.sendKeys(email);
    }

    public String fillOriginEmail() {
        return originEmail.getText();
    }

    public void fillOriginPhone(String phone) {
        originPhone.sendKeys(phone);
        getWait().until(ExpectedConditions.visibilityOf(originPhone));
    }

    public String fillOriginPhone() {
        return originPhone.getText();
    }


    public void clickSubmit() {
        getExecutor().executeScript("arguments[0].click();", continueButton);
    }

    public void clickCancel() {
        getExecutor().executeScript("arguments[0].click();", cancelButton);
    }

    public void clickYes() {
        getDriver().switchTo().activeElement();
        getExecutor().executeScript("arguments[0].click();", popUpYes);
    }
}
