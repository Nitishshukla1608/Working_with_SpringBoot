package in.demo;

import in.demo.notification.EmailService;
import in.demo.notification.NotificationService;
import in.demo.notification.PopupNotificationService;
import in.demo.notification.SmsService;

public class OrderService {
    NotificationService notificationService;

           OrderService(NotificationService  notificationService){
               this.notificationService = notificationService;
           }



    public void placeOrder() {
        System.out.println("Order placed");
        notificationService.sendNotification();
    }
}


///    DEPEDENCY INJECTION--->

// don't create our own dependency but get your dependency........
//  a class should ask what it needs and not build everything itself




///  IOC (inversion of control )