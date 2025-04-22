package com.harhsa.springBook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class SpringBookApplication {
  public static void main(String[] args) {
    ApplicationContext applicationContext =
        SpringApplication.run(SpringBookApplication.class, args);
    System.out.println("Started-" + applicationContext.getId());
  }
}
