package ru.reuckiy.mediatek.rest.product;

import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.reuckiy.mediatek.model.Product;
import ru.reuckiy.mediatek.repository.ProductRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductRestController {

    private final ProductRepository productRepository;

    public ProductRestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @GetMapping("{id}")
    public Product getOneProduct(@PathVariable("id") Product product) {
        return product;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product newProduct) {
        return productRepository.save(newProduct);
    }

    @PutMapping("{id}")
    public Product updateProduct(@PathVariable("id") Product productFromDb,
                                 @RequestBody Product newProduct) {
        BeanUtils.copyProperties(newProduct, productFromDb, "id");
        return productRepository.save(productFromDb);
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable("id") Product newProduct) {
        productRepository.delete(newProduct);

    }
}
