/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import turbo.bussiness.PaypalConfig;
import turbo.service.UserBillDAO;
import turbo.service.UserBillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import turbo.bussiness.PaypalConfig;
import turbo.service.CurrencyService;

/**
 *
 * @author Vinlq
 */
@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Autowired

    private UserBillService userBillService;

    private CurrencyService currencyService = new CurrencyService();

    @RequestMapping(value = {"/create"},
            method = {RequestMethod.POST},
            consumes = {MediaType.ALL_VALUE},
            produces = {MediaType.ALL_VALUE})
    @ResponseBody
    public ResponseEntity<String> createPayment(@RequestBody String model, HttpServletRequest request) {
        String token = extractHeaderToken(request);
        System.out.println("TOKEN" + token);
        String result = "";
        ResponseEntity<String> entity = null;
        JSONObject data = new JSONObject(model).getJSONObject("paymentinfo");
        System.out.println(model);
        Payment p = sendCreatePayment(data);
        if (p == null) {
            result = "{mess:'payment failure'}";
            entity = new ResponseEntity<String>(result, HttpStatus.BAD_REQUEST);
        } else {
            result = p.toJSON();
            entity = new ResponseEntity<String>(result, HttpStatus.OK);

            //Save bill here....
           
            userBillService.addNewUserBill(model, token);
        }

        return entity;
    }

    private Payment sendCreatePayment(JSONObject data) {
        String token = PaypalConfig.getAccessToken();
        JSONObject paymentinfo = data;
        JSONObject JSONPayer = paymentinfo.getJSONObject("payer");
        JSONObject JSONCreditCard = JSONPayer.getJSONArray("funding_instruments")
                .getJSONObject(0).getJSONObject("credit_card");
        JSONObject JSONTransaction = paymentinfo.getJSONArray("transactions")
                .getJSONObject(0);
        System.out.println(JSONTransaction.toString());
        Payment createdPayment = null;
        try {
//            Address billingAddress = new Address();
//            billingAddress.setCity(JSONCreditCard.getJSONObject("billing_address").getString("city"));
//            billingAddress.setCountryCode(JSONCreditCard.getJSONObject("billing_address").getString("country_code"));
//            billingAddress.setLine1(JSONCreditCard.getJSONObject("billing_address").getString("line1"));
//            billingAddress.setPostalCode(JSONCreditCard.getJSONObject("billing_address").getString("postal_code"));
//            billingAddress.setState(JSONCreditCard.getJSONObject("billing_address").getString("state"));

            CreditCard creditCard = new CreditCard();
            //  creditCard.setBillingAddress(billingAddress);
            creditCard.setCvv2(JSONCreditCard.getInt("cvv2"));
            creditCard.setExpireMonth(JSONCreditCard.getInt("expire_month"));
            creditCard.setExpireYear(JSONCreditCard.getInt("expire_year"));
            creditCard.setFirstName(JSONCreditCard.getString("first_name"));
            creditCard.setLastName(JSONCreditCard.getString("last_name"));
            creditCard.setNumber(JSONCreditCard.getString("number"));
            creditCard.setType(JSONCreditCard.getString("type"));

            FundingInstrument fundingInstrument = new FundingInstrument();
            fundingInstrument.setCreditCard(creditCard);

            List<FundingInstrument> fundingInstrumentList = new ArrayList<FundingInstrument>();
            fundingInstrumentList.add(fundingInstrument);

            Payer payer = new Payer();
            payer.setFundingInstruments(fundingInstrumentList);
            payer.setPaymentMethod(JSONPayer.getString("payment_method"));

            Transaction transaction = new Transaction();
            transaction.setAmount(getAmount(JSONTransaction));
            transaction.setDescription(JSONTransaction.getString("description"));

//            List<Item> items = new ArrayList<Item>();
//            ItemList itemList = new ItemList();
//            JSONObject cart = paymentinfo.getJSONObject("cart");
//            Item item = new Item();
//            item.setName("Ground Coffee 40 oz").setQuantity("1").setCurrency("USD").setPrice("5");           
//            items.add(item);
//            
//            itemList.setItems(items);
//
//            transaction.setItemList(itemList);
            List<Transaction> transactions = new ArrayList<Transaction>();
            transactions.add(transaction);

            Payment payment = new Payment();
            payment.setPayer(payer);
            payment.setIntent(paymentinfo.getString("intent"));
            payment.setTransactions(transactions);

            System.out.println(payment);
            APIContext apiContext = new APIContext(token);

            createdPayment = payment.create(apiContext);

        } catch (PayPalRESTException ex) {
            Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return createdPayment;
    }

    private Amount getAmount(JSONObject JSONTransaction) {
        DecimalFormat df = new DecimalFormat("0.##");

        System.out.println("SHIPP" + JSONTransaction.getJSONObject("amount")
                .getJSONObject("details").getDouble("shipping"));
        double shipping = JSONTransaction.getJSONObject("amount")
                .getJSONObject("details").getDouble("shipping") / currencyService.getRateVNDtoUSD();
        double tax = JSONTransaction.getJSONObject("amount")
                .getJSONObject("details").getDouble("tax") / currencyService.getRateVNDtoUSD();
        double subtotal = JSONTransaction.getJSONObject("amount")
                .getJSONObject("details").getDouble("subtotal") / currencyService.getRateVNDtoUSD();
        double total = JSONTransaction.getJSONObject("amount").getDouble("total") / currencyService.getRateVNDtoUSD();

        Details details = new Details();
        details.setShipping(df.format(shipping));
        details.setSubtotal(df.format(subtotal));
        details.setTax(df.format(tax));

        Amount amount = new Amount();
        amount.setCurrency(JSONTransaction.getJSONObject("amount").getString("currency"));
        amount.setTotal(df.format(total));
        amount.setDetails(details);

        return amount;
    }

    protected String extractHeaderToken(HttpServletRequest request) {
        try {
            Enumeration<String> headers = request.getHeaders("Authorization");
            while (headers.hasMoreElements()) { // typically there is only one (most servers enforce that)
                String value = headers.nextElement();
                if ((value.toLowerCase().startsWith(OAuth2AccessToken.BEARER_TYPE.toLowerCase()))) {
                    String authHeaderValue = value.substring(OAuth2AccessToken.BEARER_TYPE.length()).trim();

                    return authHeaderValue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}
