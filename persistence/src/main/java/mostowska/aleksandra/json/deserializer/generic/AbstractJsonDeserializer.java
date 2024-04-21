package mostowska.aleksandra.json.deserializer.generic;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import mostowska.aleksandra.json.converter.JsonConverter;
import mostowska.aleksandra.json.deserializer.JsonDeserializer;

import java.io.FileReader;
import java.lang.reflect.ParameterizedType;

@RequiredArgsConstructor
public abstract class AbstractJsonDeserializer<T> implements JsonDeserializer<T> {
    @Getter
    private final JsonConverter<T> converter;
    @SuppressWarnings("unchecked")
    private final Class<T> tClass =
            (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    @Override
    @SneakyThrows
    public T deserialize(String filename) {
        try (var reader = new FileReader(filename)) {
            return converter.fromJson(reader, tClass);
        }
    }
}
