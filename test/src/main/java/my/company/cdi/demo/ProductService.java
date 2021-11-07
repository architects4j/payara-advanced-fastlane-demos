package my.company.cdi.demo;

import javax.inject.Inject;

public class ProductService {

    private PaymentService service;

    private ProductRepository repository;

    @Inject
    ProductService(PaymentService service, ProductRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    public void buy(Product product, User user) {
        if (repository.hasStock(product.getId())) {
            this.service.pay(user, product);
            this.repository.decrementStock(product);
            return;
        }
        throw new NoItemAvailableException(product);
    }
}
