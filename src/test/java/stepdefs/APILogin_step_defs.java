package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class APILogin_step_defs {
    private final String BASE_URI = "https://qacandidatetest.ensek.io";
    private Response response;

    @Given("I have valid login credentials")
    public void i_have_valid_login_credentials() {

    }

    @When("I send a POST request to the login endpoint")
    public void i_send_a_post_request_to_the_login_endpoint() {
        String loginPayload = "{ \"username\": \"test\", \"password\": \"testing\" }";

        response = given()
                .baseUri(BASE_URI)
                .header("Content-Type", "application/json")
                .body(loginPayload)
                .when()
                .post("/ENSEK/login")
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    @Then("the response should contain an access token")
    public void the_response_should_contain_an_access_token() {
        String token = response.jsonPath().getString("access_token");
        assertNotNull("Access token should not be null", token);
    }
}
