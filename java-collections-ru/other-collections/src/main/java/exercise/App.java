package exercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// BEGIN
public class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        for (String key1 : data1.keySet()) {
            Object value1 = data1.get(key1);

            if (!data2.containsKey(key1)) {
                map.put(key1, "deleted");
            } else {
                Object value2 = data2.get(key1);
                if (value1.equals(value2)) {
                    map.put(key1, "unchanged");
                } else {
                    map.put(key1, "changed");
                }
            }
        }

        for (String key2 : data2.keySet()) {
            if (!data1.containsKey(key2)) {
                map.put(key2, "added");
            }
        }

        return map;
    }
}
//END
