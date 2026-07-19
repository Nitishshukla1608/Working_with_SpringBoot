package com.taskflow.RazorpayPaymentGateway.Service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RazorPayService {

    @Value("${razorpay.api.key}")
    private String apiKey;

    @Value("${razorpay.secret.key}")
    private String secretKey;

    public String createOrder(int amount, String currency, String receipt) throws RazorpayException {

        System.out.println("API Key = " + apiKey);
        System.out.println("Secret = " + secretKey);

        RazorpayClient razorpayClient = new RazorpayClient(apiKey, secretKey);

        JSONObject razorpayRequest = new JSONObject();
        razorpayRequest.put("amount", amount * 100);
        razorpayRequest.put("currency", currency);
        razorpayRequest.put("receipt", receipt);

        Order order = razorpayClient.orders.create(razorpayRequest);

        return order.toString();
    }
}