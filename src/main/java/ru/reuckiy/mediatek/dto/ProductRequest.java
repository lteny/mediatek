package ru.reuckiy.mediatek.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ru.reuckiy.mediatek.model.Categories;
import ru.reuckiy.mediatek.model.Product;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductRequest {
    private List<Categories> categories;
    private List<Product> products;
}
