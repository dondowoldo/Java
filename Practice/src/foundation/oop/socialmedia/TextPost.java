package foundation.oop.socialmedia;

public class TextPost extends Post {
    private String title;
    private String text;

    public TextPost(String title, String text) {
        this.title = title;
        this.text = text;
    }

    @Override
    public String getContent() {
        return String.format("%s: %s | score: %d",
                this.title, this.text, this.getScore());
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
