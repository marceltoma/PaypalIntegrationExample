package com.example.PaypalDemoStore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.braintreepayments.http.HttpResponse;
import com.braintreepayments.http.serializer.Json;
import com.paypal.orders.*;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkout")
public class PaypalTransactionComplete extends PaypalClient {

    @RequestMapping(value = "/createOrder", method = RequestMethod.POST)
    public String createOrder(boolean debug) throws IOException {
        OrdersCreateRequest request = new OrdersCreateRequest();
        request.prefer("return=representation");
        request.requestBody(buildRequestBody());
        // 3. Call PayPal to set up a transaction
        HttpResponse<Order> response = client().execute(request);
        if (true) {
            if (response.statusCode() == 201) {
                System.out.println("Status Code: " + response.statusCode());
                System.out.println("Status: " + response.result().status());
                System.out.println("Order ID: " + response.result().id());
                System.out.println("Intent: " + response.result().intent());
                System.out.println("Links: ");
                for (LinkDescription link : response.result().links()) {
                    System.out.println("\t" + link.rel() + ": " + link.href() + "\tCall Type: " + link.method());
                }
                System.out.println("Total Amount: " + response.result().purchaseUnits().get(0).amount().currencyCode()
                        + " " + response.result().purchaseUnits().get(0).amount().value());
            }
        }
        return new JSONObject(new Json().serialize(response.result())).toString(4);
    }

    /**
     * Method to generate sample create order body with CAPTURE intent
     *
     * @return OrderRequest with created order request
     */
    private OrderRequest buildRequestBody() {
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.intent("CAPTURE");

        ApplicationContext applicationContext = new ApplicationContext().brandName("Emoji Shop").landingPage("BILLING")
                .shippingPreference("SET_PROVIDED_ADDRESS");
        orderRequest.applicationContext(applicationContext);

        List<PurchaseUnitRequest> purchaseUnitRequests = new ArrayList<PurchaseUnitRequest>();
        PurchaseUnitRequest purchaseUnitRequest = new PurchaseUnitRequest().referenceId("PUHF")
                .description("Sporting Goods").customId("HappyEmoji-01").softDescriptor("HappyEmojiWithBlink")
                .amount(new AmountWithBreakdown().currencyCode("USD").value("11.00")
                        .breakdown(new AmountBreakdown().itemTotal(new Money().currencyCode("USD").value("10.00"))
                                .shipping(new Money().currencyCode("USD").value("10.00"))
                                .handling(new Money().currencyCode("USD").value("0.00"))
                                .taxTotal(new Money().currencyCode("USD").value("1.00"))
                                .shippingDiscount(new Money().currencyCode("USD").value("10.00"))))
                .items(new ArrayList<Item>() {
                    {
                        add(new Item().name("Happy Emoji").description("A Happy Emoji image").sku("sku01")
                                .unitAmount(new Money().currencyCode("USD").value("10.00"))
                                .tax(new Money().currencyCode("USD").value("1.00")).quantity("1"));

                    }
                })
                .shipping(new ShippingDetails().name(new Name().fullName("John Doe"))
                        .addressPortable(new AddressPortable().addressLine1("123 Townsend St").addressLine2("Floor 6")
                                .adminArea2("San Francisco").adminArea1("CA").postalCode("94107").countryCode("US")));
        purchaseUnitRequests.add(purchaseUnitRequest);
        orderRequest.purchaseUnits(purchaseUnitRequests);
        return orderRequest;
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public String getOrder(@PathVariable("id") String id) throws IOException {
        OrdersGetRequest request = new OrdersGetRequest(id);
        // 3. Call PayPal to get the transaction
        HttpResponse<Order> response = client().execute(request);
        // 4. Save the transaction in your database. Implement logic to save transaction
        // to your database for future reference.
        System.out.println("Full response body:");
        System.out.println(new JSONObject(new Json().serialize(response.result())).toString(4));
        return new JSONObject(new Json().serialize(response.result())).toString(4);
    }

}