package ru.reuckiy.mediatek.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "image")
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String urlImage;

    public Images() {
    }
}
