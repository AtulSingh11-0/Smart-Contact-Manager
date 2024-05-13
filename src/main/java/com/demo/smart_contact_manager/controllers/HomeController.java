package com.demo.smart_contact_manager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

  @RequestMapping("/")
  public String home( Model model ) {

    model.addAttribute("title", "Home - Smart Contact Manager");
    model.addAttribute("content", "Welcome to Smart Contact Manager");
    model.addAttribute("message", "This is a simple web application to manage your contacts");
    model.addAttribute("githubRepoLink", "https://github.com/AtulSingh11-0");

    return "home";
  }
}
