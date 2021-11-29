package ru.reuckiy.mediatek.rest.content;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import ru.reuckiy.mediatek.model.News;
import ru.reuckiy.mediatek.repository.NewsRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsRestController {
    private final NewsRepository newsRepository;

    public NewsRestController(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @GetMapping
    public List<News> NewsList() {
        return newsRepository.findAll();
    }

    @GetMapping("{id}")
    public News getOneNews(@PathVariable("id") News NewNews) {
        return NewNews;
    }

    @PostMapping
    public News createNews(@RequestBody News newNews) {
        newNews.setCreationDate(LocalDateTime.now());
        return newsRepository.save(newNews);
    }

    @PutMapping("{id}")
    public News updateNews(@PathVariable("id") News newsFromDb,
                           @RequestBody News newNews) {
        BeanUtils.copyProperties(newNews, newsFromDb, "id");
        return newsRepository.save(newsFromDb);
    }

    @DeleteMapping("{id}")
    public void deleteNews(@PathVariable("id") News newNews) {
        newsRepository.delete(newNews);

    }
}
