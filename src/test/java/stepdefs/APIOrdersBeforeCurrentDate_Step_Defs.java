package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class APIOrdersBeforeCurrentDate_Step_Defs {

    private final String BASE_URI = "https://qacandidatetest.ensek.io";
    private String accessToken;
    private List<Map<String, Object>> orders;
    private int ordersBeforeCurrentDate = 0;

    @Given("I am authenticated for orders check")
    public void i_am_authenticated_for_orders_check() {
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
        System.out.println("Authentication successful for orders check");
    }

    @When("I get all orders from the system")
    public void i_get_all_orders_from_the_system() {
        Response response = given()
                .baseUri(BASE_URI)
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get("/ENSEK/orders")
                .then()
                .statusCode(200)
                .extract()
                .response();

        orders = response.jsonPath().getList("");
        System.out.println("Retrieved " + orders.size() + " total orders");


        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");

        for (Map<String, Object> order : orders) {
            String timeString = (String) order.get("time");
            try {
                Date orderDate = dateFormat.parse(timeString);
                if (orderDate.before(currentDate)) {
                    ordersBeforeCurrentDate++;
                    System.out.println("Order before current date: " + timeString + " (ID: " + order.get("id") + ")");
                }
            } catch (ParseException e) {
                System.out.println("Could not parse date: " + timeString);
            }
        }

        System.out.println("Orders created before current date: " + ordersBeforeCurrentDate);
        System.out.println("Current date: " + currentDate);
    }

    @Then("the number of orders created before current date should be more than {int}")
    public void the_number_of_orders_created_before_current_date_should_be_more_than(int expectedMinimum) {
        System.out.println("Asserting that " + ordersBeforeCurrentDate + " is more than " + expectedMinimum);
        assertTrue("Number of orders before current date (" + ordersBeforeCurrentDate + ") should be more than " + expectedMinimum,
                ordersBeforeCurrentDate > expectedMinimum);
    }
}
