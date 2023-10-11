package foundation.oop.socialmedia;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SocialMedia {
    private List<Post> listOfPosts;

    public SocialMedia() {
        this.listOfPosts = new ArrayList<>();
    }

    public Post getLatest() {
        return this.listOfPosts.get(this.listOfPosts.size() - 1);
    }

    public void addPost(Post post) {
        this.listOfPosts.add(post);
    }

    public void showPosts() {
        for (Post p : this.listOfPosts) {
            System.out.println(p.getContent());
        }
    }

    public void showPopularPosts() {
        for (Post p : this.listOfPosts) {
            if (p.getScore() > 5) {
                System.out.println(p.getContent());
            }
        }
    }

    public void boostPopularity() {
        for (Post p : this.listOfPosts) {
            int chance = new Random().nextInt(5);
            switch (chance) {
                case 0:
                case 1:
                case 2:
                    p.likeCount += new Random().nextInt(8) + 3;
                    break;
                case 3:
                    p.dislikeCount += 5;
                    break;
                case 4:
                    break;
            }
        }
    }
}
