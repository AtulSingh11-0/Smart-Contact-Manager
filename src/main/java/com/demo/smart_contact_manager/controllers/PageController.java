package com.demo.smart_contact_manager.controllers;

import com.demo.smart_contact_manager.request.UserForm;
import com.demo.smart_contact_manager.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class PageController {

  @Autowired
  private UserService userService;

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

  @GetMapping("/sign-up")
  public String signUp( Model model ) {

    UserForm form = new UserForm();
    model.addAttribute("pageTitle", "Sign Up - Smart Contact Manager");
    model.addAttribute("userForm", form);

    return "signUp";
  }

  @RequestMapping(value = "/do-signUp", method = RequestMethod.POST)
  public String doSignUp( @Valid @ModelAttribute("userForm") UserForm userForm, BindingResult result, HttpSession session ) {

    if ( result.hasErrors() ) {
      log.error("Validation Error: {}", result.toString());
      return "signUp";
    }

    log.info("User form: {}", userForm.toString());
    userService.saveUser(userForm);

    return "redirect:/sign-up";
  }

  @RequestMapping("/login")
  public String login( Model model ) {

    model.addAttribute("pageTitle", "Login - Smart Contact Manager");

    return "login";
  }
}
