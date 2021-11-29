package ru.reuckiy.mediatek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.reuckiy.mediatek.model.News;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {
    @Override
    List<News> findAll();
}
