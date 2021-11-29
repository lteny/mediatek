package ru.reuckiy.mediatek.controller.product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.reuckiy.mediatek.model.Categories;
import ru.reuckiy.mediatek.repository.CategoriesRepository;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final CategoriesRepository categoriesRepository;

    public ProductController(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @GetMapping
    public String productPage(Model model) {
        List<Categories> productList = categoriesRepository.findAll();

        model.addAttribute("title", "Product");
        model.addAttribute("productList", productList);
        return "admin/product/product";
    }
}
