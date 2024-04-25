package mostowska.aleksandra.app.repository.fileHandler.impl;

import com.google.gson.GsonBuilder;
import mostowska.aleksandra.app.repository.fileHandler.FileHandler;
import mostowska.aleksandra.categoriesAndProducts.CategoriesAndProducts;
import mostowska.aleksandra.categoriesAndProducts.customers.Customers;
import mostowska.aleksandra.categoriesAndProducts.preferences.Preferences;
import mostowska.aleksandra.json.converter.imp.GsonConverter;
import mostowska.aleksandra.json.deserializer.impl.CategoriesAndProductsJsonDeserializer;
import mostowska.aleksandra.json.deserializer.impl.CustomersJsonDeserializer;
import mostowska.aleksandra.json.deserializer.impl.PreferencesJsonDeserializer;
import com.google.gson.Gson;

public class FileHandlerImpl implements FileHandler {
    private static final Gson gson =  new GsonBuilder().setPrettyPrinting().create();

    public Customers getCustomersFromJson(String filename) {
        var gsonConverter = new GsonConverter<Customers>(gson);
        var customersJsonDeserializer = new CustomersJsonDeserializer(gsonConverter);
        return customersJsonDeserializer.deserialize(filename);
    }

    public CategoriesAndProducts getCategoriesAndProductsFromJson(String filename) {
        var gsonConverter = new GsonConverter<CategoriesAndProducts>(gson);
        var productsJsonDeserializer = new CategoriesAndProductsJsonDeserializer(gsonConverter);
        return productsJsonDeserializer.deserialize(filename);
    }

    public Preferences getPreferencesFromJson(String filename) {
        var gsonConverter = new GsonConverter<Preferences>(gson);
        var preferencesJsonDeserializer = new PreferencesJsonDeserializer(gsonConverter);
        return preferencesJsonDeserializer.deserialize(filename);
    }
}
