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
import java.util.ArrayList;
import java.util.List;
import turbo.bussiness.PaypalConfig;

/**
 *
 * @author Vinlq
 */
@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @RequestMapping(value = {"/create"},
            method = {RequestMethod.POST},
            consumes = {MediaType.ALL_VALUE},
            produces = {MediaType.ALL_VALUE})
    @ResponseBody
    public ResponseEntity<String> createPayment(@RequestBody String model) {
        String result = "";
        ResponseEntity<String> entity = null;
        JSONObject data = new JSONObject(model);
        System.out.println(model);
        Payment p =  sendCreatePayment(data);
        if (p == null) {
            result = "{mess:'payment failure'}";
            entity = new ResponseEntity<String>(result, HttpStatus.BAD_REQUEST);
        }
        else {
            result = p.toJSON();
            entity = new ResponseEntity<String>(result, HttpStatus.OK);
        }
        
        return entity;
    }
  
    private Payment sendCreatePayment(JSONObject data) {
        String token = PaypalConfig.getAccessToken();
        JSONObject paymentinfo = data;
        JSONObject JSONPayer = paymentinfo.getJSONObject("payer");
        JSONObject JSONCreditCard = JSONPayer.getJSONArray("funding_instruments")
                .getJSONObject(0).getJSONObject("credit_card");
        JSONObject JSONTransaction= paymentinfo.getJSONArray("transactions")
                .getJSONObject(0);
        Payment	createdPayment = null;
        try {                   
            Address billingAddress = new Address();
            billingAddress.setCity(JSONCreditCard.getJSONObject("billing_address").getString("city"));
            billingAddress.setCountryCode(JSONCreditCard.getJSONObject("billing_address").getString("country_code"));
            billingAddress.setLine1(JSONCreditCard.getJSONObject("billing_address").getString("line1"));
            billingAddress.setPostalCode(JSONCreditCard.getJSONObject("billing_address").getString("postal_code"));
            billingAddress.setState(JSONCreditCard.getJSONObject("billing_address").getString("state"));

            CreditCard creditCard = new CreditCard();
            creditCard.setBillingAddress(billingAddress);
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
    
    private Amount getAmount(JSONObject JSONTransaction){
        Details details = new Details();
            details.setShipping(JSONTransaction.getJSONObject("amount")
                    .getJSONObject("details").getString("shipping"));
            details.setSubtotal(JSONTransaction.getJSONObject("amount")
                    .getJSONObject("details").getString("subtotal"));
            details.setTax(JSONTransaction.getJSONObject("amount")
                    .getJSONObject("details").getString("tax"));


            Amount amount = new Amount();
            amount.setCurrency(JSONTransaction.getJSONObject("amount").getString("currency"));
            amount.setTotal(JSONTransaction.getJSONObject("amount").getString("total"));
            amount.setDetails(details);
            
            return amount;
    }

}
