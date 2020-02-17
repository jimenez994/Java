package com.zeus.demo.controlers;

import com.zeus.demo.model.Login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class GetPost {

  @RequestMapping("")
  public String login() {
    return "index";
  }

  @PostMapping(value = "/login")
  public String postMethodName(@ModelAttribute("user") final Login user) {
    System.out.println(user.getUsername() + "  " + user.getPassword());
    if (user.isValid()) {
      return "home";
    } else {
      return "redirect:/createError";
    }
  }

  @RequestMapping("/createError")
  public String flashMessages(RedirectAttributes redirectAttributes) {
    redirectAttributes.addFlashAttribute("error", "A test errror!");
    return "redirect:/";
  }

}