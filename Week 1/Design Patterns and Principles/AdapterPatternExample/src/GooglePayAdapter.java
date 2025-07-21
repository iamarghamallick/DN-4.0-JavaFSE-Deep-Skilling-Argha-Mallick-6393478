// The Adapter class for GooglePayGateway

public class GooglePayAdapter implements PaymentProcessor {

    GooglePayGateway googlePayGateway;

    GooglePayAdapter(GooglePayGateway googlePayGateway) {
        this.googlePayGateway = googlePayGateway;
    }

    @Override
    public void pay(int amount) {
        googlePayGateway.makePayment(amount);
    }
}
