package mostowska.aleksandra.app.service;


import mostowska.aleksandra.categoriesAndProducts.products.Product;
import mostowska.aleksandra.categoriesAndProducts.customers.Customer;

import java.util.List;
import java.util.Map;

public interface CustomersProductService {
    List<Customer> getCustomersWhoBoughtTheMostItems();
    List<Customer> getCustomersWhoPaidTheMost();
    Map<Product, Integer> getProductAndHowManyTimesWasBought();
    List<String> getCategoriesSortedFromMostToLeastPopular();

}
