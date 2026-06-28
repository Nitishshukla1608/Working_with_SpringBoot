package in.springCore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


OrderService orderService =  context.getBean(OrderService.class);

//PaymentService  paymentService =  context.getBean(PaymentService.class);   //  jab maangenge inhe toh IOC object banaayega in sace od @Lazy
       System.out.println("Payment service not started yet");
        orderService.placeOrder();
    }
}
