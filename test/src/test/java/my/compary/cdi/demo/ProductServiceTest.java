package my.compary.cdi.demo;

import my.company.cdi.api.CDIExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@CDIExtension
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Inject
    private ProductRepository repository;

    @Mock
    private PaymentService paymentService;

    private ProductService service;

    @BeforeEach
    public void setUp() {
      this.service = new ProductService(paymentService, repository);
    }

    @Test
    public void test() {
        Assertions.assertNotNull(service);
    }
}