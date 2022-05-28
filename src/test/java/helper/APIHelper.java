package helper;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class APIHelper {

    public static void checkStatusIs200 (Response res) {

    }

    public void GetBooksDetails() {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        // Get the RequestSpecification of the request to be sent to the server.
        RequestSpecification httpRequest = RestAssured.given();
        // specify the method type (GET) and the parameters if any.
        //In this case the request does not take any parameters
        Response response = httpRequest.request(Method.GET, "");
        // Print the status and message body of the response received from the server
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());
    }

//    public void postRequestBooksAPI()
//    {
//        RestAssured.baseURI = "https://demoqa.com";
//        RequestSpecification request = RestAssured.given();
//        // JSONObject is a class that represents a Simple JSON.
//        // We can add Key - Value pairs using the put method
//        JSONObject requestParams = new JSONObject();
//        requestParams.put("userId", "TQ123");
//        requestParams.put("isbn", "9781449325862");
//        // Add a header stating the Request body is a JSON
//        request.header("Content-Type", "application/json"); // Add the Json to the body of the request
//        request.body(requestParams.toJSONString()); // Post the request and check the response
//        Response response = request.post("/BookStore/V1/Books");
//        System.out.println("The status received: " + response.statusLine());
//    }
//
//    public void updateBook() {
//        RestAssured.baseURI = baseUrl;
//        RequestSpecification httpRequest = RestAssured.given().header("Authorization", "Bearer " + token)
//                .header("Content-Type", "application/json");
//
//        //Calling the Delete API with request body
//        Response res = httpRequest.body("{ \"isbn\": \"" + isbn + "\", \"userId\": \"" + userId + "\"}").put("/BookStore/v1/Book/9781449325862");
//
//        //Fetching the response code from the request and validating the same
//        System.out.println("The response code - " +res.getStatusCode());
//        Assert.assertEquals(res.getStatusCode(),200);
//
//    }
//
//    public void deleteBook() {
//        RestAssured.baseURI = baseUrl;
//        RequestSpecification httpRequest = RestAssured.given().header("Authorization", "Bearer " + token)
//                .header("Content-Type", "application/json");
//
//        //Calling the Delete API with request body
//        Response res = httpRequest.body("{ \"isbn\": \"" + isbn + "\", \"userId\": \"" + userId + "\"}").delete("/BookStore/v1/Book");
//
//        //Fetching the response code from the request and validating the same
//        System.out.println("The response code is - " +res.getStatusCode());
//        Assert.assertEquals(res.getStatusCode(),204);
//
//    }
}
