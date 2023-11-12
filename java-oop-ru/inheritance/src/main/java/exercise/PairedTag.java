package exercise;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {

    private String tagText;
    private List<Tag> childen;

    public PairedTag(String tagName, Map<String, String> keyValues, String tagText, List<Tag> childen) {
        super(tagName, keyValues);
        this.tagText = tagText;
        this.childen = childen;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(super.toString());

        for (Tag child : childen) {
            result.append(child.toString());
        }

        result.append(tagText).append("</").append(super.getTagName()).append(">");
        return result.toString();
    }
}
// END
