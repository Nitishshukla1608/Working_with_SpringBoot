package in.taskflow.springCoreDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringCoreDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringCoreDemoApplication.class, args);

		OrderService orderService =  context.getBean(OrderService.class);
		orderService.palceOrder();

	}

}
