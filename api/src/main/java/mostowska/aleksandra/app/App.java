package mostowska.aleksandra.app;

import mostowska.aleksandra.app.repository.impl.CustomersProductsRepositoryImpl;
import mostowska.aleksandra.app.service.impl.CustomersProductsServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
    private static final Logger consoleLogger = LogManager.getLogger(App.class);
    private static final Logger fileLogger = LogManager.getLogger("AMFileLogger");

    public static void main(String[] args) {
        final var CUSTOMERS_FILE = "customers.json";
        final var CATEGORIES_AND_PRODUCTS_FILE = "categoriesAndProducts.json";
        final var PREFERENCES_FILE = "preferences.json";

        var customersAndProducts = new CustomersProductsRepositoryImpl(CUSTOMERS_FILE,
                CATEGORIES_AND_PRODUCTS_FILE, PREFERENCES_FILE);
        System.out.println(customersAndProducts.customersWithProducts());

        var service = new CustomersProductsServiceImpl(customersAndProducts);
        consoleLogger.info(service);

//        fileLogger.info(service.getCustomersWhoBoughtTheMostItems());
//        fileLogger.info(service.getCustomersWhoPaidTheMost());
//        fileLogger.info(service.getProductAndHowManyTimesWasBought());
//        fileLogger.info(service.getCategoriesSortedFromMostToLeastPopular());
    }
}
