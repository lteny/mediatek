package ru.reuckiy.mediatek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.reuckiy.mediatek.model.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Override
    List<Post> findAll();
}
