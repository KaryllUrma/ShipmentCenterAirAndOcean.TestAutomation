package Resources;

public class TestData {

    // maincore authentication payload
    public String MaincoreAuthPayload(String user, String password) {
        String payload = "{\r\n"
                + "    \"Credentials\": {\r\n"
                + "        \"UserName\": \"" + user + "\",\r\n"
                + "        \"Password\": \"" + password + "\"\r\n"
                + "    },\r\n"
                + "    \"AuthenticatingFactors\": [],\r\n"
                + "    \"AccessedSystem\": \"Mainchain\",\r\n"
                + "    \"ExpireTimeSpan\": \"20\",\r\n"
                + "    \"ValidFromUtc\": null,\r\n"
                + "    \"CountsOfUse\": 0,\r\n"
                + "    \"SlidingExpiration\": true,\r\n"
                + "    \"Infinite\": false\r\n"
                + "}";
        return payload;
    }

    // notification subscription payload
    public String NotificationSubscriptionPayload_Old(String eventType, String serviceType, String dataType, String branding, String region) {
        String payload = "{\n" +
                "\t\"OptionalConditions\": [],\n" +
                "\t\"Id\": null,\n" +
                "\t\"EventType\": \"" + eventType + "\",\n" +
                "\t\"Region\": \"" + region + "\",\n" +
                "\t\"ServiceType\": \"" + serviceType + "\",\n" +
                "\t\"DataReference\": {\n" +
                "\t\t\"Type\": \"" + dataType + "\",\n" +
                "\t\t\"Identifier\": \"82ae6069-d939-43ec-8689-c00f79aa8cc6\"\n" +
                "\t},\n" +
                "\t\"Endpoints\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"NotificationType\": 1,\n" +
                "\t\t\t\"Endpoint\": \"test@theta.com\",\n" +
                "\t\t\t\"Branding\": \"" + branding + "\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"NotificationType\": 2,\n" +
                "\t\t\t\"Endpoint\": \"+64224695500\",\n" +
                "\t\t\t\"Branding\": null\n" +
                "\t\t}\n" +
                "\t],\n" +
                "\t\"Events\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"Code\": \"PickedUp\",\n" +
                "\t\t\t\"DisplayName\": \"Picked Up\",\n" +
                "\t\t\t\"LastSentDateTime\": \"0001-01-01T00:00:00\",\n" +
                "\t\t\t\"Order\": 0\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Code\": \"InTransit\",\n" +
                "\t\t\t\"DisplayName\": \"In Transit\",\n" +
                "\t\t\t\"LastSentDateTime\": \"0001-01-01T00:00:00\",\n" +
                "\t\t\t\"Order\": 0\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Code\": \"AtDeliveryDepot\",\n" +
                "\t\t\t\"DisplayName\": \"At Delivery Depot\",\n" +
                "\t\t\t\"LastSentDateTime\": \"0001-01-01T00:00:00\",\n" +
                "\t\t\t\"Order\": 0\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Code\": \"OnDeliveryVehicle\",\n" +
                "\t\t\t\"DisplayName\": \"On Delivery Vehicle\",\n" +
                "\t\t\t\"LastSentDateTime\": \"0001-01-01T00:00:00\",\n" +
                "\t\t\t\"Order\": 0\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Code\": \"Delivered\",\n" +
                "\t\t\t\"DisplayName\": \"Delivered\",\n" +
                "\t\t\t\"LastSentDateTime\": \"0001-01-01T00:00:00\",\n" +
                "\t\t\t\"Order\": 0\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}";
        return payload;
    }

    // notification subscription payload
    public String NotificationSubscriptionPayload(String eventType, String serviceType, String dataType, String branding, String region, String email, String contactNo) {

        String payload = "{\n" +
                "\t\"OptionalConditions\": [],\n" +
                "\t\"Id\": null,\n" +
                "\t\"EventType\": \"" + eventType + "\",\n" +
                "\t\"Region\": \"" + region + "\",\n" +
                "\t\"ServiceType\": \"" + serviceType + "\",\n" +
                "\t\"DataReference\": {\n" +
                "\t\t\"Type\": \"" + dataType + "\",\n" +
                "\t\t\"Identifier\": \"82ae6069-d939-43ec-8689-c00f79aa8cc6\"\n" +
                "\t},\n" +
                "\t\"Endpoints\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"NotificationType\": 1,\n" +
                "\t\t\t\"Endpoint\": \"" + email + "\",\n" +
                "\t\t\t\"Branding\": \"" + branding + "\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"NotificationType\": 2,\n" +
                "\t\t\t\"Endpoint\": \"" + contactNo + "\",\n" +
                "\t\t\t\"Branding\": null\n" +
                "\t\t}\n" +
                "\t],\n" +
                "\t\"Events\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"Code\": \"PickedUp\",\n" +
                "\t\t\t\"DisplayName\": \"Picked Up\",\n" +
                "\t\t\t\"LastSentDateTime\": \"0001-01-01T00:00:00\",\n" +
                "\t\t\t\"Order\": 0\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Code\": \"InTransit\",\n" +
                "\t\t\t\"DisplayName\": \"In Transit\",\n" +
                "\t\t\t\"LastSentDateTime\": \"0001-01-01T00:00:00\",\n" +
                "\t\t\t\"Order\": 0\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Code\": \"AtDeliveryDepot\",\n" +
                "\t\t\t\"DisplayName\": \"At Delivery Depot\",\n" +
                "\t\t\t\"LastSentDateTime\": \"0001-01-01T00:00:00\",\n" +
                "\t\t\t\"Order\": 0\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Code\": \"OnDeliveryVehicle\",\n" +
                "\t\t\t\"DisplayName\": \"On Delivery Vehicle\",\n" +
                "\t\t\t\"LastSentDateTime\": \"0001-01-01T00:00:00\",\n" +
                "\t\t\t\"Order\": 0\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Code\": \"Delivered\",\n" +
                "\t\t\t\"DisplayName\": \"Delivered\",\n" +
                "\t\t\t\"LastSentDateTime\": \"0001-01-01T00:00:00\",\n" +
                "\t\t\t\"Order\": 0\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}";
        return payload;
    }

    // notification subscription payload with subscription id
    public String NotificationSubscriptionPayloadWithSubId(String eventType, String serviceType, String dataType, String branding, String region, String email, String contactNo, String subscriptionId) {

        String payload = "{\n" +
                "\t\"OptionalConditions\": [],\n" +
                "\t\"Id\": \"" + subscriptionId + "\",\n" +
                "\t\"EventType\": \"" + eventType + "\",\n" +
                "\t\"Region\": \"" + region + "\",\n" +
                "\t\"ServiceType\": \"" + serviceType + "\",\n" +
                "\t\"DataReference\": {\n" +
                "\t\t\"Type\": \"" + dataType + "\",\n" +
                "\t\t\"Identifier\": \"82ae6069-d939-43ec-8689-c00f79aa8cc6\"\n" +
                "\t},\n" +
                "\t\"Endpoints\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"NotificationType\": 1,\n" +
                "\t\t\t\"Endpoint\": \"" + email + "\",\n" +
                "\t\t\t\"Branding\": \"" + branding + "\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"NotificationType\": 2,\n" +
                "\t\t\t\"Endpoint\": \"" + contactNo + "\",\n" +
                "\t\t\t\"Branding\": null\n" +
                "\t\t}\n" +
                "\t],\n" +
                "\t\"Events\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"Code\": \"PickedUp\",\n" +
                "\t\t\t\"DisplayName\": \"Picked Up\",\n" +
                "\t\t\t\"LastSentDateTime\": \"0001-01-01T00:00:00\",\n" +
                "\t\t\t\"Order\": 0\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Code\": \"InTransit\",\n" +
                "\t\t\t\"DisplayName\": \"In Transit\",\n" +
                "\t\t\t\"LastSentDateTime\": \"0001-01-01T00:00:00\",\n" +
                "\t\t\t\"Order\": 0\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Code\": \"AtDeliveryDepot\",\n" +
                "\t\t\t\"DisplayName\": \"At Delivery Depot\",\n" +
                "\t\t\t\"LastSentDateTime\": \"0001-01-01T00:00:00\",\n" +
                "\t\t\t\"Order\": 0\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Code\": \"OnDeliveryVehicle\",\n" +
                "\t\t\t\"DisplayName\": \"On Delivery Vehicle\",\n" +
                "\t\t\t\"LastSentDateTime\": \"0001-01-01T00:00:00\",\n" +
                "\t\t\t\"Order\": 0\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Code\": \"Delivered\",\n" +
                "\t\t\t\"DisplayName\": \"Delivered\",\n" +
                "\t\t\t\"LastSentDateTime\": \"0001-01-01T00:00:00\",\n" +
                "\t\t\t\"Order\": 0\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}";
        return payload;
    }
}
