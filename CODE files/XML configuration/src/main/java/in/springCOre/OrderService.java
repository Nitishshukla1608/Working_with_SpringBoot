package in.springCOre;


import in.springCOre.payment.PaymentService;

public class OrderService {

    PaymentService paymentService;
    //public OrderService(PaymentService paymentService) {
    //    this.paymentService = paymentService ;
    //}


    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder(){
        paymentService.pay();
        System.out.println("Order placed");
    }
}
