package com.samuelaptech.newstore.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

//in entities. this is code representation of the sql database
// model-first approach implies that the sql database is built from java to sql

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity

@Table(name = "products")
public class Product {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id")
    private Category category;

}