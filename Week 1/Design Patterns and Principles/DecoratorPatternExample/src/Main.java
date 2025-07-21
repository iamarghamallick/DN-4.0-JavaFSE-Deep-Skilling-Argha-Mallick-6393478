public class Main {
    public static void main(String[] args) {

        String message = "Hello Argha! How are you?";

//        Notifier notifier = new EmailNotifier();
//        notifier.send(message);

        Notifier emailAndSMSNotifier = new SMSNotifierDecorator(new EmailNotifier());
        emailAndSMSNotifier.send(message);
    }
}