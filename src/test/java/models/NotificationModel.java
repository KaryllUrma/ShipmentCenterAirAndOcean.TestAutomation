package models;

import base.BaseModel;
import enums.Context;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NotificationModel extends BaseModel {

    /*method to get session secret*/
    public Response SendPostRequestMFTAuthorization(String url, String payload) {

        // post rest request
        RequestSpecification restRequest = _restAPIHelper.CreatePOSTRequest(payload);

        // rest response
        Response response = _restAPIHelper.GetResponse(restRequest, url, "POST");

        // validate response is 200
        assertEquals(200,response.statusCode());

        return response;
    }

    /*method to send post request to Service Type API*/
    public Response SendGetRequestServiceTypeAPI(String endpoint, String sessionSecret, String serviceType, String dataType, String region){

        // get rest request
        RequestSpecification restRequest = _restAPIHelper.CreateGetRequestServiceEvents(serviceType, dataType, region, sessionSecret);

        // rest response
        Response response = _restAPIHelper.GetResponse(restRequest, endpoint, "GET");

        // validate response is 200
        assertEquals(200,response.statusCode());

        return response;
    }

    /*method to send post request to Service Type API*/
    public Response SendRequestNotificationSubscription(String endpoint, String api, String sessionSecret, String eventType, String serviceType, String dataType, String branding, String region, String payload, String subscriptionId){

        // request method
        String reqMethod = "";
        switch (api) {
            case "CreateNotificationSubscription":
                reqMethod = "POST";
                break;
            case "UpdateNotificationSubscription":
                reqMethod = "PUT";
                break;
        }

        // get rest request
        RequestSpecification restRequest = _restAPIHelper.CreateRequestNotificationSubscription(eventType, serviceType, dataType, branding, region,sessionSecret, payload, subscriptionId);

        // rest response
        Response response = _restAPIHelper.GetResponse(restRequest, endpoint, reqMethod);

        // validate response is 200
        assertEquals("FAIL: Unexpected response code for " + api + " API." ,200,response.statusCode());

        return response;
    }
}
