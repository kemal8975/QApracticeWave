package stepdefs;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class APIGet_Energy_Step_Defs {

    private final String BASE_URI = "https://qacandidatetest.ensek.io";
    private String accessToken;
    private Response energyResponse;

    @Given("I am authenticated for energy retrieval")
    public void i_am_authenticated_for_energy_retrieval() {
        String loginPayload = "{ \"username\": \"test\", \"password\": \"testing\" }";

        Response response = given()
                .baseUri(BASE_URI)
                .header("Content-Type", "application/json")
                .body(loginPayload)
                .when()
                .post("/ENSEK/login")
                .then()
                .statusCode(200)
                .extract()
                .response();

        accessToken = response.jsonPath().getString("access_token");
    }

    @And("the ENSEK test data is reset for energy retrieval")
    public void the_ENSEK_test_data_is_reset_for_energy_retrieval() {
        given()
                .baseUri(BASE_URI)
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .post("/ENSEK/reset")
                .then()
                .statusCode(200);
    }

    @When("I get energy details")
    public void i_get_energy_details() {
        energyResponse = given()
                .baseUri(BASE_URI)
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get("/ENSEK/energy")
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    @Then("the response should contain {string}")
    public void the_response_should_contain(String energyType) {
        Map<String, Object> responseMap = energyResponse.jsonPath().getMap("");
        assertTrue("Response should contain " + energyType, responseMap.containsKey(energyType));
    }
}