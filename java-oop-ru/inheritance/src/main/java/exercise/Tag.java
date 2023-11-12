package exercise;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    private String tagName;
    private Map<String, String> keyValues;

    public Tag(String tagName, Map<String, String> keyValues) {
        this.tagName = tagName;
        this.keyValues = keyValues;
    }

    public String toString() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>(getKeyValues());
        StringBuilder result = new StringBuilder();
        result.append("<").append(getTagName());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            result.append(String.format(" %s=\"%s\"", entry.getKey(), entry.getValue()));
        }
        result.append(">");
        return result.toString();
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Map<String, String> getKeyValues() {
        return keyValues;
    }

    public void setKeyValues(Map<String, String> keyValues) {
        this.keyValues = keyValues;
    }
}
// END
