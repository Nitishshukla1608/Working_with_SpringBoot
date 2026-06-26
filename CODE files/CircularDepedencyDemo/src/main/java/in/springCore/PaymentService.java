package in.springCore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    @Autowired
    OrderService orderService;

    //public PaymentService(OrderService orderService) {
    //    this.orderService = orderService;
    //}


    public void pay(){
        System.out.println("Payment done");
   //    orderService.getOrderDetails();  -> yahan iski jaroorat hi nh hai faaltu ye CD create akr raha hai...
    }
}