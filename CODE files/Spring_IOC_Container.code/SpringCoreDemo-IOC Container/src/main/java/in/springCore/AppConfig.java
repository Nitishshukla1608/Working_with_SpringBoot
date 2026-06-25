package in.springCore;

import in.springCOre.CartService;
import in.springCore.Payment.CardPayment;
import in.springCore.Payment.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("in.springCore")
public class AppConfig {

    @Bean
    public User createUser() {
        return new User("Richa", 28);
    }


    @Bean
    public CartService createCartService() {
        return new CartService();
    }


    @Bean
    public PaymentService createCardPaymentService() {
        return new CardPayment();
    }

    //@Bean
    //public PaymentService createUpiPaymentService() {
    //    return new UpiPayment ();
    //}

    @Bean
    public OrderService createOrderService(PaymentService paymentService) {
        return new OrderService(paymentService);
    }
}
