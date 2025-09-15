package com.samuelaptech.newstore;

import com.samuelaptech.newstore.entities.Addresses;
import com.samuelaptech.newstore.entities.Profiles;
import com.samuelaptech.newstore.entities.Tags;
import com.samuelaptech.newstore.entities.User;
import com.samuelaptech.newstore.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class NewstoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(NewstoreApplication.class, args);
        var repo = context.getBean(UserRepository.class);


        //this code is adding to memory not to the DB
        var user = User.builder()
                .name("Jake")
                .password("990942")
                .email("theeail@me.com")
                .build();
        repo.save(user);

//        var addr = Addresses.builder()
//                .street("ushafa")
//                .zip("990A")
//                .city("Abuja")
//                .build();

//        user.addAddress(addr);

//        user.addTag("plates");
//
//        var profiles = Profiles.builder()
//                        .bio("crypto trader")
//                                .build();
//        user.setUserProfiles(profiles);
//        profiles.setProfileUser(user);
//        System.out.println(user);

    }

}
