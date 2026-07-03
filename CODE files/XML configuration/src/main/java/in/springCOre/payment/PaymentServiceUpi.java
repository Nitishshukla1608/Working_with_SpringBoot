package in.springCOre.payment;

public class PaymentServiceUpi implements PaymentService {
    @Override
    public void pay(){
        System.out.println("Payment done by UPI");
    }
}
