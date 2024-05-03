package com.cydeo;

import com.cydeo.entity.Genre;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab08MovieTicketsApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab08MovieTicketsApplication.class, args);

        Genre genre1= new Genre();
        System.out.println(genre1.getMovie());
    }

}
