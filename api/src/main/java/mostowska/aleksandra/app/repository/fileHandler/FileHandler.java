package mostowska.aleksandra.app.repository.fileHandler;

import mostowska.aleksandra.categoriesAndProducts.CategoriesAndProducts;
import mostowska.aleksandra.categoriesAndProducts.customers.Customers;
import mostowska.aleksandra.categoriesAndProducts.preferences.Preferences;

public interface FileHandler {
    Customers getCustomersFromJson(String filename);
    CategoriesAndProducts getCategoriesAndProductsFromJson(String filename);
    Preferences getPreferencesFromJson(String filename);
}
