package mostowska.aleksandra.app.repository.impl;

import lombok.ToString;
import mostowska.aleksandra.app.repository.CustomersProductsRepository;
import mostowska.aleksandra.app.repository.fileHandler.impl.FileHandlerImpl;
import mostowska.aleksandra.categoriesAndProducts.customers.Customer;
import mostowska.aleksandra.categoriesAndProducts.customers.CustomerUtils;
import mostowska.aleksandra.categoriesAndProducts.products.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ToString
public class CustomersProductsRepositoryImpl implements CustomersProductsRepository {
    private final Map<Customer, List<Product>> customersAndProducts;

    public CustomersProductsRepositoryImpl(Map<Customer, List<Product>> customersAndProducts) {
        this.customersAndProducts = customersAndProducts;
    }

    public CustomersProductsRepositoryImpl(String customersFile, String categoriesAndProductsFile, String preferencesFile) {
        this.customersAndProducts = getCustomersAndProducts(customersFile, categoriesAndProductsFile, preferencesFile);
    }

    @Override
    public Map<Customer, List<Product>> customersWithProducts() {
        return customersAndProducts;
    }

    private static Map<Customer, List<Product>> getCustomersAndProducts(String customersFile, String categoriesAndProductsFile, String preferencesFile) {
        var fileHandler = new FileHandlerImpl();

        var customers = fileHandler.getCustomersFromJson(customersFile);
        if (customers == null || customers.customers().isEmpty()) {
            throw new IllegalArgumentException("No customers found");
        }

        var products = fileHandler.getCategoriesAndProductsFromJson(categoriesAndProductsFile).products();
        if (products == null || products.isEmpty()) {
            throw new IllegalArgumentException("No products found");
        }

        var preferences = fileHandler.getPreferencesFromJson(preferencesFile);
        if (preferences == null || preferences.preferences().isEmpty()) {
            throw new IllegalArgumentException("No preferences found");
        }

        return customers.customers()
                .stream()
                .collect(Collectors.toMap(
                        customer -> customer,
                        customer -> CustomerUtils.getProductsByPreferences(customer, products, preferences),
                        (oldVal, newVal) -> {
                            oldVal.addAll(newVal);
                            return oldVal;
                        },
                        HashMap::new
                ));
    }
}
