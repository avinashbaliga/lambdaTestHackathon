package utilities;

import java.util.HashMap;
import java.util.Map;

/** The main purpose of this class is to facilitate data sharing between classes/steps.
 * set method can be used to store the data and get method can be used to get the data from data store*/

public class ScenarioContext {

    private static ThreadLocal<Map<String, Object>> data = new ThreadLocal<Map<String, Object>>();

    public static Object get(String key) {
        if (data.get().containsKey(key))
            return data.get().get(key);
        else throw new RuntimeException(key + " not found in ScenarioContext");
    }

    public static void set(String key, Object value) {
        if (data.get() == null) data.set(new HashMap<String, Object>());
        data.get().put(key, value);
    }
}
