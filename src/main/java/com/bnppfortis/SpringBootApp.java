package com.bnppfortis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * This the Start up class for Spring boot Application.
 * <p>
 * Created by Dev2018039 on 12/22/2018.
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.bnppfortis")
public class SpringBootApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);
    }
}
