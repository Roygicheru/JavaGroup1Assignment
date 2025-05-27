package products;

import java.util.List;

public interface ProductI {


    Product createProduct(Product product, ProductType productType );

    List<Product> getProducts();

    Product applyDiscount(Product product) throws Exception;

//    Product purchaseProduct(Product product);

}
