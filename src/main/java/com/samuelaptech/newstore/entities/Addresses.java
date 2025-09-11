package com.samuelaptech.newstore.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "addresses")
@Getter
@Setter
public class Addresses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column( name ="street")
    private String street;

    @Column( name = "city")
    private String city;

    @Column( name = "zip")
    private String zip;
}
