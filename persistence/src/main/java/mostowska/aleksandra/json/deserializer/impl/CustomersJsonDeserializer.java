package mostowska.aleksandra.json.deserializer.impl;

import mostowska.aleksandra.json.converter.JsonConverter;
import mostowska.aleksandra.json.deserializer.JsonDeserializer;
import mostowska.aleksandra.json.deserializer.generic.AbstractJsonDeserializer;
import mostowska.aleksandra.categoriesAndProducts.customers.Customers;

public class CustomersJsonDeserializer extends AbstractJsonDeserializer<Customers> implements JsonDeserializer<Customers> {
    public CustomersJsonDeserializer(JsonConverter<Customers> converter) {
        super(converter);
    }
}
