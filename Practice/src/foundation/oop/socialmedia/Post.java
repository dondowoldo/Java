package foundation.oop.socialmedia;

public abstract class Post {
    protected int likeCount;
    protected int dislikeCount;

    public Post() {
        this.likeCount = 1;
        this.dislikeCount = 0;
    }

    public void likePost() {
        this.likeCount += 1;
    }

    public void dislikePost() {
        this.dislikeCount += 1;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public int getDislikeCount() {
        return dislikeCount;
    }

    public int getScore() {
        return this.likeCount - this.dislikeCount;
    }
    public abstract String getContent();
}
