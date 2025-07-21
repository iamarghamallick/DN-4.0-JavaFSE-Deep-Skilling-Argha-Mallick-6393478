public class CreditCardPayment implements PaymentStrategy {

    public CreditCardPayment() {}

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using Credit Card.");
    }
}
