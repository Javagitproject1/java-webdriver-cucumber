package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.Keys.*;
import static support.TestContext.getDriver;
import static support.TestContext.initialize;

public class MarketStepdefs {
    private Object JSpinner;

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
        if (res.equals("phone")) {
            getDriver().manage().window().setSize(new Dimension(400, 800));
        } else if (res.equals("desktop")) {
            getDriver().manage().window().setSize(new Dimension(1024, 768));
        } else {
            getDriver().manage().window().maximize();
        }
    }

    @When("I fill in required fields")
    public void iFillInRequiredFields() {

        getDriver().findElement(By.name("username")).sendKeys("testuser1");
        getDriver().findElement(By.name("email")).sendKeys("testuser1@example.com");
        getDriver().findElement(By.name("password")).sendKeys("Qwerty1");
        getDriver().findElement(By.name("confirmPassword")).sendKeys("Qwerty1");
        getDriver().findElement(By.id("name")).click();
        getDriver().findElement(By.name("firstName")).sendKeys("Michael");
        getDriver().findElement(By.id("middleName")).sendKeys("Andrew");
        getDriver().findElement(By.name("lastName")).sendKeys("Jordon");
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

    @And("I verify email field behavior")
    public void iVerifyEmailFieldBehavior() {

        getDriver().findElement(By.xpath("//input[@name='email']")).clear();
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("testuser1");
        getDriver().findElement(By.xpath("//input[@name='password']")).click();
        getDriver().findElement(By.xpath("//*[text ()= 'Please enter a valid email address.']")).isDisplayed();
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(BACK_SPACE);
        getDriver().findElement(By.xpath("//input[@name='email']")).clear();
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("testuser1@example.com");

    }

    @And("I accept agreement with xpath {string}")
    public void iAcceptAgreementWithXpath(String str) {

        getDriver().findElement(By.xpath(str)).click();
        getDriver().switchTo().alert().accept();

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


    @And("I verify that fields values are recorded correctly")
    public void iVerifyThatFieldsValuesAreRecordedCorrectly() {

        assertThat(getDriver().findElement(By.xpath("//legend[@class='applicationResult']")).isDisplayed());
        assertThat(getDriver().findElement(By.xpath("//b[@name='dateOfBirth']")).getText()).isEqualTo("08/07/1980");
        assertThat(getDriver().findElement(By.xpath("//b[@name='firstName']")).getText()).isEqualTo("Michael");
        assertThat(getDriver().findElement(By.xpath("//b[@name='phone']")).getText()).isEqualTo("6563421231");
        assertThat(getDriver().findElement(By.xpath("//b[@name='username']")).getText()).isEqualTo("testuser1");
        assertThat(getDriver().findElement(By.xpath("//b[@name='middleName']")).getText()).isEqualTo("Andrew");
        assertThat(getDriver().findElement(By.xpath("//b[@name='address']")).getText()).isEqualTo("767 5th Ave New York, NY, 10153, United States");
        assertThat(getDriver().findElement(By.xpath("//b[@name='email']")).getText()).isEqualTo("testuser1@example.com");
        assertThat(getDriver().findElement(By.xpath("//b[@name='lastName']")).getText()).isEqualTo("Jordon");
        assertThat(getDriver().findElement(By.xpath("//b[@name='carMake']")).getText()).isEqualTo("BMW");
        assertThat(getDriver().findElement(By.xpath("//b[@name='password']")).getText()).isNotEqualTo("Qwerty1");
        assertThat(getDriver().findElement(By.xpath("//b[@name='name']")).getText()).isEqualTo("Michael Andrew Jordon");
        assertThat(getDriver().findElement(By.xpath("//b[@name='agreedToPrivacyPolicy']")).getText()).isEqualTo("true");
        assertThat(getDriver().findElement(By.xpath("//b[@name='thirdPartyAgreement']")).getText()).isEqualTo("accepted");

    }

    @And("I print logs to console")
    public void iPrintLogsToConsole() {

        getDriver().manage().logs().get("browser");
    }

    @When("I navigate to Look Up a ZIP Code page by address")
    public void iNavigateToLookUpAZIPCodePageByAddress() {

        Actions actions = new Actions(getDriver());
        actions.moveToElement(getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"))).perform();
        getDriver().findElement(By.xpath("//a[contains(@href,'ZipLookup')][text () = 'Look Up a ZIP Code']")).click();

        //getDriver().findElement(By.xpath("//a[@id='mail-ship-width']")).click();
        //getDriver().findElement(By.xpath("//h2[@class='header-2 center']//a[text()='Look Up a ZIP Code']")).click();

        WebDriverWait wait = new WebDriverWait(getDriver(), 3);
        WebElement result = getDriver().findElement(By.xpath("//a[text()='Find by Address']"));
        wait.until(ExpectedConditions.elementToBeClickable(result));
        getDriver().findElement(By.xpath("//a[text()='Find by Address']")).click();

    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String str1, String str2, String str3) {

        getDriver().findElement(By.id("tAddress")).sendKeys(str1);
        getDriver().findElement(By.id("tCity")).sendKeys(str2);

        Select optionSelect = new Select(getDriver().findElement(By.xpath("//select[@id='tState']")));
        optionSelect.selectByValue(str3);

        //getDriver().findElement(By.xpath("//select[@id='tState']//option[@value='" + str3 + "']")).click();

        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();

    }

    @Then("I validate {string} zip code exist in the result")
    public void iValidateZipCodeExistInTheResult(String str1) {

        WebDriverWait waitforresults = new WebDriverWait(getDriver(), 2);
        WebElement results = getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']"));
        waitforresults.until(ExpectedConditions.textToBePresentInElement(results, str1));

        assertThat(getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']")).getText()).contains(str1);

    }

    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePage() {

        Actions action = new Actions(getDriver());
        action.moveToElement(getDriver().findElement(By.xpath("//a[@href='#'] [text()='Quick Tools']"))).perform();
        getDriver().findElement(By.xpath("//li//*[contains(@src,'calculate_price')]")).click();

        WebDriverWait wait = new WebDriverWait(getDriver(), 2);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("CountryID")));

    }

    @And("I select {string} with {string} shape")
    public void iSelectWithShape(String str1, String str2) {

        str2 = "//input[@id='option_1']";
        Select option = new Select(getDriver().findElement(By.xpath("//select[@id='CountryID']")));
        option.selectByVisibleText(str1);

        getDriver().findElement(By.xpath(str2)).click();

        WebDriverWait wait = new WebDriverWait(getDriver(), 2);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("quantity-0")));
    }

    @And("I define {string} quantity")
    public void iDefineQuantity(String str) {
        getDriver().findElement(By.id("quantity-0")).sendKeys(str);
    }

    @Then("I calculate the price and validate cost is {string}")
    public void iCalculateThePriceAndValidateCostIs(String str) {

        getDriver().findElement(By.xpath("//input [@type='button']")).click();
        assertThat(getDriver().findElement(By.id("total")).getText()).isEqualTo(str);
    }

    @When("I perform {string} search")
    public void iPerformSearch(String str) {

        Actions actions = new Actions(getDriver());
        actions.moveToElement(getDriver().findElement(By.xpath("//a[@id='navsearch']//.."))).perform();
        getDriver().findElement(By.id("global-header--search-track-search")).click();
        getDriver().findElement(By.id("global-header--search-track-search")).sendKeys(str);
        getDriver().findElement(By.id("global-header--search-track-search")).sendKeys(ENTER);
        getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @And("I set {string} in filters")
    public void iSetInFilters(String str) {

        WebDriverWait wait = new WebDriverWait(getDriver(), 3);
        WebElement spinner = getDriver().findElement(By.xpath("//div[@class='white-spinner-container']"));
        wait.until(ExpectedConditions.invisibilityOf(spinner));
        getDriver().findElement(By.xpath("//div[@id='dyn_nav']//*[(text()='" + str + "')]")).click();
    }

    @Then("I verify that {string} results found")
    public void iVerifyThatResultsFound(String str) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 3);
        WebElement spinner = getDriver().findElement(By.xpath("//div[@class='white-spinner-container']"));
        wait.until(ExpectedConditions.invisibilityOf(spinner));
        assertThat(getDriver().findElement(By.xpath("//span [@ID='searchResultsHeading']")).getText()).contains(str + " results found for ");
    }

    @When("I select {string} in results")
    public void iSelectInResults(String str) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        WebElement spinner = getDriver().findElement(By.xpath("//div[@class='white-spinner-container']"));
        wait.until(ExpectedConditions.invisibilityOf(spinner));
        getDriver().findElement(By.xpath("//span[contains(text(),'" + str + "')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='button--primary']")));
    }

    @And("I click {string} button")
    public void iClickButton(String str) {

        getDriver().findElement(By.xpath("//a[@target='_blank'] [contains(text(),'" + str + "')]")).click();

        String currentWindowHandle = getDriver().getWindowHandle();
        for (String handle : getDriver().getWindowHandles()) {
            if (!currentWindowHandle.equals(handle)) {
                getDriver().switchTo().window(handle);
            }
        }
    }

    @Then("I validate that Sign In is required")
    public void iValidateThatSignInIsRequired() {

        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        WebElement signIn = getDriver().findElement(By.xpath("//h1 [@id='sign-in-to-your-account-header']"));
        wait.until(ExpectedConditions.textToBePresentInElement(signIn, "Sign In To Your Account"));

        assertThat(getDriver().findElement(By.xpath("//*[@id='btn-submit']")).isDisplayed());
    }

    @When("I go to {string} tab")
    public void iGoToTab(String str) {

        getDriver().findElement(By.xpath("//a [@class='menuitem'][text()='" + str + "']")).click();

        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        WebElement results = getDriver().findElement(By.xpath("//div[@class='spinner']"));
        wait.until(ExpectedConditions.invisibilityOfAllElements(results));
    }

    @And("I perform {string} help search")
    public void iPerformHelpSearch(String str) {

        getDriver().findElement(By.xpath("//input[@placeholder='Search for a topic']")).sendKeys(str);
        getDriver().findElement(By.xpath("//input[@placeholder='Search for a topic']")).sendKeys(ENTER);
    }

    @Then("I verify that no results of {string} available in help search")
    public void iVerifyThatNoResultsOfAvailableInHelpSearch(String str) {

        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2/*[contains (text (), 'Articles')]")));
        assertThat(getDriver().findElement(By.xpath("//div[@class='resultsWrapper']//*[contains(text(),'')]")).getText()).doesNotContain(str);

    }

    @When("I navigate to Find a USPS Location page")
    public void iNavigateToFindAUSPSLocationPage() {

        Actions actions = new Actions(getDriver());
        actions.moveToElement(getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"))).perform();
        getDriver().findElement(By.xpath("//a[contains(@href,'location')][text () = 'Find a USPS Location']")).click();

        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        WebElement location = getDriver().findElement(By.xpath("//h1[contains(text(),'Find Locations')]"));
        wait.until(ExpectedConditions.visibilityOf(location));
    }

    @And("I filter by {string} location types, {string} services, {string} available services")
    public void iFilterByLocationTypesServicesAvailableServices(String str1, String str2, String str3) {

        Actions action1 = new Actions(getDriver());
        action1.moveToElement(getDriver().findElement(By.xpath("//button [@id='post-offices-select']"))).click();
        action1.moveToElement(getDriver().findElement(By.xpath("//a [text () = '" + str1 + "'][@data-value='po']"))).click().perform();

        Actions action2 = new Actions(getDriver());
        action2.moveToElement(getDriver().findElement(By.xpath("//button [@id='service-type-select']"))).click();
        action2.moveToElement(getDriver().findElement(By.xpath("//a [text () = '" + str2 + "'][@data-value='pickup']"))).click().perform();

        Actions action3 = new Actions(getDriver());
        action3.moveToElement(getDriver().findElement(By.xpath("//button [@id='available-service-select']"))).click();
        action3.moveToElement(getDriver().findElement(By.xpath("//a [text () = '" + str3 + "'][@data-value='accountable']"))).click().perform();

    }

    @And("I provide data as {string} street, {string} city, {string} state")
    public void iProvideDataAsStreetCityState(String str1, String str2, String str3) {

        getDriver().findElement(By.xpath("//input [@id='search-input']")).click();

        Actions action1 = new Actions(getDriver());
        action1.moveToElement(getDriver().findElement(By.xpath("//input [@id='search-input']"))).click().perform();

        getDriver().switchTo().activeElement();

        Actions action2 = new Actions(getDriver());
        action2.moveToElement(getDriver().findElement(By.xpath("//input [@id = 'addressLineOne']"))).perform();
        getDriver().findElement(By.xpath("//input [@id = 'addressLineOne']")).click();
        getDriver().findElement(By.xpath("//input [@id = 'addressLineOne']")).sendKeys(str1);

        Actions action3 = new Actions(getDriver());
        action3.moveToElement(getDriver().findElement(By.xpath("//input [@id = 'cityOrZipCode']"))).perform();
        getDriver().findElement(By.xpath("//input [@id = 'cityOrZipCode']")).click();
        getDriver().findElement(By.xpath("//input [@id = 'cityOrZipCode']")).sendKeys(str2);

        Select option = new Select(getDriver().findElement(By.xpath("//select[@id='servicesStateSelect']")));
        option.selectByValue(str3);

        getDriver().findElement(By.xpath("//a [@class = 'btn-primary'] [text () = 'Go to Results']")).click();

    }

    @Then("I verify phone number is {string}")
    public void iVerifyPhoneNumberIs(String str1) {

        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        WebElement results = getDriver().findElement(By.id("resultBox"));
        wait.until(ExpectedConditions.visibilityOfAllElements(results));

        getDriver().findElement(By.xpath("//div [@id='resultBox']/div [@class='list-item-location popover-trigger'] [1]")).click();
        assertThat(getDriver().findElement(By.xpath("//div [@id='po-location-detail']")).getText()).contains(str1);
    }

    @When("I click on {string}")
    public void iClickOn(String unit)  {
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
    public void iConvertFromTo(String unitfrom, String unitto)  {
        Select from = new Select(getDriver().findElement(By.xpath("//select[@id='calFrom']")));
        from.selectByVisibleText(unitfrom);

        Select to = new Select(getDriver().findElement(By.xpath("//select[@id='calTo']")));
        to.selectByVisibleText(unitto);

    }

    @Then("I enter value {string} and verify result")
    public void iEnterValueAndVerifyResult(String value)  {
        getDriver().findElement(By.xpath("//input [@name='fromVal']")).sendKeys(value);
        WebElement result = getDriver().findElement(By.xpath("//div [@id='calResults']"));
        assertThat(result.isDisplayed());
        System.out.println(result.getText());
    }

    @When("I navigate to {string}")
    public void iNavigateTo(String str) {
        Actions navigate = new Actions(getDriver());
        navigate.moveToElement(getDriver().findElement(By.xpath("//div [@id='homelistdiv']//*[contains(text(), '" + str + "')]"))).click().perform();

    }

    @And("I clear all calculator fields")
    public void iClearAllCalculatorFields()  {
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
        assertThat(getDriver().findElement(By.xpath("//h2[@class='h2result']")).getText()).contains(result);
    }

    @When("I go to {string} under {string}")
    public void iGoToUnder(String option, String menu) {
        Actions navigate = new Actions(getDriver());
        navigate.moveToElement(getDriver().findElement(By.xpath("//a[@href= 'https://www.usps.com/business/']"))).perform();
        getDriver().findElement(By.xpath("//a[@href= 'https://eddm.usps.com/eddm/customer/routeSearch.action']")).click();

        WebDriverWait wait = new WebDriverWait(getDriver(), 25);
        //WebElement eddm = getDriver().findElement(By.xpath("//h1[text()=' Every Door Direct Mail']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()=' Every Door Direct Mail']")));
    }

    @And("I search for {string}")
    public void iSearchFor(String text) throws InterruptedException {

        getDriver().findElement(By.xpath("//*[@id='address']")).sendKeys(text);
        getDriver().findElement(By.xpath("//*[@id='address']")).sendKeys(ENTER);

        Thread.sleep(10000);
//        WebDriverWait wait = new WebDriverWait(getDriver(),10);
//        getDriver().switchTo().frame("");
//        WebElement progressbar = getDriver().findElement(By.xpath("//div[@id='USPS.EDDM.mapPane']"));
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("eddm_overlay-progress")));
//        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("eddm_overlay-progress']")));
    }

    @And("I click {string} on the map")
    public void iClickOnTheMap(String button) {
        getDriver().findElement(By.xpath("//a[contains (text(),'" + button + "')]")).click();
    }

    @When("I click {string} on the table")
    public void iClickOnTheTable(String button) {

        Actions select = new Actions(getDriver());
        select.moveToElement(getDriver().findElement(By.xpath("//a[@class='totalsArea'][contains(text(),'Select All')]"))).click().perform();
        //getDriver().findElement(By.xpath("//a[@class='totalsArea'][contains(text(),'Select All')]")).click();
    }

    @And("I close modal window")
    public void iCloseModalWindow() {
        getDriver().switchTo().activeElement();
        getDriver().findElement(By.xpath("//div[@id='modal-box-closeModal']")).click();
    }

    @Then("I verify that summary of all rows of Cost column is equal Approximate Cost in Order")
    public void iVerifyThatSummaryOfAllRowsOfCostColumnIsEqualApproximateCostInOrder() {


    }
}
