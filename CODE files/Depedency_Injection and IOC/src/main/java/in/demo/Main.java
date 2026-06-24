package in.demo;

import in.demo.notification.EmailService;
import in.demo.notification.NotificationService;
import in.demo.notification.PopupNotificationService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        NotificationService notificationService = new PopupNotificationService();
OrderService orderService = new OrderService(notificationService);
orderService.placeOrder();
    }
}
