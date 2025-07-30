package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class APIResetTestData_Step_Defs {

    private final String BASE_URI = "https://qacandidatetest.ensek.io";
    private String accessToken;
    private Response resetResponse;

    @Given("I am authenticated for reset")
    public void i_am_authenticated_for_reset() {
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
        System.out.println("Authentication successful for reset test");
    }

    @When("I reset the ENSEK test data")
    public void i_reset_the_ensek_test_data() {
        resetResponse = given()
                .baseUri(BASE_URI)
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .post("/ENSEK/reset")
                .then()
                .extract()
                .response();

        System.out.println("Reset API called - Status Code: " + resetResponse.getStatusCode());
        System.out.println("Reset Response: " + resetResponse.getBody().asString());
    }

    @Then("the reset should be successful")
    public void the_reset_should_be_successful() {
        assertEquals("Reset should return status code 200", 200, resetResponse.getStatusCode());
        System.out.println("Reset test data successful");
    }
}
