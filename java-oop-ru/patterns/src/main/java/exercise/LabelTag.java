package exercise;

// BEGIN
public class LabelTag implements TagInterface{
    private String textIntoTag;
    private TagInterface tag;

    public LabelTag(String textIntoTag, TagInterface tag) {
        this.textIntoTag = textIntoTag;
        this.tag = tag;
    }

    @Override
    public String render() {
        String innerTagRendered = tag.render();
        return String.format("<label>%s%s</label>", textIntoTag, innerTagRendered);
    }

}
// END
