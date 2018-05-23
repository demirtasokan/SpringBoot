package com.example.springbootthymeleaf;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

  @Autowired
  private UserValidator userValidator;

  @GetMapping("/registration")
  public String registrationForm(Model model){
    model.addAttribute("user", new User());
    return "registration";
  }

  @PostMapping("/registration")
  public String handleRegistration(@Valid User user, BindingResult bindingResult){

    userValidator.validate(user,bindingResult);
    System.out.println("Registering User : "+user);

    if(bindingResult.hasErrors()) {
      return "registration";
    }
    return "redirect:/login";
  }

}
