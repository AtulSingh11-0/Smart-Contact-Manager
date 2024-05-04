package com.demo.smart_contact_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmartContactManagerApplication {

  public static void main ( String[] args ) {
    SpringApplication.run(SmartContactManagerApplication.class, args);
    System.out.println("Smart Contact Manager Application Started... on http://localhost:1234/");
  }

}
