package mostowska.aleksandra.categoriesAndProducts.customers;

import mostowska.aleksandra.categoriesAndProducts.products.Product;
import mostowska.aleksandra.categoriesAndProducts.products.ProductMapper;
import mostowska.aleksandra.categoriesAndProducts.preferences.Preferences;
import mostowska.aleksandra.categoriesAndProducts.preferences.PreferencesUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface CustomerUtils {
    static List<Product> getProductsByPreferences(Customer customer,
                                                            List<Map<String, List<Product>>> categoriesAndProducts,
                                                            Preferences preferences) {


        var prefs = PreferencesUtils.getPreferencesNames(preferences, customer.preferences);
        var cash = customer.cash;
        var purchased = new ArrayList<Product>();

        var onlyPreferredCategories = categoriesAndProducts
                .stream()
                .filter(category -> prefs
                        .stream()
                        .anyMatch(category::containsKey))
                .toList();

        for (var pref : onlyPreferredCategories) {
            for (var product : pref.values().stream().flatMap(Collection::stream).toList()) {
                var productPrice = ProductMapper.toPrice.apply(product);
                if (cash.compareTo(productPrice) >= 0) {
                    purchased.add(product);
                    cash = cash.subtract(productPrice);
                }
            }
        }

        return purchased;
    }
}
