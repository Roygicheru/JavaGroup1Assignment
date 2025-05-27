package products;

import java.util.List;
import java.util.Scanner;

public class ProductImpl implements ProductI{


    @Override
    public Product createProduct(Product product, ProductType productType) {
        product.setProductType(productType);
        return product;
    }

    @Override
    public List<Product> getProducts() {
        return List.of();
    }

    @Override
    public Product applyDiscount(Product product) throws Exception {

        ProductType productType = product.getProductType();
        if (productType == null){
            throw new Exception("Product type not set." + product.getId());
        }

        double discountTotal = 0.0;

        if (productType.getPercentageDiscount() != null){
            discountTotal = productType.getPercentageDiscount() * product.getPrice();
        }

        product.getProductType().getPercentageDiscount();

        Discount discount = new Discount();
        discount.setDescription("Discount for product Id " + product.getId());
        discount.setTotal(discountTotal);

        product.setPrice(product.getPrice() - discountTotal);

        return product;
        
    }

//    @Override
//    public Product purchaseProduct(Product product) {
//        while(true){
//            Scanner scanner = new Scanner(System.in);
//
//            System.out.println("Welcome " );
//
//        }
//    }
}
