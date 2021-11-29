package ru.reuckiy.mediatek.rest.content;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import ru.reuckiy.mediatek.model.Post;
import ru.reuckiy.mediatek.repository.PostRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostRestController {
    public final PostRepository postRepository;

    public PostRestController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping
    public List<Post> PostList() {
        return postRepository.findAll();
    }

    @GetMapping("{id}")
    public Post getOnePost(@PathVariable("id") Post newPost) {
        return newPost;
    }

    @PostMapping
    public Post createNews(@RequestBody Post newPost) {
        newPost.setCreationDate(LocalDateTime.now());
        return postRepository.save(newPost);
    }

    @PutMapping("{id}")
    public Post updateNews(@PathVariable("id") Post postFromDb,
                           @RequestBody Post newPost) {
        BeanUtils.copyProperties(newPost, postFromDb, "id");
        return postRepository.save(postFromDb);
    }

    @DeleteMapping("{id}")
    public void deleteNews(@PathVariable("id") Post newPost) {
        postRepository.delete(newPost);

    }
}
