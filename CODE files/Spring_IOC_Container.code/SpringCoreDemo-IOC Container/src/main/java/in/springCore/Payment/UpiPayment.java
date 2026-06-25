package in.springCore.Payment;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
//@Qualifier("upi")
public class UpiPayment implements PaymentService{

    public void pay(){
        System.out.println("Paid via UPI");
    }
}
