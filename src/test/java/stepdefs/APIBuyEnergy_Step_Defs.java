package stepdefs;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class APIBuyEnergy_Step_Defs {

    private final String BASE_URI = "https://qacandidatetest.ensek.io";
    private String accessToken;
    private int actualRemaining;

    @Given("I am authenticated")
    public void i_am_authenticated() {
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

    @And("the ENSEK test data is reset")
    public void the_ENSEK_test_data_is_reset() {
        // Reset the ENSEK test data
        given()
                .baseUri(BASE_URI)
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .post("/ENSEK/reset")
                .then()
                .statusCode(200);
    }

    @When("I buy {int} units with ID {int}")
    public void i_buy_units_with_id(Integer quantity, Integer id) {
        given()
                .baseUri(BASE_URI)
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .put("/ENSEK/buy/" + id + "/" + quantity)
                .then()
                .statusCode(200);


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Then("the remaining quantity for ID {int} should be {int}")
    public void the_remaining_quantity_for_id_should_be(Integer id, Integer expectedRemaining) {
        Response response = given()
                .baseUri(BASE_URI)
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get("/ENSEK/energy")
                .then()
                .statusCode(200)
                .extract()
                .response();


        Map<String, Map<String, Object>> energyMap = response.jsonPath().getMap("");

        boolean foundId = false;

        for (Map.Entry<String, Map<String, Object>> entry : energyMap.entrySet()) {
            Map<String, Object> energyDetails = entry.getValue();


            Integer energyId = ((Number) energyDetails.get("energy_id")).intValue();

            if (energyId.equals(id)) {

                actualRemaining = ((Number) energyDetails.get("quantity_of_units")).intValue();
                foundId = true;
                break;
            }
        }

        if (!foundId) {
            throw new RuntimeException("Could not find energy with ID: " + id);
        }

        assertEquals("Remaining quantity does not match for ID " + id, expectedRemaining.intValue(), actualRemaining);
    }
}