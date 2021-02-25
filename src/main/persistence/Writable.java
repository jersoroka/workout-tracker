package persistence;

import org.json.JSONObject;

public interface Writable {
    // EFFECTS: returns this as JSON object
    // code attributed to JsonSerializationDemo
    JSONObject toJson();
}
