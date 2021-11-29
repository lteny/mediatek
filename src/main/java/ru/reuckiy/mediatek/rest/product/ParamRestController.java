package ru.reuckiy.mediatek.rest.product;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.reuckiy.mediatek.model.Params;
import ru.reuckiy.mediatek.repository.ParamsRepository;

import java.util.List;

@RestController
@RequestMapping(path = "/param", produces = MediaType.APPLICATION_JSON_VALUE)
public class ParamRestController {

    private final ParamsRepository paramsRepository;

    public ParamRestController(ParamsRepository paramsRepository) {
        this.paramsRepository = paramsRepository;
    }

    @GetMapping
    public List<Params> getAllParams() {
        return paramsRepository.findAll();
    }

    @DeleteMapping("{id}")
    public void deleteParam(@PathVariable("id") Params newParams) {
        paramsRepository.delete(newParams);

    }
}
