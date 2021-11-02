package my.compary.cdi.demo;

public class NoItemAvailableException extends RuntimeException {

    public NoItemAvailableException(Product product) {
        super("There is no product in the stock, please, check another product. The id " + product.getId());
    }
}
