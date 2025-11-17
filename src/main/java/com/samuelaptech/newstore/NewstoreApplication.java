package com.samuelaptech.newstore;

import com.samuelaptech.newstore.entities.Addresses;
import com.samuelaptech.newstore.entities.Profiles;
import com.samuelaptech.newstore.entities.Tags;
import com.samuelaptech.newstore.entities.User;
import com.samuelaptech.newstore.repository.UserRepository;
import com.samuelaptech.newstore.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class NewstoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(NewstoreApplication.class, args);
        var service = context.getBean(UserService.class);
//        service.fetchAddress();
//        service.persistRelated();
        service.manageProdcuts();
    }

}
