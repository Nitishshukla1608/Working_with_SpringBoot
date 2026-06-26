package in.springCore;

import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class OrderService {

    public OrderService() {
        System.out.println("OrderService()");
    }
}
