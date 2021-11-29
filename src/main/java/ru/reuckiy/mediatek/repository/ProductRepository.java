package ru.reuckiy.mediatek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.reuckiy.mediatek.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAll();
}
