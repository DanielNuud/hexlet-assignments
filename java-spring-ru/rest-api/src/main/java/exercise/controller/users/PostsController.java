package exercise.controller.users;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController
@RequestMapping("/api")
public class PostsController {
    private List<Post> posts = Data.getPosts();
    @GetMapping("/users/{id}/posts")
    public List<Post> index(@PathVariable int id) {
        return posts.stream()
                .filter(p -> p.getUserId() == id)
                .toList();
    }


    @PostMapping("/users/{id}/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestBody Post post, @PathVariable String id) {
        post.setUserId(Integer.parseInt(id));
        posts.add(post);
        return post;
    }
}
// END
