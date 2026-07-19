package com.taskflow.RazorpayPaymentGateway.Controller;

import com.razorpay.RazorpayException;
import com.taskflow.RazorpayPaymentGateway.Service.RazorPayService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final RazorPayService razorPayService;

    public PaymentController(RazorPayService razorPayService) {
        this.razorPayService = razorPayService;
    }

    @PostMapping("/create")
    public String createOrder(@RequestParam int amount,
                              @RequestParam String currency) throws RazorpayException {

        return razorPayService.createOrder(amount, currency, "order-345");
    }
}