package in.springCOre;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");


        // When getBean by id
        //OrderService orderService = (OrderService) context.getBean("orderService");
        //orderService.placeOrder();


        // When getBean by type
        OrderService orderService =  context.getBean("orderService",OrderService.class);
        orderService.placeOrder();


    }
}
