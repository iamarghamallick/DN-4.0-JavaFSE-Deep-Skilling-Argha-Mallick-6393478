public class Main {
    public static void main(String[] args) {

        PaymentContext paymentContext = new PaymentContext();
        int amount = 100;

        // Pay using Credit Card
        paymentContext.setPaymentStrategy(new CreditCardPayment());
        paymentContext.makePayment(amount);

        // Switch to paying with PayPal
        paymentContext.setPaymentStrategy(new PayPalPayment());
        paymentContext.makePayment(amount);
    }
}