package com.example.replyglue;

import com.example.replyglue.model.User;
import com.example.replyglue.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class ReplyGlueApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReplyGlueApplication.class, args);
    }

    @Bean
    public CommandLineRunner mappingDemo(UserRepository userRepository){

        return args -> {
            userRepository.save(new User("Arduino", "@rDuin099", "arduino@gmail.com", LocalDate.of(1999,02,22), "4659429109705526"));
            userRepository.save(new User("Tom", "ps83nN*3£", "tom@gmail.com", LocalDate.of(1937,05,11), "3128429384705526"));
            userRepository.save(new User("Sarah", "s@r3nN*3£", "sarah@gmail.com", LocalDate.of(1997,03,17), "9475394884703749"));
            userRepository.save(new User("Mark", "pd9338hss&&", "mark@gmail.com", LocalDate.of(1996,02,1), "3746429384274626"));
        };
    }

    //// {
    ////     "username": "arduino",
    ////     "password": "@Rduin001",
    ////     "email": "arduino@gmail.com",
    ////     "dob" : "1999-02-22",
    ////     "cardNumber" : "4659438101905526"
    //// }
}
