package foundation.oop.socialmedia;

public class Main {
    public static void main(String[] args) {
        Post text = new TextPost("Ahoj", "Jak se mas?");
        Post image = new ImagePost("Rick", "https://sampleurl.com/example.png");
        Post video = new VideoPost("https://www.youtube.com/watch?v=dQw4w9WgXcQ&themeRefresh=1");

        SocialMedia media = new SocialMedia();

        media.addPost(text);
        media.addPost(image);
        media.addPost(video);

        System.out.println("-----------------------SHOW ALL POSTS------------------------------");
        // SHOW ALL POSTS
        media.showPosts();
        System.out.println();

        System.out.println("-------------------SHOW POPULAR POSTS (IF ANY)---------------------");

        // SHOWS NONE
        media.showPopularPosts();
        System.out.println();

        System.out.println("-----------------------SHOW LATEST POST----------------------------");

        // SHOWS LATEST ADDED POST
        System.out.println(media.getLatest().getContent());
        System.out.println();

        System.out.println("--------------------LIKE THE LATEST POST---------------------------");

        // LIKES A POST (Increase score by 1)
        media.getLatest().likePost();
        System.out.println(media.getLatest().getContent());
        System.out.println();

        // BOOSTS POPULARITY OF ALL POSTS (60% chance + (3-10) ; 20% chance + 5 ; 20 % chance + nothing)
        System.out.println("-----------SHOW POPULAR POSTS AFTER BOOSTING POPULARITY------------");

        media.boostPopularity();

        // TRY TO GET POPULAR POSTS AGAIN IN CASE WE HAVE SOME WITH SCORE OVER 5
        media.showPopularPosts();
        System.out.println();
    }
}
