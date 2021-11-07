package my.company.cdi.demo;

public class DefaultPaymentService implements PaymentService {

    @Override
    public void pay(User user, Product product) {
        throw new UnsupportedOperationException("We should not use this on test");
    }
}
