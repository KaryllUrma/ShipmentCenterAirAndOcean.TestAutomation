Feature: Validate Notification API's

  @NotificationTests
  Scenario Outline: Verify Service Events API
    Given User generates the Session secret for <User>
    When User calls get request for <API> with serviceType <serviceType> dataType <dataType> and region <region>
    Then User got success with 200 response from <API>
    And User got the list of service events
      | Service Events  |
      | <serviceEvents> |
    Examples:
      | API              | User                         | serviceType | dataType          | region | serviceEvents                                                                                                                                |
      | ServiceEventsAPI | notificationtest@theta.co.nz | TransportNz | ConsignmentNumber | NZ     | InformationReceived;PickedUp;InTransit;AtDeliveryDepot;OnDeliveryVehicle;Delivered                                                           |
      | ServiceEventsAPI | notificationtest@theta.co.nz | TransportEU | ShipmentNumber    | EU     | PickedUp;OutForDelivery; Delivered; Deviation                                                                                                |
      | ServiceEventsAPI | notificationtest@theta.co.nz | TransportUs | HousebillNumber   | US     | PickUpComplete; LinehaulDeparted; LinehaulArrived; OutForDelivery; DeliveryComplete; UnableToDeliver                                         |
      | ServiceEventsAPI | notificationtest@theta.co.nz | AirAndOcean | OrderNumber       | US     | BookingConfirmed; GoodsPickedUp; DepartedFromOrigin; ArrivedAtDestination; ImportCustomsCleared; GoodsAvailableForCollection; GoodsDelivered |
      | ServiceEventsAPI | notificationtest@theta.co.nz | AirAndOcean | JobNumber         | US     | BookingConfirmed; GoodsPickedUp; DepartedFromOrigin; ArrivedAtDestination; ImportCustomsCleared; GoodsAvailableForCollection; GoodsDelivered |

  @NotificationTests
  Scenario Outline: Verify Create NotificationSubscription API
    Given User generates the Session secret for <User>
    When User calls <API> with eventType <eventType> serviceType <serviceType> dataType <dataType> branding <branding> region <region> email <email> and contact number <contactNumber>
    Then User got success with 200 response from <API>
    And User got an ID in the response body from <API>
    Examples:
      | API                            | User                         | eventType    | serviceType | dataType          | branding    | region | email           | contactNumber |
      | CreateNotificationSubscription | notificationtest@theta.co.nz | StatusUpdate | TransportNz | ConsignmentNumber | Mainfreight | MFT    | test2@email.com | +64224695500  |

  @NotificationTests
  Scenario Outline: Verify Update NotificationSubscription API
    Given User generates the Session secret for <User>
    When User calls <API_1> with eventType <eventType> serviceType <serviceType> dataType <dataType> branding <branding> region <region> email <email_pre> and contact number <contactNumber_pre>
    And User got an ID in the response body from <API_1>
    And User calls <API_2> with eventType <eventType> serviceType <serviceType> dataType <dataType> branding <branding> region <region> email <email_post> and contact number <contactNumber_post>
    Then User got success with 200 response from <API_2>
    And User got an ID in the response body from <API_2>
    Examples:
      | API_1                          | API_2                          | User                         | eventType    | serviceType | dataType          | branding    | region | email_pre      | contactNumber_pre | email_post      | contactNumber_post |
      | CreateNotificationSubscription | UpdateNotificationSubscription | notificationtest@theta.co.nz | StatusUpdate | TransportNz | ConsignmentNumber | Mainfreight | MFT    | test@email.com | +64224695500      | test1@email.com | +64224695501       |