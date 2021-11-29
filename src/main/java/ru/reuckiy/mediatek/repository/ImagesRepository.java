package ru.reuckiy.mediatek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.reuckiy.mediatek.model.Images;

import java.util.List;

public interface ImagesRepository extends JpaRepository<Images, Long> {
    List<Images> findAll();
}
