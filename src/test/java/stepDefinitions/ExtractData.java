package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.ExchangeRateResponse;
import org.testng.Assert;

import static constants.API_Endpoints.EXCHANGE_GET_BASE_URI;
import static constants.API_Endpoints.GET_SUCCESS_CODE;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class ExtractData {

    private Response response;
    private RequestSpecification httpRequest;
    private ExchangeRateResponse exchangeRateResponse;

    @Before
    public void initialize() {
        RestAssured.baseURI =  EXCHANGE_GET_BASE_URI;

    }
    @When("Fetch response by hitting api with endpoint {string}")
    public void fetch_response_by_hitting_api_with_endpoint(String string) {
        httpRequest = given();
        response = httpRequest.contentType(ContentType.JSON).get(string);
        if(response.getStatusCode()== GET_SUCCESS_CODE) {
            exchangeRateResponse = response.as(ExchangeRateResponse.class);
            exchangeRateResponse.setStatusCode(response.getStatusCode());
        }
        else {
            Assert.fail("API is not working");
        }
    }

    @Then("Success code {int}")
    public void success_code(Integer int1) {
        Assert.assertEquals(response.getStatusCode(),int1);
    }

    @Then("Response time is less than {int} seconds")
    public void response_time_less_than_3_second(int expectedresponseTime){
        int responseTime = (int)exchangeRateResponse.getTimeLastUpdateUnix();
        long currentTime = System.currentTimeMillis() / 1000;
        Assert.assertTrue(currentTime - responseTime >= expectedresponseTime);
    }

    @Then("Total currency pairs returned are {int}")
    public void total_currency_pairs_returned(int totalPairsOfCurrency){
        Assert.assertEquals(totalPairsOfCurrency, exchangeRateResponse.getRatesResponseBody().size());
    }

    @Then("I receive the price against the AED on range {double} - {double}")
    public void i_receive_the_price_against_the_AED_on_range(double min,double max) {
        double usdToAedRate = exchangeRateResponse.getRatesResponseBody().getAED();
        Assert.assertTrue(usdToAedRate >= min && usdToAedRate <= max);

    }
}
