package ru.reuckiy.mediatek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.reuckiy.mediatek.model.Categories;

import java.util.List;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {
    List<Categories> findAll();

}
