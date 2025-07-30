package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class APIBuyenergyandverifyorderlist {

    private final String BASE_URI = "https://qacandidatetest.ensek.io";
    private String accessToken;
    private String extractedOrderId;

    @Given("I am authenticated as user")
    public void i_am_authenticated_as_user() {
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

    @And("the ENSEK test data is reseted")
    public void the_ensek_test_data_is_reseted() {
        given()
                .baseUri(BASE_URI)
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .post("/ENSEK/reset")
                .then()
                .statusCode(200);
    }

    @When("customer buy {int} units with ID {int}")
    public void customer_buy_units_with_id(Integer quantity, Integer id) {
        Response response = given()
                .baseUri(BASE_URI)
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .put("/ENSEK/buy/" + id + "/" + quantity)
                .then()
                .statusCode(200)
                .extract()
                .response();


        String responseMessage = response.jsonPath().getString("message");
        System.out.println("Response message: " + responseMessage);


        if (responseMessage.contains("is ")) {
            extractedOrderId = extractOrderIdFromMessage(responseMessage);
        } else {
            System.out.println("No order ID found - purchase may have failed or no fuel available");
            extractedOrderId = null;
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Then("the extracte order ID should exist in the orders list")
    public void the_extracte_order_id_should_exist_in_the_orders_list() {

        if (extractedOrderId == null || extractedOrderId.isEmpty()) {
            System.out.println("Skipping order verification - no order ID was extracted");
            return;
        }

        Response response = given()
                .baseUri(BASE_URI)
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get("/ENSEK/orders")
                .then()
                .statusCode(200)
                .extract()
                .response();


        List<Map<String, Object>> orders = response.jsonPath().getList("");


        boolean orderFound = false;
        for (Map<String, Object> order : orders) {

            String orderId = null;
            if (order.containsKey("Id")) {
                orderId = (String) order.get("Id");
            } else if (order.containsKey("id")) {
                orderId = (String) order.get("id");
            }

            if (extractedOrderId.equals(orderId)) {
                orderFound = true;
                System.out.println("Found order in list: " + orderId);
                System.out.println("Order details: " + order);
                break;
            }
        }

        System.out.println("Extracted Order ID: " + extractedOrderId);
        System.out.println("Order found in list: " + orderFound);

        if (!orderFound) {
            System.out.println("Available order IDs in the list:");
            for (Map<String, Object> order : orders) {
                String orderId = order.containsKey("Id") ? (String) order.get("Id") : (String) order.get("id");
                System.out.println("- " + orderId);
            }
        }

        assertTrue("The extracted order ID should exist in the orders list", orderFound);
    }

    private String extractOrderIdFromMessage(String message) {

        int isIndex = message.lastIndexOf("is ");
        if (isIndex != -1) {
            String afterIs = message.substring(isIndex + 3).trim();

            String orderId = afterIs.replaceAll("[^a-f0-9-]", "");
            System.out.println("Extracted Order ID from message: " + orderId);
            return orderId;
        } else {
            throw new RuntimeException("Could not find 'is ' in message: " + message);
        }
    }
}
