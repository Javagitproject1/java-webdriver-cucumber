package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.Keys.*;
import static support.TestContext.*;

public class MarketStepdefs {

    @Given("I go to {string} page")
    public void iGoToPage(String page) {
        getDriver().get(page);
    }

    @And("I print page details")
    public void iPrintPageDetails() {
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getCurrentUrl());
        System.out.println(getDriver().getWindowHandle());
        System.out.println(getDriver().getPageSource());
    }

    @And("I go back and forward, then refresh the page")
    public void iGoBackAndForwardThenRefreshThePage() {
        getDriver().navigate().back();
        getDriver().navigate().forward();
        getDriver().navigate().refresh();
    }

    @And("I change resolution to {string}")
    public void iChangeResolutionTo(String res) {
        if (res.equals("ipad")) {
            getDriver().manage().window().setSize(new Dimension(768, 1024));
        } else if (res.equals("desktop")) {
            getDriver().manage().window().setSize(new Dimension(2560, 1600));
        } else if (res.equals("iphone")) {
            getDriver().manage().window().setSize(new Dimension(320, 568));
        } else {
            getDriver().manage().window().maximize();
        }
    }

    @When("I fill in required fields for {string}")
    public void iFillInRequiredFieldsFor(String role) {
        Map<String, String> user = getData(role);

        getDriver().findElement(By.name("username")).sendKeys(user.get("username"));
        getDriver().findElement(By.name("email")).sendKeys(user.get("email"));
        getDriver().findElement(By.name("password")).sendKeys(user.get("password"));
        getDriver().findElement(By.name("confirmPassword")).sendKeys(user.get("password"));
        getDriver().findElement(By.id("name")).click();
        getDriver().findElement(By.name("firstName")).sendKeys(user.get("firstname"));
        getDriver().findElement(By.id("middleName")).sendKeys(user.get("middlename"));
        getDriver().findElement(By.name("lastName")).sendKeys(user.get("lastname"));
        getDriver().findElement(By.xpath("//*[@type='button']/span[text()='Save']")).click();
        getDriver().findElement(By.xpath("//input[@name='phone']")).sendKeys("6563421231");
        getDriver().findElement(By.xpath("//input[@id='dateOfBirth']")).click();
        getDriver().findElement(By.xpath("//*[@class='ui-datepicker-month']/option[@value='7']")).click();
        getDriver().findElement(By.xpath("//*[@class='ui-datepicker-year']/option[@value='1980']")).click();
        getDriver().findElement(By.xpath("//*[@class='ui-state-default'][text()='7']")).click();
        getDriver().findElement(By.xpath("//select[@name='countryOfOrigin']/option[@value='Canada']")).click();
        getDriver().findElement(By.xpath("//input[@name='gender'][@value='male']")).click();
        getDriver().findElement(By.xpath("//*[contains(text (),' I allow to contact me via email or phone')]")).click();
        getDriver().findElement(By.id("address")).sendKeys("767 5th Ave New York, NY, 10153, United States");
        getDriver().findElement(By.xpath("//*[@name='carMake']/option[@value='BMW']")).click();
        getDriver().findElement(By.xpath("//*[contains(text (),' I have read and accept Privacy Policy.')]")).click();

    }

    @And("I verify email field behavior for {string}")
    public void iVerifyEmailFieldBehaviorFor(String role) {
        Map<String, String> user = getData(role);
        getDriver().findElement(By.xpath("//input[@name='email']")).clear();
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("testuser1");
        getDriver().findElement(By.xpath("//input[@name='password']")).click();
        getDriver().findElement(By.xpath("//*[text ()= 'Please enter a valid email address.']")).isDisplayed();
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(BACK_SPACE);
        getDriver().findElement(By.xpath("//input[@name='email']")).clear();
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(user.get("email"));

    }

    @And("I {string} agreement")
    public void iAgreement(String alertAction) {

        getDriver().findElement(By.xpath("//*[@id='thirdPartyButton']")).click();
        if (alertAction.equals("accept")) {
            getDriver().switchTo().alert().accept();
        } else if (alertAction.equals("dismiss")) {
            getDriver().switchTo().alert().dismiss();
        } else {
            throw new RuntimeException("Incorrect action:" + alertAction);
        }
    }

    @And("I dismiss agreement with xpath {string}")
    public void iDismissAgreementWithXpath(String str) {
        getDriver().findElement(By.xpath(str)).click();
        getDriver().switchTo().alert().dismiss();

    }

    @Then("I submit the page")
    public void iSubmitThePage() {
        getDriver().findElement(By.id("formSubmit")).click();
    }


    @And("I verify that fields values are recorded correctly for {string}")
    public void iVerifyThatFieldsValuesAreRecordedCorrectlyFor(String role) {

        Map<String, String> user = getData(role);

        assertThat(getDriver().findElement(By.xpath("//legend[@class='applicationResult']")).isDisplayed());
        assertThat(getDriver().findElement(By.xpath("//b[@name='dateOfBirth']")).getText()).isEqualTo("08/07/1980");
        assertThat(getDriver().findElement(By.xpath("//b[@name='firstName']")).getText()).isEqualTo(user.get("firstname"));
        assertThat(getDriver().findElement(By.xpath("//b[@name='phone']")).getText()).isEqualTo("6563421231");
        assertThat(getDriver().findElement(By.xpath("//b[@name='username']")).getText()).isEqualTo(user.get("username"));
        assertThat(getDriver().findElement(By.xpath("//b[@name='middleName']")).getText()).isEqualTo(user.get("middlename"));
        assertThat(getDriver().findElement(By.xpath("//b[@name='address']")).getText()).isEqualTo("767 5th Ave New York, NY, 10153, United States");
        assertThat(getDriver().findElement(By.xpath("//b[@name='email']")).getText()).isEqualTo(user.get("email"));
        assertThat(getDriver().findElement(By.xpath("//b[@name='lastName']")).getText()).isEqualTo(user.get("lastname"));
        assertThat(getDriver().findElement(By.xpath("//b[@name='carMake']")).getText()).isEqualTo("BMW");
        assertThat(getDriver().findElement(By.xpath("//b[@name='password']")).getText()).isNotEqualTo(user.get("password"));
        assertThat(getDriver().findElement(By.xpath("//b[@name='name']")).getText()).isEqualTo(user.get("firstname") + " " + user.get("middlename") + " " + user.get("lastname"));
        assertThat(getDriver().findElement(By.xpath("//b[@name='agreedToPrivacyPolicy']")).getText()).isEqualTo("true");
        assertThat(getDriver().findElement(By.xpath("//b[@name='thirdPartyAgreement']")).getText()).isEqualTo("accepted");

        WebElement page = getDriver().findElement(By.xpath("//div[@id='quotePageResult']"));
        String quotePage = page.getText();
        System.out.println(quotePage);
    }

    @And("I print logs to console")
    public void iPrintLogsToConsole() {
        getDriver().manage().logs().get("browser");
    }


    @When("I click on {string}")
    public void iClickOn(String unit) {
        switch (unit) {
            case "Length":
                getDriver().findElement(By.xpath("//div[@id='menu']//*[contains(text (),'Length')]")).click();
                break;
            case "Temperature":
                getDriver().findElement(By.xpath("//div[@id='menu']//*[contains(text (),'Temperature')]")).click();
                break;
            case "Area":
                getDriver().findElement(By.xpath("//div[@id='menu']//*[contains(text (),'Area')]")).click();
                break;
            case "Volume":
                getDriver().findElement(By.xpath("//div[@id='menu']//*[contains(text (),'Volume')]")).click();
                break;
            case "Weight":
                getDriver().findElement(By.xpath("//div[@id='menu']//*[contains(text (),'Weight')]")).click();
                break;
            case "Time":
                getDriver().findElement(By.xpath("//div[@id='menu']//*[contains(text (),'Time')]")).click();
                break;
            default:
                throw new RuntimeException("Unsupported " + unit);
        }

    }

    @And("I convert from {string} to {string}")
    public void iConvertFromTo(String unitfrom, String unitto) {
        Select from = new Select(getDriver().findElement(By.xpath("//select[@id='calFrom']")));
        from.selectByVisibleText(unitfrom);

        Select to = new Select(getDriver().findElement(By.xpath("//select[@id='calTo']")));
        to.selectByVisibleText(unitto);

    }

    @Then("I enter value {string} and verify result is {string}")
    public void iEnterValueAndVerifyResult(String input, String output) {
        getDriver().findElement(By.xpath("//input [@name='fromVal']")).sendKeys(input);
        String result = getDriver().findElement(By.xpath("//div [@id='calResults']")).getText();
        assertThat(result).contains(output);
    }

    @When("I navigate to {string}")
    public void iNavigateTo(String str) {
        //Actions navigate = new Actions(getDriver());
        getActions().moveToElement(getDriver().findElement(By.xpath("//div [@id='homelistdiv']//*[contains(text(), '" + str + "')]"))).click().perform();

    }

    @And("I clear all calculator fields")
    public void iClearAllCalculatorFields() {
        getDriver().findElement(By.xpath("//input[@id='cloanamount']")).clear();
        getDriver().findElement(By.xpath("//input[@id='cloanterm']")).clear();
        getDriver().findElement(By.xpath("//input[@id='cinterestrate']")).clear();
        getDriver().findElement(By.xpath("//input[@id='cdownpayment']")).clear();
        getDriver().findElement(By.xpath("//input[@id='ctradeinvalue']")).clear();
        getDriver().findElement(By.xpath("//input[@id='csaletax']")).clear();
        getDriver().findElement(By.xpath("//input[@id='ctitlereg']")).clear();

    }

    @And("I calculate")
    public void iCalculate() {
        getDriver().findElement(By.xpath("//input[contains (@src, 'calculate.svg')]")).click();
    }

    @Then("I verify {string} calculator error")
    public void iVerifyCalculatorError(String error) {
        assertThat(getDriver().findElement(By.xpath("//a[@name='autoloanresult']//..//*[contains(text(),'" + error + "')]")).isDisplayed());
    }

    @And("I enter {string} price, {string} months, {string} interest, {string} down payment, {string} trade-in, {string} state, {string} percent tax, {string} fees")
    public void iEnterPriceMonthsInterestDownPaymentTradeInStatePercentTaxFees(String price, String term, String rate, String downp, String tradein, String state, String tax, String fees) {
        getDriver().findElement(By.xpath("//input[@id='cloanamount']")).sendKeys(price);
        getDriver().findElement(By.xpath("//input[@id='cloanterm']")).sendKeys(term);
        getDriver().findElement(By.xpath("//input[@id='cinterestrate']")).sendKeys(rate);
        getDriver().findElement(By.xpath("//input[@id='cdownpayment']")).sendKeys(downp);
        getDriver().findElement(By.xpath("//input[@id='ctradeinvalue']")).sendKeys(tradein);

        Select stateoption = new Select(getDriver().findElement(By.xpath("//select[@name='cstate']")));
        stateoption.selectByVisibleText(state);

        getDriver().findElement(By.xpath("//input[@id='csaletax']")).sendKeys(tax);
        getDriver().findElement(By.xpath("//input[@id='ctitlereg']")).sendKeys(fees);
    }

    @Then("I verify monthly pay is {string}")
    public void iVerifyMonthlyPayIs(String result) {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='h2result']")));
        assertThat(getDriver().findElement(By.xpath("//h2[@class='h2result']")).getText()).contains(result);
    }
}
