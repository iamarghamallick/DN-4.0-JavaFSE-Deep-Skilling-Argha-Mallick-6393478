// concrete decorator class 1

public class SMSNotifierDecorator extends NotifierDecorator {

    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS with message: " + message);
    }

    @Override
    public void send(String message) {
        super.send(message);

        // add the new functionality
        sendSMS(message);
    }
}
