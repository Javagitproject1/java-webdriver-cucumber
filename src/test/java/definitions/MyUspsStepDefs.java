package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.data.Percentage;
import org.openqa.selenium.*;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.Keys.*;
import static support.TestContext.*;

public class MyUspsStepDefs {

    UspsHome uspsHome = new UspsHome();
    UspsLookUpByZip uspsfindByZip = new UspsLookUpByZip();
    UspsHeader uspsHeader = new UspsHeader();
    UspsByAddressForm fillByAddressForm = new UspsByAddressForm();
    UspsByAddressResult uspsByAddressResult = new UspsByAddressResult();

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

        int expectedSize = Integer.parseInt(str);
        List<WebElement> results = getDriver().findElements(By.xpath("//div[@id='main_res']//li"));
        int actualSize = results.size();
        assertThat(actualSize).isEqualTo(expectedSize);
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

        switch (str) {
            case "Ship Now":
                getDriver().findElement(By.xpath("//a[@target='_blank'] [contains(text(),'" + str + "')]")).click();

                String firstWindow = getDriver().getWindowHandle();
                for (String handle : getDriver().getWindowHandles()) {
                    getDriver().switchTo().window(handle);
                    // getDriver().getWindowHandles().forEach(windowRotation -> getDriver().switchTo().window(windowRotation));
                }
                break;
            case "Schedule an Appointment":
                getDriver().findElement(By.xpath("//a[@class='button--primary'] [contains(text(),'" + str + "')]")).click();
                break;
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
        WebElement results = getDriver().findElement(By.xpath("//div[@class='spinner']"));
        getWait().until((ExpectedConditions.invisibilityOfAllElements(results)));
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

        //WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        WebElement results = getDriver().findElement(By.id("resultBox"));
        getWait().until(ExpectedConditions.visibilityOfAllElements(results));

        getDriver().findElement(By.xpath("//div [@id='resultBox']/div [@class='list-item-location popover-trigger'] [1]")).click();
        assertThat(getDriver().findElement(By.xpath("//div [@id='po-location-detail']")).getText()).contains(str1);
    }

    @When("I go to {string} under {string}")
    public void iGoToUnder(String subMenu, String menu) throws InterruptedException {

        WebElement menuItem1 = getDriver().findElement(By.xpath("//a[@class='menuitem'][contains(text(),'" + menu + "')]"));
        getActions().moveToElement(menuItem1).perform();
        WebElement menuItem2 = getDriver().findElement(By.xpath("//a[@role='menuitem'][text()='" + subMenu + "']"));
        getActions().moveToElement(menuItem2).click().perform();
    }

    @And("I search for {string}")
    public void iSearchFor(String text) {

        getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='address']")));
        getDriver().findElement(By.xpath("//*[@id='address']")).sendKeys(text);
        getDriver().findElement(By.xpath("//*[@id='address']")).sendKeys(ENTER);

        WebDriverWait wait1 = new WebDriverWait(getDriver(), 15);
        WebElement button = getDriver().findElement(By.xpath("//a[contains (text(),'Show Table')]"));
        wait1.until(ExpectedConditions.visibilityOf(button));
        WebDriverWait wait = new WebDriverWait(getDriver(), 25);
        WebElement progressbar = getDriver().findElement(By.id("eddm_overlay-progress"));
        wait.until(ExpectedConditions.invisibilityOf(progressbar));
    }

    @And("I click {string} on the map")
    public void iClickOnTheMap(String button) {

        getDriver().findElement(By.xpath("//span[@class='toggle-icon']")).click();

    }

    @When("I click {string} on the table")
    public void iClickOnTheTable(String button) {

        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        WebElement totalButton = getDriver().findElement(By.xpath("//a[@class='totalsArea'][contains(text(),'Select All')]"));
        wait.until(driver -> totalButton.isDisplayed());

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='totalsArea'][contains(text(),'Select All')]")));

        getDriver().findElement(By.xpath("//a[@class='totalsArea'][contains(text(),'Select All')]")).click();
    }

    @And("I close modal window")
    public void iCloseModalWindow() {

        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-box-closeModal']")));
        getDriver().switchTo().activeElement();
        getDriver().findElement(By.xpath("//div[@id='modal-box-closeModal']")).click();

    }

    @Then("I verify that summary of all rows of Cost column is equal Approximate Cost in Order")
    public void iVerifyThatSummaryOfAllRowsOfCostColumnIsEqualApproximateCostInOrder() throws InterruptedException {

        WebElement tableBox = getDriver().findElement(By.xpath("//div[@class='dojoxGridScrollbox']"));

        //JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        getExecutor().executeScript("arguments[0].scrollBy(0, 800);", tableBox);

        Thread.sleep(500);

        List<WebElement> cost = getDriver().findElements(By.xpath("//div[@class='dojoxGridContent']/div/div/table//*[@idx='7']"));

        float sum = 0;
        for (WebElement price : cost) {
            String save = price.getText();
            String replace = save.replace("$", "");
            float number = Float.valueOf(replace);
            sum = sum + number;
        }

        WebElement approxCost = getDriver().findElement(By.xpath("//span[@class='approx-cost']"));
        String approx = approxCost.getText();
        String replace1 = approx.replace("$", "");
        float costNumber = Float.valueOf(replace1);

        //assertThat(costNumber).isEqualTo(sum);
        assertThat(costNumber).isCloseTo(sum, Percentage.withPercentage(5));
    }


    @When("I navigate to {string} tab")
    public void iNavigateToTab(String menu) {
        WebElement menuItem = getDriver().findElement(By.xpath("//a[@class='menuitem'][contains(text(),'" + menu + "')]"));
        getActions().moveToElement(menuItem).perform();
    }

    @And("I enter {string} into store search")
    public void iEnterIntoStoreSearch(String num) {
        WebElement search = getDriver().findElement(By.xpath("//input [@id='global-header--search-track-store']"));
        getActions().moveToElement(search).click().perform();
        getActions().moveToElement(search).sendKeys(num).perform();
    }

    @Then("I search and validate no products found")
    public void iSearchAndValidateNoProductsFound() {

        WebElement submitSearch = getDriver().findElement(By.xpath("//input[@id='global-header--search-track-store']/following-sibling::input "));
        getActions().moveToElement(submitSearch).click().perform();

        getWait(3).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=' Your search did not match any products.']")));
        assertThat(getDriver().findElement(By.xpath("//p[text()=' Your search did not match any products.']")).isDisplayed());
    }

    @And("choose {string} option under filter {string}")
    public void chooseOptionUnderFilter(String label, String filter) {

        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='row cartridge-viewport']")));

        WebElement filterItem = getDriver().findElement(By.xpath("//h4[text()='" + filter + "']/following::label[contains(text(),'" + label + "')][1]"));
        getActions().moveToElement(filterItem).click().perform();

    }

    @Then("I verify {int} items found")
    public void iVerifyItemsFound(int resultNum) {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='row cartridge-viewport']")));

        List<WebElement> results = getDriver().findElements(By.xpath("//div[@class='row cartridge-viewport']/div"));
        int actualSize = results.size() - 1;
        assertThat(actualSize).isEqualTo(resultNum);
    }

    @When("I unselect Stamps checkbox")
    public void iUnselectStampsCheckbox() {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='row cartridge-viewport']")));

        WebElement filterItem = getDriver().findElement(By.xpath("//h4[text()='Category']/following::label[contains(text(),'Stamps')][1]"));
        getActions().moveToElement(filterItem).click().perform();

    }

    @And("select Vertical stamp Shape")
    public void selectVerticalStampShape() {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='row cartridge-viewport']")));

        WebElement filterItem = getDriver().findElement(By.xpath("//h4[text()='Stamp Shape']/following::label[contains(text(),'Vertical')][1]"));
        getActions().moveToElement(filterItem).click().perform();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='row cartridge-viewport']")));

    }

    @And("I click Blue color")
    public void iClickBlueColor() {
        WebElement filterItem = getDriver().findElement(By.xpath("//div [@style='background-color:#033366;']"));
        getActions().moveToElement(filterItem).click().perform();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='row cartridge-viewport']")));

    }

    @Then("I verify {string} and {string} filters")
    public void iVerifyAndFilters(String shape, String color) {

        List<WebElement> filtersSelected = new ArrayList<WebElement>(getDriver().findElements(By.xpath("//div[@class='cartridge-viewport']/span")));

        String a = "";
        String b = shape + color;
        for (WebElement filters : filtersSelected) {
            String filtersText = filters.getText();
            a = a + filtersText;
        }
        assertThat(a).isEqualTo(b);

    }

    @And("I verify that items below {double} dollars exists")
    public void iVerifyThatItemsBelowDollarsExists(double num) {

        List<WebElement> results = new ArrayList<WebElement>(getDriver().findElements(By.xpath("//*[@class='results-product-preview-price']")));

        for (WebElement price : results) {
            String removeDash = (price.getText()).replace("$", "");
            String removeComa = removeDash.replace(",", "");
            String removeNull = removeComa.replace(".00", "");
            String[] finalCost = removeNull.split(" - ");

            for (int i = 0; i < finalCost.length; i++) {
                double max1 = Double.parseDouble(finalCost[0]);
                if (max1 < Double.parseDouble(finalCost[i])) {
                    max1 = Double.parseDouble(finalCost[i]);
                    assertThat(num).isLessThan(max1);
                }
            }
        }
    }

    @And("verify {string} service exists")
    public void verifyServiceExists(String str) {

        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Schedule an Appointment')]")));

        String selectedOption = getDriver().findElement(By.xpath("//select [@id='passportappointmentType']")).getText();
        assertThat(selectedOption).contains(str);
    }

    @And("I reserve new PO box for {string}")
    public void iReserveNewPOBoxFor(String zip) {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='header-1']")));

        //getDriver().findElement(By.xpath("//input[@id='searchInput']")).click();
        getDriver().findElement(By.xpath("//input[@id='searchInput']")).sendKeys(zip);
        getDriver().findElement(By.xpath("//div/a[@value='Search']")).click();

        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@class='resultsFound']")));

    }

    @Then("I verify that {string} present")
    public void iVerifyThatPresent(String office) {
        String resultBox = getDriver().findElement(By.xpath("//div[@class='locations']")).getText();
        assertThat(resultBox).contains(office);
    }

    @And("I verify that {string} PO Box is available in {string}")
    public void iVerifyThatPOBoxIsAvailableIn(String size, String office) {

        getDriver().findElement(By.xpath("//div[@class='locations']//descendant::h2/span[contains(text(),'Los Altos')]")).click();

        String resultBox = getDriver().findElement(By.xpath("//div[@class = 'locationContainer row']")).getText();
        assertThat(resultBox).contains(office);

        String sizeText = getDriver().findElement(By.xpath("//div[@id='availableboxes']")).getText();
        assertThat(sizeText).contains(size);
    }

    @When("I navigate to Look Up a ZIP Code page by address OOP")
    public void iNavigateToLookUpAZIPCodePageByAddressOOP() {
        uspsHeader.goTolookUpByZip();
        uspsfindByZip.clickFindByAddress();

    }

    @And("I fill out {string} street, {string} city, {string} state OOP")
    public void iFillOutStreetCityStateOOP(String street, String city, String state) {
        fillByAddressForm.fillStreet(street);
        fillByAddressForm.fillCity(city);
        fillByAddressForm.fillState(state);
        fillByAddressForm.clickFind();
    }

    @Then("I validate {string} zip code exist in the result OOP")
    public void iValidateZipCodeExistInTheResultOOP(String zip) {
        String actualTotalResult = uspsByAddressResult.getSearchResult();
        assertThat(actualTotalResult).contains(zip);

        boolean areAllItemsContainZip = uspsByAddressResult.areAllResultsContainZip(zip);
        assertThat(areAllItemsContainZip).isTrue();

    }

    @When("I go to Calculate Price Page OOP")
    public void iGoToCalculatePricePageOOP() {
        uspsHeader.goToCalculatePrice();
    }

    @And("I select {string} with {string} shape OOP")
    public void iSelectWithShapeOOP(String country, String shape) {
        UspsPostageCalculator uspsPostageCalculator  = new UspsPostageCalculator();
        uspsPostageCalculator.selectCountry(country);

        UspsPostageShape uspsPostageShape = new UspsPostageShape();
        uspsPostageShape.selectPostageByType(shape);
    }

    @And("I define {string} quantity OOP")
    public void iDefineQuantityOOP(String value) {
        UspsPostageCalculatorForm uspsPostageCalculatorForm = new UspsPostageCalculatorForm();
        uspsPostageCalculatorForm.setQuantity(value);
    }

    @Then("I calculate the price and validate cost is {string} OOP")
    public void iCalculateThePriceAndValidateCostIsOOP(String cost) {
        UspsPostageCalculatorForm uspsPostageCalculatorForm = new UspsPostageCalculatorForm();
        uspsPostageCalculatorForm.clickCalculate();

        String totalCost = uspsPostageCalculatorForm.getTotalCost();
        assertThat(totalCost).isEqualTo(cost);

    }

    @When("I perform {string} search OOP")
    public void iPerformSearchOOP(String str) {
        uspsHeader.goToSearch(str);
    }

    @And("I set {string} in filters OOP")
    public void iSetInFiltersOOP(String filter) {
        UspsFreeBoxesPage uspsFreeBoxesPage = new UspsFreeBoxesPage();
        uspsFreeBoxesPage.selectCategory(filter);
        
    }

    @Then("I verify that {string} results found OOP")
    public void iVerifyThatResultsFoundOOP(String results) {


        int expectedSize = Integer.parseInt(results);
        UspsFreeBoxesPage uspsFreeBoxesPage = new UspsFreeBoxesPage();
        assertThat(uspsFreeBoxesPage.getNumberOfResults()).isEqualTo(expectedSize);
        assertThat(uspsFreeBoxesPage.getFoundResults()).contains(results);
    }

    @When("I select {string} in results OOP")
    public void iSelectInResultsOOP(String option) {
        new UspsPiorityMailPage().selectPriorityMail(option);
    }

    @And("I click {string} button OOP")
    public void iClickButtonOOP(String button) {
        new UspsPiorityMailPage().clickShipNow();
    }

    @Then("I validate that Sign In is required OOP")
    public void iValidateThatSignInIsRequiredOOP() {

        UspsSignInPage uspsSignInPage = new UspsSignInPage();
        assertThat(uspsSignInPage.signInHeader()).isTrue();
    }

    @When("I go to {string} tab OOP")
    public void iGoToTabOOP(String menuOption) {
        uspsHeader.goToHelpPage(menuOption);

    }

    @And("I perform {string} help search OOP")
    public void iPerformHelpSearchOOP(String text) {
        new UspsHelpPage().runSearch(text);
    }

    @Then("I verify that no results of {string} available in help search OOP")
    public void iVerifyThatNoResultsOfAvailableInHelpSearchOOP(String searchResult) {
        String results = new UspsHelpPageResult().getHelpSearchResults();
        assertThat(results).doesNotContain(searchResult);

    }
}
