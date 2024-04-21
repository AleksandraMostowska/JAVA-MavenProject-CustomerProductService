package mostowska.aleksandra.json.deserializer.impl;

import mostowska.aleksandra.json.converter.JsonConverter;
import mostowska.aleksandra.json.deserializer.JsonDeserializer;
import mostowska.aleksandra.json.deserializer.generic.AbstractJsonDeserializer;
import mostowska.aleksandra.categoriesAndProducts.preferences.Preferences;

public class PreferencesJsonDeserializer extends AbstractJsonDeserializer<Preferences> implements JsonDeserializer<Preferences> {
    public PreferencesJsonDeserializer(JsonConverter<Preferences> converter) {
        super(converter);
    }
}
