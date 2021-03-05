package persistence;

import org.json.JSONObject;

public interface Writable {
    // EFFECTS: returns this as JSON object
    // code based on https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    JSONObject toJson();
}
