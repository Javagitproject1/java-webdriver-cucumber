package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.QuoteForm;
import pages.QuoteResults;
import pages.UpsForm;

import java.util.Map;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;

public class QuoteStepDefs {

    QuoteForm form = new QuoteForm();
    QuoteResults results = new QuoteResults();

    @When("I fill out required fields for {string} oop")
    public void iFillOutRequiredFieldsForOop(String role) {
        Map<String, String> user = getData(role);
        form.fillUsername(user.get("username"));
        form.fillEmail(user.get("email"));
        form.fillPasswords(user.get("password"));
        form.fillName(user.get("firstname"), user.get("middlename"), user.get("lastname"));
        form.setPrivacyPolicy();
    }

    @Then("I submit the form")
    public void iSubmitTheForm() {
        form.submit();
    }

    @And("I verify results for {string}")
    public void iVerifyResultsFor(String role) {
        Map<String, String> user = getData(role);

        assertThat(results.userName()).isEqualTo(user.get("username"));
        assertThat(results.email()).isEqualTo(user.get("email"));
        assertThat(results.firstName()).isEqualTo(user.get("firstname"));
        assertThat(results.lastName()).isEqualTo(user.get("lastname"));
        assertThat(results.middleName()).isEqualTo(user.get("middlename"));
        assertThat(results.password()).isNotEqualTo(user.get("password"));
        assertThat(results.agreedToPrivacyPolicy()).isTrue();
    }

    @When("I fill out optional fields for {string} oop")
    public void iFillOutOptionalFieldsForOop(String role) {
        Map<String, String> user = getData(role);
        form.phone(user.get("phone"));
        form.birthdate();
        form.dobInfo(user.get("month"), user.get("year"));
        form.countryOfOrigin(user.get("country"));
        form.genderValue();
        form.carMake(user.get("car"));
        form.address(user.get("address"));
        form.fillAdditionalInfo(user.get("contactpersonname"), user.get("contactpersonphone"));

    }

    @Then("I verify optional fields for {string} oop")
    public void iVerifyOptionalFieldsForOop(String role) {
        Map<String, String> user = getData(role);

        assertThat(results.carMake()).isEqualTo(user.get("car"));
        assertThat(results.phone()).isEqualTo(user.get("phone"));
        assertThat(results.gender()).isEqualTo(user.get("gender"));
        assertThat(results.address()).isEqualTo(user.get("address"));
        assertThat(results.country()).isEqualTo(user.get("country"));
        assertThat(results.contactPersonPhone()).isEqualTo(user.get("contactpersonphone"));
        assertThat(results.contactPersonName()).isEqualTo(user.get("contactpersonname"));

    }

    @Then("I see {string} error message {string}")
    public void iSeeErrorMessage(String errorField, String errorMessage) {


        switch (errorField) {
            case "username":
                assertThat(form.getUserNameError()).isEqualTo(errorMessage);
                break;
            case "email":
                assertThat(form.getEmailError()).isEqualTo(errorMessage);
                break;
            case "password":
                assertThat(form.getPasswordError()).isEqualTo(errorMessage);
                break;
            case "name":
                assertThat(form.getNameError()).isEqualTo(errorMessage);
                break;
            case "agreedToPrivacyPolicy":
                assertThat(form.getPrivacyPolicyError()).isEqualTo(errorMessage);
                break;
            case "confirmPassword":
                assertThat(form.getConfirmedPasswordError()).isEqualTo(errorMessage);
                break;
            default:
                System.out.println("no such field");
        }


    }

    @When("I fill out {string} field with {string}")
    public void iFillOutFieldWith(String field, String value) {

        switch (field) {
            case "username":
                form.fillUsername(value);
                break;
            case "email":
                form.fillEmail(value);
                break;
            case "password":
                form.fillPasswordOnly(value);
                break;
            case "confirmPassword":
                form.fillConfirmedPasswordOnly(value);
                break;
            default:
                System.out.println("no such field");
        }

    }

    @Then("I don't see {string} error message")
    public void iDonTSeeErrorMessage(String field) {
        switch (field) {
            case "username":
                assertThat(form.getUserNameError()).isEmpty();
                break;
            case "email":
                assertThat(form.getEmailError()).isEmpty();
                break;
            case "password":
                assertThat(form.getPasswordError()).isEmpty();
                break;
            case "confirmPassword":
                assertThat(form.getPasswordError()).isEmpty();
                break;
            default:
                System.out.println("Unsupported field");
        }

    }

    @Then("I clear field {string}")
    public void iClearField(String fieldToClear) {
        QuoteForm clearField = new QuoteForm();

        switch (fieldToClear) {
            case "username":
                clearField.clearUsername();
                break;
            case "password":
                clearField.clearPassword();
                break;
            case "confirmPassword":
                clearField.clearConfirmPassword();
                break;
            default:
                System.out.println("No such field to clear");
        }
    }

    @When("I fill out name field with first name {string} and last name {string}")
    public void iFillOutNameFieldWithFirstNameAndLastName(String firstName, String lastName) {
        form.fillName(firstName, lastName);
    }

    @Then("I verify {string} field value {string}")
    public void iVerifyFieldValue(String nameField, String text) {

        switch (nameField) {
            case "name":
                assertThat(form.getFullName("value")).isEqualTo(text);
                break;
            default:
                System.out.println("No such field");
        }
    }

    @When("I fill out name field with first name {string}, middle name {string}, last name {string}")
    public void iFillOutNameFieldWithFirstNameMiddleNameLastName(String firstName, String middleName, String lastName) {
        form.fillName(firstName, middleName, lastName);
    }
}
