package definitions;

import com.adyen.Client;
import com.adyen.enums.Environment;
import com.adyen.model.Amount;
import com.adyen.model.checkout.PaymentMethodsRequest;
import com.adyen.model.checkout.PaymentMethodsResponse;
import com.adyen.model.checkout.PaymentsRequest;
import com.adyen.model.checkout.PaymentsResponse;
import com.adyen.service.Checkout;
import com.adyen.service.exception.ApiException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.io.IOException;
import java.util.Map;

import static support.TestContext.getData;

public class AdyenStepDefs {
    private static Map<String, String> form = getData("adyen");

    @Given("I get available payment methods")
    public void iGetAvailablePaymentMethods() throws IOException, ApiException {
        Client client = new Client(form.get("apikey"), Environment.TEST);
        Checkout checkout = new Checkout(client);
        PaymentMethodsRequest paymentMethodsRequest = new PaymentMethodsRequest();
        paymentMethodsRequest.setMerchantAccount(form.get("merchantaccount"));
        paymentMethodsRequest.setCountryCode("US");
        paymentMethodsRequest.setShopperLocale("us-US");
        Amount amount = new Amount();
        amount.setCurrency("USD");
        amount.setValue(1500L);
        paymentMethodsRequest.setAmount(amount);
        paymentMethodsRequest.setChannel(PaymentMethodsRequest.ChannelEnum.WEB);
        PaymentMethodsResponse paymentMethodsResponse = checkout.paymentMethods(paymentMethodsRequest);
        System.out.println(paymentMethodsResponse);
    }

    @And("I perform a payment")
    public void iPerformAPayment() throws IOException, ApiException {
        Client client = new Client(form.get("apikey"),Environment.TEST);
        Checkout checkout = new Checkout(client);
        PaymentsRequest paymentsRequest = new PaymentsRequest();
        paymentsRequest.setMerchantAccount(form.get("merchantaccount"));
        paymentsRequest.addEncryptedCardData(form.get("encryptedCardNumber"),form.get("encryptedExpiryMonth"), form.get("encryptedExpiryYear"), form.get("encryptedSecurityCode"), form.get("holderName"));
        Amount amount = new Amount();
        amount.setCurrency("USD");
        amount.setValue(1500L);
        paymentsRequest.setAmount(amount);
        paymentsRequest.setReference(form.get("ordernumber"));
        paymentsRequest.setReturnUrl("https://your-company.com/checkout?shopperOrder=12xy..");
        PaymentsResponse paymentsResponse = checkout.payments(paymentsRequest);
        System.out.println(paymentsResponse);
    }
}
