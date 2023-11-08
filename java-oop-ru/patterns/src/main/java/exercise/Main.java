package exercise;

public class Main {
    public static void main(String[] args) {
        TagInterface tag = new InputTag("submit", "Save");
        System.out.println(tag.render());
        System.out.println();
        TagInterface labelTag = new LabelTag("Press Submit", tag);
        System.out.println(labelTag.render());
    }
}
