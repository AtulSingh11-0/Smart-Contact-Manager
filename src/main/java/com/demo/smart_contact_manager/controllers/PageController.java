package com.demo.smart_contact_manager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

  @RequestMapping("/")
  public String home( Model model ) {

    model.addAttribute("pageTitle", "Home - Smart Contact Manager");
    model.addAttribute("heading", "Welcome to Smart Contact Manager");
    model.addAttribute("message", "This is a simple web application to manage your contacts");
    model.addAttribute("githubRepoLink", "https://github.com/AtulSingh11-0");

    return "home";
  }

  @RequestMapping("/about")
  public String about( Model model ) {

    model.addAttribute("pageTitle", "About - Smart Contact Manager");
    model.addAttribute("heading", "About Us");
    model.addAttribute("message", "Smart Contact Manager");
    model.addAttribute("githubRepoLink", "https://github.com/AtulSingh11-0");

    return "about";
  }
}
