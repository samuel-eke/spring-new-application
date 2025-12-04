package com.samuelaptech.newstore.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Builder
@ToString
@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

//    @Column(name = "gender", length = 10)
//    private String gender;
//
//    @Column(name = "phoneNumber", length = 15)
//    private String phoneNumber;
//
//    @Column(name = "nationality")
//    private String nationality;

// defining relationships between tables
    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    @Builder.Default
    private List<Addresses> addresses = new ArrayList<>();

    public void addAddress(Addresses address){
        addresses.add(address);  // the method used here is the method supported by the List interface
        address.setUser(this);
    }

    public void removeAddress(Addresses address){
        addresses.remove(address);
        address.setUser(null);
    }

    @OneToOne(mappedBy = "profileUser", cascade = CascadeType.REMOVE)
    private Profiles userProfiles;

    @ManyToMany
    @JoinTable(
            name = "wishlist",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "produt_id")
    )
    private Set<Product> wishList = new HashSet<>();

    public void addWishlist(Product product){
        wishList.add(product);
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
