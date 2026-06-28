package in.springCore;

import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component

public class OrderService {

    PaymentService paymentService;

    public OrderService(@Lazy PaymentService paymentService)     // yahan pat paymentService ki proxy object banegi agat yahi hai toh jo same paymentService jaisi hogi ooat uske methods nhi use ho paayennge
                                                            // jab ham paymentService ka koi object banaayenge to jaake uska method banegaa


    public void placeOrder() {
        paymentService.pay();
        System.out.println("Order placed");
    }
}
