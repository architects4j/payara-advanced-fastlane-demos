package my.company.cdi.demo;

import my.company.cdi.api.CDIExtension;
import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.inject.Inject;
import javax.money.CurrencyUnit;
import javax.money.Monetary;

import java.util.Locale;

@CDIExtension
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Inject
    private ProductRepository repository;

    @Mock
    private PaymentService paymentService;

    private ProductService service;

    private CurrencyUnit currency;

    @BeforeEach
    public void setUp() {
        this.service = new ProductService(paymentService, repository);
        this.currency = Monetary.getCurrency(Locale.US);
    }

    @Test
    public void shouldNoBuyWhenStockIsEmpty() {
        Product product = new Product(1L, "Banana", Money.of(1, currency));
        User user = new User("buyer");
        Assertions.assertThrows(NoItemAvailableException.class, () -> service.buy(product, user));
    }

    @Test
    public void shouldNotBuyWhenPaymentIsRefused() {
        Product product = new Product(1L, "Banana", Money.of(1, currency));
        repository.save(product);
        User user = new User("buyer");
        Mockito.doThrow(new PaymentRefusedException()).when(paymentService)
                        .pay(user, product);
        Assertions.assertThrows(PaymentRefusedException.class, () -> service.buy(product, user));
    }

    @Test
    public void shouldBuy() {
        Product product = new Product(1L, "Banana", Money.of(1, currency));
        repository.save(product);
        User user = new User("buyer");
        Mockito.doNothing().when(paymentService).pay(user, product);
        service.buy(product, user);
    }

}