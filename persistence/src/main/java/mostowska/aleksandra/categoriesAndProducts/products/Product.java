package mostowska.aleksandra.categoriesAndProducts.products;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@RequiredArgsConstructor
@ToString
public class Product {
    final int id;
    final String name;
    final String category;
    final BigDecimal price;

}
