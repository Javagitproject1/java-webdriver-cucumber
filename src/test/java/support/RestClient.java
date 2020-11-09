package support;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.util.List;
import java.util.Map;

import static support.TestContext.*;

public class RestClient {
    private String basicUrl = "https://skryabin.com/recruit/api/v1/";
    private static String loginToken;
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String JSON = "application/json";
    public static final String AUTHORIZATION = "Authorization";


    public void login(Map<String, String> user) {

        //prepare request
        RequestSpecification request = RestAssured.given()
                .log().all()
                .baseUri(basicUrl)
                .basePath("login")
                .header(CONTENT_TYPE, JSON)
                .body(user);

        //execute
        Response response = request.when()
                .post();

        // verify and extract data
        Map<String, Object> result = response.then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");

        loginToken = "Bearer " + result.get("token");
        System.out.println(loginToken);
    }

    public Map<String, Object> createPosition(Map<String, String> position) {

        // How to add timestamp to title
//        String title = position.get("title");
//        position.put("title", title + getTimestamp());

        // How to update current date
//        String date = position.get("dateOpen");
//        position.put("dateOpen", getCurrentDate());

        RequestSpecification request = RestAssured.given()
                .log().all()
                .baseUri(basicUrl)
                .basePath("positions")
                .header(CONTENT_TYPE, JSON)
                .header(AUTHORIZATION, loginToken)
                .body(position);

        Response response = request.when()
                .post();

        Map<String, Object> result = response.then()
                .log().all()
                .statusCode(201)
                .extract()
                .jsonPath()
                .getMap("");

        setTestData("newPosition", result);
        return result;
    }

    public List<Map<String, Object>> getAllPositions() {
        RequestSpecification request = RestAssured.given()
                .log().all()
                .baseUri(basicUrl)
                .basePath("positions")
                .header(CONTENT_TYPE, JSON);

        Response response = request
                .get();

        List<Map<String, Object>> result = response.then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList("");
        return result;
    }

    public Map<String, Object> updatePosition(Map<String, String> fields, Object id) {
        Map<String, Object> result = RestAssured.given()
                .log().all()
                .baseUri(basicUrl)
                .basePath("positions/" + id)
                .header(CONTENT_TYPE, JSON)
                .header(AUTHORIZATION, loginToken)
                .body(fields)
                .when()
                .patch()
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");

        return result;
    }

    public Map<String, Object> getPosition(Object id) {
        Map<String, Object> result = RestAssured.given()
                .log().all()
                .baseUri(basicUrl)
                .basePath("positions/" + id)
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");

        return result;
    }

    public void deletePositionById(Object id) {
        RestAssured.given()
                .log().all()
                .baseUri(basicUrl)
                .basePath("positions/" + id)
                .header(AUTHORIZATION, loginToken)
                .when()
                .delete()
                .then()
                .log().all()
                .statusCode(204);
    }

    public Map<String, Object> createCandidate(Map<String, String> candidate) {
        Map<String, Object> result = RestAssured.given()
                .log().all()
                .baseUri(basicUrl)
                .basePath("/candidates")
                .header(CONTENT_TYPE, JSON)
                .body(candidate)
                .when()
                .post()
                .then()
                .log().all()
                .statusCode(201)
                .extract()
                .jsonPath()
                .getMap("");

        setTestData("newCandidate", result);
        return result;
    }

    public List<Map<String, Object>> getAllCandidates() {
        List<Map<String, Object>> result = RestAssured.given()
                .log().all()
                .baseUri(basicUrl)
                .basePath("/candidates")
                .header(CONTENT_TYPE, JSON)
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList("");
        return result;
    }

    public Map<String, Object> updateCandidate(Map<String, String> fields, Object id) {
        Map<String, Object> result = RestAssured.given()
                .log().all()
                .baseUri(basicUrl)
                .basePath("candidates/" + id)
                .header(CONTENT_TYPE, JSON)
                .header(AUTHORIZATION, loginToken)
                .body(fields)
                .when()
                .patch()
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");

        return result;
    }

    public Map<String, Object> getCandidate(Object id) {
        Map<String, Object> result = RestAssured.given()
                .log().all()
                .baseUri(basicUrl)
                .basePath("candidates/" + id)
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");

        return result;
    }

    public void deleteCandidateById(Object id) {
        RestAssured.given()
                .log().all()
                .baseUri(basicUrl)
                .basePath("candidates/" + id)
                .header(AUTHORIZATION, loginToken)
                .when()
                .delete()
                .then()
                .log().all()
                .statusCode(204);
    }

    public void addResume (File resume, Object candidateId){
        RestAssured.given()
                .log().all()
                .baseUri(basicUrl)
                .basePath("candidates/" +candidateId + "/resume")
                .header(AUTHORIZATION, loginToken)
                .multiPart("resume", resume)
                .when()
                .post()
                .then()
                .log().all()
                .statusCode(201);
    }

    public ExtractableResponse<Response> getResume (Object candidateId){
        return RestAssured.given()
                .log().all()
                .baseUri(basicUrl)
                .basePath("candidates/" +candidateId + "/resume")
                .header(AUTHORIZATION, loginToken)
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(200)
                .extract();
    }
}
