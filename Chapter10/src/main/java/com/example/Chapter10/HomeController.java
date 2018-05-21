package com.example.Chapter10;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

  @RequestMapping("/about")
  public String home(Model model) {
     return "aboutus.html";
  }
}
