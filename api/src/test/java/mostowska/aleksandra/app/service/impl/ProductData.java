package mostowska.aleksandra.app.service;

import mostowska.aleksandra.categoriesAndProducts.products.Product;

import java.math.BigDecimal;

public interface ProductData {
    Product PRODUCT_1 = new Product(1, "P1", "C2",BigDecimal.valueOf(10));
    Product PRODUCT_2 = new Product(2, "P2", "C3", BigDecimal.valueOf(15));
    Product PRODUCT_3 = new Product(3, "P3", "C4", BigDecimal.valueOf(20));
}
