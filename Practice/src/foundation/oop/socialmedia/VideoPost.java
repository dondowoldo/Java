package foundation.oop.socialmedia;

public class VideoPost extends Post {
    private String url;

    public VideoPost(String url) {
        this.url = url;
    }

    @Override
    public String getContent() {
        return String.format("Video at %s | score: %d",
                this.url, this.getScore());
    }

    public String getUrl() {
        return url;
    }
}
