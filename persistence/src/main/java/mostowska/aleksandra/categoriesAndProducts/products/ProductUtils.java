package mostowska.aleksandra.categoriesAndProducts.products;

import java.math.BigDecimal;
import java.util.List;

import static mostowska.aleksandra.categoriesAndProducts.CategoriesAndProducts.logger;

public interface ProductUtils {
    static BigDecimal getTotalSpending(List<Product> productsPurchased) {
        if (productsPurchased == null || productsPurchased.isEmpty()) {
            logger.error("There are no products purchased.");
            throw new IllegalArgumentException("No products in purchased products.");
        }

        return productsPurchased
                .stream()
                .map(ProductMapper.toPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
