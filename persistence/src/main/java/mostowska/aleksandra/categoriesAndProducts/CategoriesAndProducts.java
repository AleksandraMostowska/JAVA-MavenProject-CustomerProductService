package mostowska.aleksandra.categoriesAndProducts;


import mostowska.aleksandra.categoriesAndProducts.products.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

public record CategoriesAndProducts(List<Map<String, List<Product>>> products) {
    public static final Logger logger = LogManager.getLogger("ErrorsHandling");
}
