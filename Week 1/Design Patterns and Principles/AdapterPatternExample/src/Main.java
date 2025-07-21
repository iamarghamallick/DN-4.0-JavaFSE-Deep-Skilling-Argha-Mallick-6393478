public class Main {
    public static void main(String[] args) {

        GooglePayGateway googlePayGateway = new GooglePayGateway();

        PaymentProcessor paymentProcessor = new GooglePayAdapter(googlePayGateway);

        paymentProcessor.pay(10);
    }
}