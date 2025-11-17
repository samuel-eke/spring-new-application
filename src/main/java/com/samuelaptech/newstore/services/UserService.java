package com.samuelaptech.newstore.services;

import com.samuelaptech.newstore.entities.Category;
import com.samuelaptech.newstore.entities.Product;
import com.samuelaptech.newstore.entities.User;
import com.samuelaptech.newstore.repository.AddressesRepository;
import com.samuelaptech.newstore.repository.ProductRepository;
import com.samuelaptech.newstore.repository.ProfilesRepository;
import com.samuelaptech.newstore.repository.UserRepository;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final EntityManager entityManager;
    private final ProfilesRepository profilesRepository;
    private final AddressesRepository addressesRepository;
    private final ProductRepository productRepository;

    @Transactional
    public void showRelatedEntities(){
        var user = profilesRepository.findById(2L).orElseThrow();
        System.out.println(user.getBio());
    }

    public void fetchAddress(){
        var address = addressesRepository.findById(1L).orElseThrow();
    }

    public void persistRelated(){
        var newUser = User.builder()
                .name("kimi")
                .password("1234")
                .email("dummy@mail")
                .password("1234")
                .build();
        newUser = userRepository.save(newUser);
    }

    public void manageProdcuts(){
        var category = new Category("Category 1");
        var product = Product.builder()
                .name("Product 1")
                .description("Description for product 1")
                .price(BigDecimal.valueOf(29.55))
                .category(category)
                .build();

        productRepository.save(product);
    }
}
