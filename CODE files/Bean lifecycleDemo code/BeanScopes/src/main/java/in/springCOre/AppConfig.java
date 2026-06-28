package in.springCOre;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan
public class AppConfig {


     @Bean
      public OrderService getOrder(){
          return  new OrderService();
    }

    @Bean
    public OrderService getOrder2(){
        return  new OrderService();
    }
}
