package stepDefinitions;

import Resources.TestData;
import Resources.Utilities;
import base.BaseStep;
import context.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.NotificationModel;
import enums.Context;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;


public class NotificationStepDefinition extends BaseStep {
    public NotificationModel _notificationModel;
    public TestData _testData;
    public Utilities _utilities;
    public String sessionSecret = "";
    TestContext testContext;

    public NotificationStepDefinition(TestContext context) {
        testContext = context;
        _notificationModel = new NotificationModel();
        _testData = new TestData();
        _utilities = new Utilities();
    }

    @Given("User generates the Session secret for (.*)")
    public void user_generates_the_Session_secret_for(String user) {
        Response response = _notificationModel.SendPostRequestMFTAuthorization("Authentication/CreateSessionSecret", _testData.MaincoreAuthPayload(user, "password123456"));
        sessionSecret = _utilities.getJsonPath(response, "SessionSecret");
//        String responseBody = response.body().asString();
//        System.out.println("SessionSecret:" + sessionSecret);
    }

    @When("User calls get request for (.*) with serviceType (.*) dataType (.*) and region (.*)")
    public void user_calls_get_request_for_with_serviceType_dataType_and_region(String api, String serviceType, String dataType, String region) {
        // get response
        Response response = _notificationModel.SendGetRequestServiceTypeAPI("ServiceEvents", sessionSecret, serviceType, dataType, region);

        // get response body
        String responseBody = response.body().asString();

        // beautify json response
        String jsonBeautified = _utilities.jsonBeautifier(responseBody);

        // log response
        System.out.println("Response body:" + jsonBeautified);

        // pass response to context
        testContext.scenarioContext.setContext(Context.RESPONSE_1, response);
    }

    @Then("User got the list of service events")
    public void user_got_the_list_of_service_events(DataTable dataTable) {

        // fetch response from context
        Response response = (Response) testContext.scenarioContext.getContext(Context.RESPONSE_1);

        // get actual serviceEvents(Codes)
        ArrayList<String> actCodes = (ArrayList<String>) _utilities.getJsonPathList(response, "code");
//        ((ArrayList) a).get(0);

        // write the code to handle Data Table
        String data = dataTable.cell(1, 0);
        List<String> dataList = Arrays.asList(data.split(";"));
        ArrayList<String> dataListArray = new ArrayList<String>(dataList);

        // get expected serviceEvents(Codes)
        ArrayList<String> expCodes = dataListArray;
        int expSize = expCodes.size();
        int actSize = actCodes.size();

        // compare exp and act arraylist
        boolean isResult = false;
        for (int iCnt = 0; iCnt <= expSize - 1; iCnt++) {
            if (actCodes.contains(expCodes.get(iCnt).trim())) {
                isResult = true;
            } else {
                isResult = false;
            }
        }
        if (expSize != actSize) {
            isResult = false;
        }
        assertTrue("FAIL: Expected and Actual service events don't match. " + "\nEXP: " + expCodes.toString() + "\nACT: " + actCodes.toString(), isResult);
    }


//    @When("User calls (.*) with eventType (.*) serviceType (.*) dataType (.*) branding (.*) and region (.*)")
//    public void userCallsAPIWithEventTypeEventTypeServiceTypeServiceTypeDataTypeDataTypeBrandingBrandingAndRegionRegion(String api, String eventType, String serviceType, String dataType, String branding, String region) {
//
//        // get response
//        Response response = _notificationModel.SendRequestNotificationSubscription("NotificationSubscription", sessionSecret, eventType, serviceType, dataType, branding, region, _testData.NotificationSubscriptionPayload_Old(eventType, serviceType, dataType, branding, region));
//
//        // get response body
//        String responseBody = response.body().asString();
//
//        // beautify json response
//        String jsonBeautified = _utilities.jsonBeautifier(responseBody);
//
//        // log response
//        System.out.println("Response body:" + jsonBeautified);
//
//        // pass response to context
//        testContext.scenarioContext.setContext(Context.RESPONSE_POST_NOTIFSUB, response);
//    }

    @Then("User got success with (\\d+) response from (.*)")
    public void userGotSuccessWithResponseFrom(int responseCode, String api) {

        //initialize variable
        Response response = null;

        // switch desired response to fetch
        switch (api.toString()) {
            case "ServiceEventsAPI":
                response = (Response) testContext.scenarioContext.getContext(Context.RESPONSE_1);
                break;
            case "CreateNotificationSubscription":
                response = (Response) testContext.scenarioContext.getContext(Context.RESPONSE_POST_NOTIFSUB);
                break;
            case "UpdateNotificationSubscription":
                response = (Response) testContext.scenarioContext.getContext(Context.RESPONSE_PUT_NOTIFSUB);
                break;
        }

        // get status code
        int actResponseCode = response.statusCode();

        // validate response
        assertEquals("FAIL: Unexpected response for" + api + " API.", responseCode, actResponseCode);
    }

    @When("User calls (.*) with eventType (.*) serviceType (.*) dataType (.*) branding (.*) region (.*) email (.*) and contact number (.*)")
    public void userCallsAPIWithEventTypeEventTypeServiceTypeServiceTypeDataTypeDataTypeBrandingBrandingRegionRegionEmailEmailAndContactNumberContactNumber(String api, String eventType, String serviceType, String dataType, String branding, String region, String email, String contactNo) {

        String subscriptionId = "";
        String payload = "";
        if (api.equals("UpdateNotificationSubscription")) {
            // SubsId if PUT request
            subscriptionId = (String) testContext.scenarioContext.getContext(Context.RESPONSE_ID_CREATESUB);
            //subscriptionId = "523a61ad-8e4c-4106-a728-d3d103a7ae2b";
            payload = _testData.NotificationSubscriptionPayloadWithSubId(eventType, serviceType, dataType, branding, region, email, contactNo, subscriptionId);
        } else {
            payload = _testData.NotificationSubscriptionPayload(eventType, serviceType, dataType, branding, region, email, contactNo);
        }

        // get response
        Response response = _notificationModel.SendRequestNotificationSubscription("NotificationSubscription" + "/" + subscriptionId, api, sessionSecret, eventType, serviceType, dataType, branding, region, payload, subscriptionId);

        // get response body
        String responseBody = response.body().asString();

        // beautify json response
        String jsonBeautified = _utilities.jsonBeautifier(responseBody);

        // log response
        System.out.println("Response body:" + jsonBeautified);

        // pass response to context
        switch (api.toString()) {
            case "CreateNotificationSubscription":
                testContext.scenarioContext.setContext(Context.RESPONSE_POST_NOTIFSUB, response);
                break;
            case "UpdateNotificationSubscription":
                testContext.scenarioContext.setContext(Context.RESPONSE_PUT_NOTIFSUB, response);
                break;
        }
    }

    @And("User got an ID in the response body from (.*)")
    public void userGotAnIDInTheResponseBodyFromAPI(String api) {

        // initialize variable
        Response response = null;

        // fetch response from CreateNotificationSubscription
        switch (api.toString()) {
            case "CreateNotificationSubscription":
                response = (Response) testContext.scenarioContext.getContext(Context.RESPONSE_POST_NOTIFSUB);
                break;
            case "UpdateNotificationSubscription":
                response = (Response) testContext.scenarioContext.getContext(Context.RESPONSE_PUT_NOTIFSUB);
                break;
        }

        // get id from response body
        String id = response.body().asString();

        // validate id
         Assert.assertTrue(id.toString().length() > 2);

        // log subscription ID
        System.out.println("[" + api + "]" + " Subscription ID:" + id);

        // pass subscription ID to a context
        switch (api.toString()) {
            case "CreateNotificationSubscription":
                testContext.scenarioContext.setContext(Context.RESPONSE_ID_CREATESUB, id);
                break;
            case "UpdateNotificationSubscription":
                testContext.scenarioContext.setContext(Context.RESPONSE_ID_UPDATESUB, id);
                break;
        }

    }
}
