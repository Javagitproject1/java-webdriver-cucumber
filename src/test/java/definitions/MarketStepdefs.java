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

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;
import static support.TestContext.initialize;

public class MarketStepdefs {
    @Given("I go to {string} page")
    public void iGoToPage(String page) throws InterruptedException {
        getDriver().get(page);
        Thread.sleep(1000);
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
        Thread.sleep(3000);
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
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//input[@name='email']")).clear();
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("testuser1@example.com");
        Thread.sleep(2000);

    }

    @And("I accept agreement with xpath {string}")
    public void iAcceptAgreementWithXpath(String str) throws InterruptedException {

        getDriver().findElement(By.xpath(str)).click();
        Thread.sleep(1000);
        getDriver().switchTo().alert().accept();

    }

    @And("I dismiss agreement with xpat {string}")
    public void iDismissAgreementWithXpat(String str) throws InterruptedException {
        getDriver().findElement(By.xpath(str)).click();
        Thread.sleep(1000);
        getDriver().switchTo().alert().dismiss();


    }

    @Then("I submit the page")
    public void iSubmitThePage() throws InterruptedException {

        getDriver().findElement(By.id("formSubmit")).click();

        Thread.sleep(2000);
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

}
