package my.compary.cdi.demo;

import javax.inject.Inject;

public class ProductService {

    private PaymentService service;

    private ProductRepository repository;

    @Inject
    ProductService(PaymentService service, ProductRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    public ProductService() {
    }
}
