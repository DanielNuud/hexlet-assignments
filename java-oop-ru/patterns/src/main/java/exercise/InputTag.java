package exercise;

// BEGIN
public class InputTag implements TagInterface {
    private String type;
    private String input;

    public InputTag(String type, String input) {
        this.type = type;
        this.input = input;
    }

    @Override
    public String render() {
        return String.format("<input type=\"%s\" value=\"%s\">", type, input);
    }


}
// END
