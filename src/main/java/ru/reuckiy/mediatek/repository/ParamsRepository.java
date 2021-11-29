package ru.reuckiy.mediatek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.reuckiy.mediatek.model.Params;

import java.util.List;

public interface ParamsRepository extends JpaRepository<Params, Long> {
    List<Params> findAll();
}
