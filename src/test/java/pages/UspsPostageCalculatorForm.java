package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UspsPostageCalculatorForm extends UspsHeader {
    @FindBy (xpath = "//input[@id='quantity-0']")
    private WebElement quantity;

    @FindBy (xpath = "//input [@type='button']")
    private WebElement calculatePrice;

    @FindBy (xpath = "//div[@id='total']")
    private WebElement totalCost;

    public void setQuantity (String value){
        quantity.sendKeys(value);
    }

    public void clickCalculate (){
        calculatePrice.click();
    }

    public String getTotalCost (){
        return totalCost.getText();
    }
}
