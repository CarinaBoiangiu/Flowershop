package com.details.FlowerShop.controller;


import com.details.FlowerShop.model.User;
import com.details.FlowerShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String showProfile(Principal principal, Model model) {
        // Folosim Principal pentru a lua username-ul celui logat
        String username = principal.getName();
        User user = userService.findByUserName(username)
                .orElseThrow(() -> new RuntimeException("Utilizator negăsit"));

        model.addAttribute("user", user);

        return "profile";
    }
}