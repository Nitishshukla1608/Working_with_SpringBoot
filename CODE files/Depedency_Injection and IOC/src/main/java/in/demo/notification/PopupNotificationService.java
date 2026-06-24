package in.demo.notification;

public class PopupNotificationService  implements NotificationService {

    @Override
    public void sendNotification() {
        System.out.println("PopUp notification sent");
    }
}
