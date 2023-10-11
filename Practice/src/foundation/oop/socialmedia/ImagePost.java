package foundation.oop.socialmedia;

public class ImagePost extends Post {
    private String title;
    private String url;

    public ImagePost(String title, String url) {
        this.title = title;
        this.url = url;
    }

    @Override
    public String getContent() {
        return String.format("Check out %s at %s | score: %d",
                this.title, this.url, this.getScore());
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
