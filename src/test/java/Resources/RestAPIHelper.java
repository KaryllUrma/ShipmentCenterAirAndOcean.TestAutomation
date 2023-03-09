package Resources;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RestAPIHelper {
    // initialize variables
    public String _environment;


    // Constructor
    public RestAPIHelper() {
        RestAssured.baseURI = "http://maincoreauthtest.nz.mainfreight.com/1.1/";
    }

    // Public Methods
    public Path SetUrl(String resourceUrl) {
        Path path = Paths.get(_environment, resourceUrl);
        return path;
    }

    /*method to send post request*/
    public RequestSpecification CreatePOSTRequest(String requestBody) {
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestBody);

        return httpRequest;
    }

    /*method to send get request*/
    public RequestSpecification CreateGetRequestServiceEvents(String serviceType, String dataType, String region, String secret) {
        RequestSpecification httpRequest = RestAssured.given();
        //httpRequest.header("Content-Type", "application/json");

        // update uri
        httpRequest.baseUri("https://notificationapi.test.theta.mainchain.net/");

        // add mft authorization
        httpRequest.header("MFT-Authorization", "Secret " + secret);
        httpRequest.relaxedHTTPSValidation();

        // add parameters
        httpRequest.queryParam("serviceType",serviceType);
        httpRequest.queryParam("dataType", dataType);
        httpRequest.queryParam("region", region);

        return httpRequest;
    }

    /*method to send request for Notification Subscription*/
    public RequestSpecification CreateRequestNotificationSubscription(String eventType, String serviceType, String dataType, String branding, String region, String secret, String requestBody, String SubscriptionId) {
        RequestSpecification httpRequest = RestAssured.given();

        // set headers
        httpRequest.header("Content-Type", "application/json");
        httpRequest.header("MFT-Authorization", "Secret " + secret);
        httpRequest.relaxedHTTPSValidation();

        // update uri
        httpRequest.baseUri("https://notificationapi.test.theta.mainchain.net/");

        // add request body
        httpRequest.body(requestBody);

        return httpRequest;
    }

    /*method to get response*/
    public Response GetResponse(RequestSpecification httpRequest, String resourceUrl, String requestMethod) {

        Response response = null;

        switch(requestMethod){
            case "POST":
                response = httpRequest.post(resourceUrl).thenReturn();
                break;
            case "GET":
                response = httpRequest.get(resourceUrl).thenReturn();
                break;
            case "PUT":
                response = httpRequest.put(resourceUrl).thenReturn();
                break;
            default:
                // do nothing
        }
        return response;
    }
}
