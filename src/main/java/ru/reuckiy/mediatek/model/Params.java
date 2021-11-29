package ru.reuckiy.mediatek.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "params")
public class Params {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "FK_PRODUCT_PARAMS"))
//    @JsonIgnore
//    private Product products;
    private String paramName;
    private String paramValue;

    public Params() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Params)) return false;
        return id != null && id.equals(((Params) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
