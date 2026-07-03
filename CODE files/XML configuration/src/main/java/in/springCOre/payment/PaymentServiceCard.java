package in.springCOre.payment;

public class PaymentServiceCard implements PaymentService {
    @Override
    public void pay(){
        System.out.println("Payment done by Card");
    }
}
