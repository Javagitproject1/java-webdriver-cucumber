package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.apache.commons.codec.binary.Hex;
import support.RestClient;

import java.io.File;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;

public class RestStepDefs {

    @Given("I login via REST as {string}")
    public void iLoginViaRestAs(String role) {
        Map<String, String> user = getData(role);
        new RestClient().login(user);
    }

    @When("I create via REST {string} position")
    public void iCreateViaRESTPosition(String type) {
        new RestClient().createPosition(getPosition(type));
    }

    @Then("I verify via REST new {string} position is in the list")
    public void iVerifyViaRESTNewPositionIsInTheList(String title) {

        List<Map<String, Object>> allPositions = new RestClient().getAllPositions();
        Object createdPositionId = getTestDataMap("newPosition").get("id");
        Map<String, String> expectedPosition = getPosition(title);

        boolean idIsFound = false;
        for (Map<String, Object> singlePosition : allPositions) {
            if (singlePosition.get("id").equals(createdPositionId)) {
                idIsFound = true;

                for (String key : expectedPosition.keySet()) {
                    assertThat(singlePosition.get(key)).isEqualTo(expectedPosition.get(key));
                }
                break;
            }
        }
        assertThat(idIsFound).isTrue();
    }

    @When("I update via REST {string} position")
    public void iUpdateViaRESTPosition(String title) {
        Map<String, String> updatedPosition = getPosition(title + "_updated");
        Object id = getTestDataMap("newPosition").get("id");
        new RestClient().updatePosition(updatedPosition, id);
    }

    @Then("I verify via REST new {string} position is updated")
    public void iVerifyViaRESTNewPositionIsUpdated(String type) {
        Object expectedPositionId = getTestDataMap("newPosition").get("id");
        Map<String, Object> actualPosition = new RestClient().getPosition(expectedPositionId);
        Map<String, String> expectedFields = getPosition(type + "_updated");

//        assertThat(actualPosition.get("address")).isEqualTo(expectedFields.get("address"));
//        assertThat(actualPosition.get("city")).isEqualTo(expectedFields.get("city"));
        for (String key : expectedFields.keySet()) {
            System.out.println("Verifying " + key);
            assertThat(actualPosition.get(key)).isEqualTo(expectedFields.get(key));
        }
    }

    @When("I delete via REST new position")
    public void iDeleteViaRESTNewPosition() {
        Object expectedPositionId = getTestDataMap("newPosition").get("id");
        new RestClient().deletePositionById(expectedPositionId);
    }

    @Then("I verify via REST new position is deleted")
    public void iVerifyViaRESTNewPositionIsDeleted() {
        Object deletedId = getTestDataMap("newPosition").get("id");
        List<Map<String, Object>> allPositions = new RestClient().getAllPositions();

        for (Map<String, Object> singlePosition : allPositions) {
            assertThat(singlePosition.get("id")).isNotEqualTo(deletedId);
        }
    }

    @When("I create via REST {string} candidate")
    public void iCreateViaRESTCandidate(String sdet) {
        new RestClient().createCandidate(getCandidates(sdet));
    }

    @Then("I verify via REST new {string} candidate is in the list")
    public void iVerifyViaRESTNewCandidateIsInTheList(String sdet) {
        List<Map<String, Object>> allCandidate = new RestClient().getAllCandidates();
        Object createdCandidate = getTestDataMap("newCandidate").get("id");
        Map<String, String> expectedCandidate = getCandidate(sdet);

        boolean idIsFound = false;
        for (Map<String, Object> singleCandidate : allCandidate) {
            if (singleCandidate.get("id").equals(createdCandidate)) {
                idIsFound = true;
//                for (String everyKey : expectedCandidate.keySet()){
//                    System.out.println("Verifying " + everyKey);
//                    assertThat(singleCandidate.get(everyKey)).isEqualTo(expectedCandidate.get(everyKey));
//                }
                break;
            }
        }
        assertThat(idIsFound).isTrue();
    }

    @When("I update via REST {string} candidate")
    public void iUpdateViaRESTCandidate(String role) {
        Map<String, String> updatedCandidate = getCandidate(role + "_updated");
        Object id = getTestDataMap("newCandidate").get("id");
        new RestClient().updateCandidate(updatedCandidate, id);
    }

    @Then("I verify via REST new {string} candidate is updated")
    public void iVerifyViaRESTNewCandidateIsUpdated(String role) {
        Object candidateId = getTestDataMap("newCandidate").get("id");
        Map<String, Object> createdCandidate = new RestClient().getCandidate(candidateId);
        Map<String, String> expectedFields = getCandidate(role + "_updated");

        for (String key : expectedFields.keySet()) {
            System.out.println("Verifying " + key);
            assertThat(createdCandidate.get(key)).isEqualTo(expectedFields.get(key));
        }
    }

    @When("I delete via REST new candidate")
    public void iDeleteViaRESTNewCandidate() {
        Object expectedCandidateId = getTestDataMap("newCandidate").get("id");
        new RestClient().deleteCandidateById(expectedCandidateId);
    }

    @Then("I verify via REST new candidate is deleted")
    public void iVerifyViaRESTNewCandidateIsDeleted() {
        Object deletedId = getTestDataMap("newCandidate").get("id");
        List<Map<String, Object>> allCandidates = new RestClient().getAllCandidates();
        for (Map<String, Object> singleCandidate : allCandidates) {
            assertThat(singleCandidate.get("id")).isNotEqualTo(deletedId);
        }
    }

    @When("I add via REST {string} resume to the candidate")
    public void iAddViaRESTResumeToTheCandidate(String fileType) {
        File resume = getFile("resume", fileType );
        new RestClient().addResume(resume, getTestDataMap("newCandidate").get("id"));
    }

    @Then("I verify via REST {string} resume has been added")
    public void iVerifyViaRESTResumeHasBeenAdded(String fileType) {
        ExtractableResponse <Response> response = new RestClient().getResume(getTestDataMap("newCandidate").get("id"));
        String disposition =  response.header("content-disposition");
        assertThat(disposition).isEqualTo("attachment, filename=resume." + fileType);

        String signature = Hex.encodeHexString(response.asByteArray());
    }
}
