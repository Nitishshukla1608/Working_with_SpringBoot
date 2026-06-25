package in.springCore.Payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component
//@Qualifier("card")
public class CardPayment implements PaymentService {

    @Override
    public void pay(){
        System.out.println("Paid via Card");
    }
}
