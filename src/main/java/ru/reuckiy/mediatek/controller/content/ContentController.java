package ru.reuckiy.mediatek.controller.content;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.reuckiy.mediatek.model.News;
import ru.reuckiy.mediatek.model.Post;
import ru.reuckiy.mediatek.repository.NewsRepository;
import ru.reuckiy.mediatek.repository.PostRepository;

import java.util.List;

@Controller
@RequestMapping("/content")
public class ContentController {

    private final NewsRepository newsRepository;
    private final PostRepository postRepository;

    public ContentController(NewsRepository newsRepository, PostRepository postRepository) {
        this.newsRepository = newsRepository;
        this.postRepository = postRepository;
    }

    @GetMapping
    public String contentPage(Model model) {
        List<News> listNews = newsRepository.findAll();
        List<Post> listPost = postRepository.findAll();

        model.addAttribute("title", "Content");
        model.addAttribute("listNews", listNews);
        model.addAttribute("listPost", listPost);
        return "admin/content/content";
    }
}
