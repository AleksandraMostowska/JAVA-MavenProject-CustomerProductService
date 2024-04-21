package mostowska.aleksandra.json.deserializer;

public interface JsonDeserializer<T> {
    T deserialize (String filename);
}
