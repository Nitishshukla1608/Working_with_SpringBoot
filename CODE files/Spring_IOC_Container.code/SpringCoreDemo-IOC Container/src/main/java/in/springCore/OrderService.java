package in.springCore;

import in.springCore.Payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


public class OrderService {

    //private PaymentService paymentService;

    //@Autowired
    private PaymentService paymentService; //   ---->  This is called field injection


    //@Autowired
    //public void setPaymentService(PaymentService paymentService) {
    //    this.paymentService = paymentService;
    //}    --->  This is called Setter Injection




    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }                   // ---->  This is called constructor Injection


    public void placeOrder(){

        paymentService.pay();
        System.out.println("Order Placed");
    }
}
