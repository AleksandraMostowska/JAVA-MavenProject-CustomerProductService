package mostowska.aleksandra.app.repository;

import mostowska.aleksandra.categoriesAndProducts.customers.Customer;
import mostowska.aleksandra.categoriesAndProducts.products.Product;

import java.util.List;
import java.util.Map;

public interface CustomersProductsRepository {
    Map<Customer, List<Product>> customersWithProducts();
}
