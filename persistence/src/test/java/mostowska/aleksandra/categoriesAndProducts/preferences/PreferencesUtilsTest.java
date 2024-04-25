package mostowska.aleksandra.categoriesAndProducts.preferences;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

public class PreferencesUtilsTest {
    private static Preferences prefs;

    @BeforeAll
    static void setup() {
        prefs = new Preferences(List.of(
                new Preference(1, "Electronics"),
                new Preference(2, "Groceries"),
                new Preference(3, "Furniture")
        ));
    }


    @Test
    @DisplayName("When customer's preferences are null")
    void whenPreferencesAreNull() {
        List<Integer> customersPrefs = null;
        Assertions.assertThatThrownBy(() -> PreferencesUtils.getPreferencesNames(prefs, customersPrefs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Zero customer preferences.");

    }

    @Test
    @DisplayName("When customer's preferences is an empty list")
    void whenPreferencesAreEmpty() {
        List<Integer> customersPrefs = List.of();
        Assertions.assertThatThrownBy(() -> PreferencesUtils.getPreferencesNames(prefs, customersPrefs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Zero customer preferences.");

    }

    @Test
    @DisplayName("When customer's preferences are valid")
    void whenPreferencesAreValid() {
        var customersPrefs = List.of(1, 2, 3);
        var expected = List.of("Electronics", "Groceries", "Furniture");
        Assertions.assertThat(PreferencesUtils.getPreferencesNames(prefs, customersPrefs))
                .isEqualTo(expected);

    }
}
