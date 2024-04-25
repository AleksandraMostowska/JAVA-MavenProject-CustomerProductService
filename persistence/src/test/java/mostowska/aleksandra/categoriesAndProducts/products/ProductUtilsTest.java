package mostowska.aleksandra.categoriesAndProducts.products;
import mostowska.aleksandra.categoriesAndProducts.products.ProductUtils;

import mostowska.aleksandra.categoriesAndProducts.products.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

public class ProductUtilsTest {

    @Test
    @DisplayName("When purchased products are null")
    void whenPurchasedProductsAreNull() {
        List<Product> productsPurchased = null;
        Assertions.assertThatThrownBy(() -> ProductUtils.getTotalSpending(productsPurchased))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("No products in purchased products.");

    }

    @Test
    @DisplayName("When purchased products is an empty list")
    void whenPurchasedProductsIsEmpty() {
        List<Product> productsPurchased = List.of();
        Assertions.assertThatThrownBy(() -> ProductUtils.getTotalSpending(productsPurchased))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("No products in purchased products.");

    }

    @Test
    @DisplayName("When purchased products is valid")
    void whenPurchasedProductsIsValid() {
        List<Product> productsPurchased = List.of(
                new Product(1, "P1", "C1", new BigDecimal("10.00")),
                new Product(2, "P2", "C2", new BigDecimal("20.00")),
                new Product(3, "P3", "C3", new BigDecimal("30.00"))
        );

        var expected = BigDecimal.valueOf(60);
        Assertions.assertThat(ProductUtils.getTotalSpending(productsPurchased))
                .isEqualByComparingTo(expected);

    }
}
