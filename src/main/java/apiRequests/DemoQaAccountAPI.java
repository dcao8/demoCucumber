package apiRequests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;

public class DemoQaAccountAPI {
    String baseUrl = "https://demoqa.com";
    String userId = "";
    String token = "";
    String userName = "daycao001";
    String password = "D@y1234cao";

    public void registerAccount() {
        RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given();
        // JSONObject is a class that represents a Simple JSON.
        // We can add Key - Value pairs using the put method
        JSONObject requestParams = new JSONObject();
        requestParams.put("userName", userName);
        requestParams.put("password", password);
        // Add a header stating the Request body is a JSON
        request.header("Content-Type", "application/json"); // Add the Json to the body of the request
        request.body(requestParams.toString()); // Post the request and check the response
        Response response = request.post("/Account/v1/User");
        userId = response.getBody().jsonPath().getString("userID");
        System.out.println("userID:"+userId);
        Assert.assertEquals(response.getStatusCode(), 201);
        // We will need the userID in the response body for our tests, please save it in a local variable
    }

    public void generateToken() {
        RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("userName", userName);
        requestParams.put("password", password);
        request.header("Content-Type", "application/json"); // Add the Json to the body of the request
        request.body(requestParams.toString()); // Post the request and check the response
        Response response = request.post("/Account/v1/GenerateToken");
        token = response.getBody().jsonPath().getString("token");

    }

    public void deleteAccount() {
        System.out.println("token:"+token);
        RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given().header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        //Calling the Delete API with request body
        Response response = request.delete("/Account/v1/User/" + userId);

        //Fetching the response code from the request and validating the same
        System.out.println("The response code is - " + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 204);
    }

    public String getUsername(){
        return userName;
    }

    public String getPassword(){
        return password;
    }
}
