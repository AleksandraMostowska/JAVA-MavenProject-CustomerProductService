package mostowska.aleksandra.categoriesAndProducts.preferences;

import java.util.List;
import java.util.Objects;

import static mostowska.aleksandra.categoriesAndProducts.CategoriesAndProducts.logger;

public interface PreferencesUtils {
    static List<String> getPreferencesNames(Preferences preferences, List<Integer> customersPrefs) {
        if (customersPrefs == null || customersPrefs.isEmpty()) {
            logger.error("There are no customer preferences.");
            throw new IllegalArgumentException("Zero customer preferences.");
        }

        return customersPrefs
                .stream()
                .map(pref -> preferences.preferences()
                        .stream()
                                .filter(p -> Objects.equals(p.id, pref))
                                .findFirst()
                                .map(p -> p.category)
                                .orElseThrow()
                        )
                .toList();
    }
}
