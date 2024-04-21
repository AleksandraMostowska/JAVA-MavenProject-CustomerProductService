package mostowska.aleksandra.json.deserializer.impl;

import mostowska.aleksandra.json.converter.JsonConverter;
import mostowska.aleksandra.json.deserializer.JsonDeserializer;
import mostowska.aleksandra.json.deserializer.generic.AbstractJsonDeserializer;
import mostowska.aleksandra.categoriesAndProducts.CategoriesAndProducts;

public class CategoriesAndProductsJsonDeserializer extends AbstractJsonDeserializer<CategoriesAndProducts> implements JsonDeserializer<CategoriesAndProducts> {
    public CategoriesAndProductsJsonDeserializer(JsonConverter<CategoriesAndProducts> converter) {
        super(converter);
    }
}
