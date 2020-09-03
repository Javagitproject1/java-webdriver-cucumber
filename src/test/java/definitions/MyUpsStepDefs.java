package definitions;

import cucumber.api.java8.En;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.data.Percentage;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.TestContext;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.sql.Time;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.FLOAT;
import static org.openqa.selenium.Keys.*;
import static support.TestContext.*;

public class MyUpsStepDefs {
    private Object JSpinner;

    @And("I go to Shipping menu")
    public void IGoToShippingMenu() {
        getDriver().findElement(By.xpath("//a[@id='ups-menuLinks2']")).click();
        getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='ups-analytics'][contains(text(),'Create a Shipment:')]")));

    }

    @And("I go to Create a Shipment")
    public void iGoToCreateAShipment() {
        getDriver().findElement(By.xpath("//a[@class='ups-analytics'][contains(text(),'Create a Shipment:')]")).click();

    }

    @When("I fill out origin shipment form from {string}")
    public void iFillOutOriginShipmentFormFrom(String data) {
        //String header = getDriver().findElement(By.xpath("//h2[contains(@class,'ups-section_heading ups-centered_header')]")).getText();
        getWait(5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(@class,'ups-section_heading ups-centered_header')]")));

        Map<String, String> form = getData(data);

        getDriver().findElement(By.xpath("//input[@id='originname']")).sendKeys(form.get("name"));
        getDriver().findElement(By.xpath("//input[@id='originaddress1']")).sendKeys(form.get("address"));
        getDriver().findElement(By.xpath("//input[@id='originpostal']")).sendKeys(form.get("zip"));
        getDriver().findElement(By.xpath("//input[@id='origincity']")).sendKeys(form.get("city"));

        Select state = new Select(getDriver().findElement(By.xpath("//select[@id='originstate']")));
        state.selectByVisibleText(form.get("state"));
        getDriver().findElement(By.xpath("//input[@id='originemail']")).sendKeys(form.get("email"));
        getDriver().findElement(By.xpath("//input[@id='originphone']")).sendKeys(form.get("phone"));

        String getCityName = getDriver().findElement(By.xpath("//input[@id='origincity']")).getText();
        getWait().until(ExpectedConditions.textToBePresentInElementValue(By.xpath("//input[@id='origincity']"), getCityName));

    }

    @And("I submit the shipment form")
    public void iSubmitTheShipmentForm() {
        getDriver().findElement(By.xpath("//button[contains (@class, 'ups-cta_primary')]")).sendKeys(DOWN);
        getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains (@class, 'ups-cta_primary')]")));
        WebElement submit = getDriver().findElement(By.xpath("//button[contains (@class, 'ups-cta_primary')]"));
        getExecutor().executeScript("arguments[0].click();", submit);

    }

    @Then("I verify origin shipment fields submitted according to {string}")
    public void iVerifyOriginShipmentFieldsSubmittedAccordingTo(String verifyData) {
        getWait(5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(@class,'ups-section_heading ups-centered_header')]")));

        Map<String, String> form = getData(verifyData);

        assertThat(getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryName']")).getText()).isEqualTo(form.get("name"));
        assertThat(getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryAddressLine1']")).getText()).isEqualTo(form.get("address"));
        assertThat(getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryCity']")).getText()).isEqualTo(form.get("city"));
        assertThat(getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryState']")).getText()).containsIgnoringCase(form.get("shortstate"));
        assertThat(getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryPostalCode']")).getText()).isEqualTo(form.get("zip"));
        assertThat(getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryEmail']")).getText()).isEqualTo(form.get("email"));
        assertThat(getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryPhone']")).getText()).isEqualTo(form.get("phone"));


    }

    @And("I cancel the shipment form")
    public void iCancelTheShipmentForm() {
        WebElement cancel = getDriver().findElement(By.xpath("//button[text()='Cancel Shipment']"));
        getExecutor().executeScript("arguments[0].click();", cancel);
        getDriver().switchTo().activeElement();
        getDriver().findElement(By.xpath("//button[@id='nbsCancelShipmentWarningYes']")).click();

    }

    @Then("I verify shipment form is reset")
    public void iVerifyShipmentFormIsReset() {

        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='originname']")));
        assertThat(getDriver().findElement(By.xpath("//input[@id='originname']")).getText()).isEmpty();
        assertThat(getDriver().findElement(By.xpath("//input[@id='originaddress1']")).getText()).isEmpty();
        assertThat(getDriver().findElement(By.xpath("//input[@id='originpostal']")).getText()).isEmpty();
        assertThat(getDriver().findElement(By.xpath("//input[@id='origincity']")).getText()).isEmpty();
        assertThat(getDriver().findElement(By.xpath("//select[@id='originstate']")).getAttribute("value")).isEqualTo("0: null");
        assertThat(getDriver().findElement(By.xpath("//input[@id='originemail']")).getText()).isEmpty();
        assertThat(getDriver().findElement(By.xpath("//input[@id='originphone']")).getText()).isEmpty();
    }

    @When("I fill out destination shipment fields from {string}")
    public void iFillOutDestinationShipmentFieldsFrom(String user) {

        Map<String, String> userData = getData(user);
        getDriver().findElement(By.xpath("//input[@id='destinationname']")).sendKeys(userData.get("firstname") + " " + userData.get("lastname"));
        getDriver().findElement(By.xpath("//input[@id='destinationaddress1']")).sendKeys(userData.get("address"));
        getDriver().findElement(By.xpath("//input[@id='destinationpostal']")).sendKeys(userData.get("zip"));
        getDriver().findElement(By.xpath("//input[@id='destinationcity']")).sendKeys(userData.get("city"));

        Select state = new Select(getDriver().findElement(By.xpath("//select[@id='destinationstate']")));
        state.selectByVisibleText(userData.get("state"));

        String getCityName = getDriver().findElement(By.xpath("//input[@id='destinationcity']")).getText();
        getWait().until(ExpectedConditions.textToBePresentInElementValue(By.xpath("//input[@id='destinationcity']"), getCityName));

    }

    @Then("I set packaging type {string} and weight {string}")
    public void iSetPackagingTypeAndWeight(String type, String weight) {


        getWait(2).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='shipByWeight shippingBox']/div/span[@class='simpleRadioOuter']")));

        WebElement shipping = getDriver().findElement(By.xpath("//div[@class='shipByWeight shippingBox']/div/span[@class='simpleRadioOuter']"));
        getExecutor().executeScript("arguments[0].click();", shipping);


        getWait(5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='nbsPackagePackageLengthField0']")));
        //getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input [@id='nbsPackagePackageWeightField0']")));


        Select option = new Select(getDriver().findElement(By.xpath("//select[@name='nbsPackagePackagingTypeDropdown0']")));
        option.selectByVisibleText(type);

        WebElement weightField = getDriver().findElement(By.xpath("//input [@id='nbsPackagePackageWeightField0']"));
        getActions().moveToElement(weightField).click().perform();
        getActions().moveToElement(weightField).sendKeys(weight).perform();


    }

    @Then("I verify total charges appear")
    public void iVerifyTotalChargesAppear() {

        getWait(5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(@class,'ups-section_heading ups-centered_header')]")));

        getWait(5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='nbsBalanceBarContainer']")));

        assertThat(getDriver().findElement(By.xpath("//div[@id='nbsBalanceBarContainer']")).isDisplayed());
    }

    @And("I select cheapest delivery option")
    public void iSelectCheapestDeliveryOption() {

        WebElement cheapest = getDriver().findElement(By.xpath("//input[@id='nbsServiceTileServiceRadio7']"));
        getExecutor().executeScript("arguments[0].click();", cheapest);

    }

    @And("I set description {string} and check Saturday Delivery type")
    public void iSetDescriptionAndCheckSaturdayDeliveryType(String description) {

        getWait(5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(@class,'ups-section_heading ups-centered_header')]")));

        getWait(5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input [@id='nbsShipmentDescription']")));
        getDriver().findElement(By.xpath("//input [@id='nbsShipmentDescription']")).sendKeys(description);

        WebElement deliveryOption = getDriver().findElement(By.xpath("//input[contains (@id, 'SaturdayDelivery')]"));
        getExecutor().executeScript("arguments[0].click();", deliveryOption);


    }


    @Then("I verify total charges changed")
    public void iVerifyTotalChargesChanged() {

        WebElement deliveryOptionUnClick = getDriver().findElement(By.xpath("//input[contains (@id, 'SaturdayDelivery')]"));
        getExecutor().executeScript("arguments[0].click();", deliveryOptionUnClick);

        getWait(3).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[contains(@src, 'ajax-loader')]")));

        WebElement totalBefore = getDriver().findElement(By.xpath("//span[@id='total-charges-spinner']"));
        String saveNum1 = totalBefore.getText();
        String replace = saveNum1.replace("$", "");
        float number = Float.parseFloat(replace);


        WebElement deliveryOptionClick = getDriver().findElement(By.xpath("//input[contains (@id, 'SaturdayDelivery')]"));
        getExecutor().executeScript("arguments[0].click();", deliveryOptionClick);

        getWait(3).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[contains(@src, 'ajax-loader')]")));

        WebElement totalAfter = getDriver().findElement(By.xpath("//span[@id='total-charges-spinner']"));
        String saveNum2 = totalAfter.getText();
        String replace1 = saveNum2.replace("$", "");
        float number1 = Float.parseFloat(replace1);

        assertThat(number1).isNotEqualTo(number);

    }

    @And("I select Paypal payment type")
    public void iSelectPaypalPaymentType() {

        getWait(5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label [@for='other-ways-to-pay-tile']")));
        WebElement payPal = getDriver().findElement(By.xpath("//label [@for='other-ways-to-pay-tile']"));
        getExecutor().executeScript("arguments[0].click();", payPal);

    }

    @Then("I review all recorded details from {string} and to {string} on the review page")
    public void iReviewAllRecordedDetailsFromAndToOnTheReviewPage(String verifyFrom, String verifyTo) {

        getWait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span [@id='destinationDrawerCircleIndicator']")));
        Map<String, String> form = getData(verifyFrom);

        assertThat(getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryName']")).getText()).isEqualTo(form.get("name"));
        assertThat(getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryAddressLine1']")).getText()).isEqualTo(form.get("address"));
        assertThat(getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryCity']")).getText()).isEqualTo(form.get("city"));
        assertThat(getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryState']")).getText()).containsIgnoringCase(form.get("shortstate"));
        assertThat(getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryPostalCode']")).getText()).isEqualTo(form.get("zip"));
        assertThat(getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryEmail']")).getText()).isEqualTo(form.get("email"));
        assertThat(getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryPhone']")).getText()).isEqualTo(form.get("phone"));

        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='destinationnbsAgentSummaryName']")));

        Map<String, String> to = getData(verifyTo);

        assertThat(getDriver().findElement(By.xpath("//span[@id='destinationnbsAgentSummaryName']")).getText()).isEqualTo(to.get("firstname") + " " + to.get("lastname"));
        assertThat(getDriver().findElement(By.xpath("//span[@id='destinationnbsAgentSummaryAddressLine1']")).getText()).containsIgnoringCase(to.get("address"));
        assertThat(getDriver().findElement(By.xpath("//span[@id='destinationnbsAgentSummaryCity']")).getText()).containsIgnoringCase(to.get("city"));
        assertThat(getDriver().findElement(By.xpath("//span[@id='destinationnbsAgentSummaryState']")).getText()).containsIgnoringCase(to.get("shortstate"));
        assertThat(getDriver().findElement(By.xpath("//span[@id='destinationnbsAgentSummaryPostalCode']")).getText()).isEqualTo(to.get("zip"));

    }
}
