package ru.reuckiy.mediatek.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private String brand;
    private String partNumber;
    private String description;
    private BigDecimal price;
    //    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
    @OneToMany(targetEntity = Params.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "p_fk", referencedColumnName = "id")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<Params> params;

    @OneToMany(targetEntity = Images.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "i_fk", referencedColumnName = "id")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<Images> images;

    //private String productImg;

    public Product() {
    }
//    public void addParams(Params param) {
//        params.add(param);
//        param.setProducts(this);
//    }
//
//    public void removeParams(Params param) {
//        params.remove(param);
//        param.setProducts(null);
//    }
}
