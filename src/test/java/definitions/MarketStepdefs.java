package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import support.TestContext;

import javax.sound.midi.Soundbank;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;
import static support.TestContext.initialize;

public class MarketStepdefs {
    @Given("I go to {string} page")
    public void iGoToPage(String page) throws InterruptedException {
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
    public void iChangeResolutionTo(String res) throws InterruptedException {
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
    public void iVerifyEmailFieldBehavior() throws InterruptedException {

        getDriver().findElement(By.xpath("//input[@name='email']")).clear();
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("testuser1");
        getDriver().findElement(By.xpath("//input[@name='password']")).click();
        getDriver().findElement(By.xpath("//*[text ()= 'Please enter a valid email address.']")).isDisplayed();
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(Keys.BACK_SPACE);
        getDriver().findElement(By.xpath("//input[@name='email']")).clear();
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("testuser1@example.com");

    }

    @And("I accept agreement with xpath {string}")
    public void iAcceptAgreementWithXpath(String str) throws InterruptedException {

        getDriver().findElement(By.xpath(str)).click();
        getDriver().switchTo().alert().accept();

    }

    @And("I dismiss agreement with xpath {string}")
    public void iDismissAgreementWithXpath(String str) throws InterruptedException {
        getDriver().findElement(By.xpath(str)).click();
        getDriver().switchTo().alert().dismiss();


    }

    @Then("I submit the page")
    public void iSubmitThePage() throws InterruptedException {

        getDriver().findElement(By.id("formSubmit")).click();
    }


    @And("I verify that fields values are recorded correctly")
    public void iVerifyThatFieldsValuesAreRecordedCorrectly() throws InterruptedException {

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

        Thread.sleep(2000);

    }

    @Given("I create my own method")
    public void iCreateMyOwnMethod() {

        System.out.println("Coding challenges: >>>>>>>");
    }

    @Given("I swap {int} and {int} element in the array")
    public void iSwapAndElementInTheArray(int elm1, int elm2) {

        int[] numbers = {5, 2, 9, 7, 3};

        //First method
        int temp = numbers [elm1-1];
        numbers [elm1-1]=numbers [elm2-1];
        numbers [elm2-1]=temp;
        for (int array : numbers){
            System.out.print(array + " ");
        }

        //Second method
        int temp1 = elm1;
        elm1 = elm2;
        elm2 = temp1;
        for (int i = elm1; i <= numbers.length; i=i+elm1) {
            System.out.println(numbers[i - 1]);
        }
        for (int j = elm2; j <= numbers.length; j=j+elm2) {
            System.out.println(numbers[j - 1]);
        }
    }

    @Given("I have entered number {int}")
    public void iHaveEnteredNumber(int num1) {

        if (num1 % 3 == 0 && num1 % 4 == 0) {
            System.out.println("divisible by 3 and 4");
        } else if (num1 % 3 == 0) {
            System.out.println("divisible by 3");
        } else if (num1 % 4 == 0) {
            System.out.println("divisible by 4");
        } else {
            System.out.println("not divisible by 3 or 4");
        }
    }

    @And("I print logs to console")
    public void iPrintLogsToConsole() {

        getDriver().manage().logs().get("browser");
    }

    @When("I navigate to Look Up a ZIP Code page by address")
    public void iNavigateToLookUpAZIPCodePageByAddress() throws InterruptedException {
        getDriver().findElement(By.xpath("//a[@id='mail-ship-width']")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//h2[@class='header-2 center']//a[text()='Look Up a ZIP Code']")).click();
        getDriver().findElement(By.xpath("//a[text()='Find by Address']")).click();
    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String str1, String str2, String str3) throws InterruptedException {

        getDriver().findElement(By.id("tAddress")).sendKeys(str1);
        getDriver().findElement(By.id("tCity")).sendKeys(str2);
        getDriver().findElement(By.xpath("//select[@id='tState']//option[@value='" + str3 + "']")).click();
        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();
        Thread.sleep(2000);


    }

    @Then("I validate {string} zip code exist in the result")
    public void iValidateZipCodeExistInTheResult(String str1) throws InterruptedException{

        assertThat(getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']")).getText()).contains(str1);

        Thread.sleep(1000);
    }
}
