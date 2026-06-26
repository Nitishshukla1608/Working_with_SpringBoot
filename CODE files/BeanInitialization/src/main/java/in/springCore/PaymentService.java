package in.springCore;


import jdk.jfr.Label;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class PaymentService {

    public PaymentService() {
        System.out.println("PaymentService()");
    }
}
