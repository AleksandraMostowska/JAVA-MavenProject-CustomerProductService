package mostowska.aleksandra.app.service.extensions;

import mostowska.aleksandra.app.repository.impl.CustomersProductsRepositoryImpl;
import mostowska.aleksandra.app.service.impl.CustomersProductsServiceImpl;
import mostowska.aleksandra.categoriesAndProducts.customers.Customer;
import mostowska.aleksandra.categoriesAndProducts.products.Product;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import mostowska.aleksandra.app.service.ProductData;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomersProductsServiceImplResolver implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(CustomersProductsServiceImpl.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        var repository = new CustomersProductsRepositoryImpl(Map.of(
                new Customer(1, "A", "B", 20, BigDecimal.valueOf(100), List.of(1, 2, 3)),
                List.of(ProductData.PRODUCT_1, ProductData.PRODUCT_2, ProductData.PRODUCT_3),
                new Customer(2, "C", "D", 10, BigDecimal.valueOf(200), List.of(2, 3, 4)),
                List.of(ProductData.PRODUCT_1, ProductData.PRODUCT_2, ProductData.PRODUCT_3),
                new Customer(3, "E", "F", 30, BigDecimal.valueOf(50), List.of(1)),
                List.of(ProductData.PRODUCT_1)
        ));

        return new CustomersProductsServiceImpl(repository);
    }
}
