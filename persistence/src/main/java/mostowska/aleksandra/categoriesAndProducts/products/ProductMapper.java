package mostowska.aleksandra.categoriesAndProducts.products;

import java.math.BigDecimal;
import java.util.function.Function;

public interface ProductMapper {
    Function<Product, String> toCategory = p -> p.category;
    Function<Product, BigDecimal> toPrice = p -> p.price;
}
