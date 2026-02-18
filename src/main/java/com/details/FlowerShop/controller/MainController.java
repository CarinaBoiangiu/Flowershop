package com.details.FlowerShop.controller;

import com.details.FlowerShop.model.Buchet;
import com.details.FlowerShop.service.BuchetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private BuchetService buchetService;

    @GetMapping("/")
    public String showHomePage(Model model) {
        // 1. Obținem lista din service
        List<Buchet> buchete = buchetService.findAll();

        // 2. PROTECȚIE: Dacă service-ul returnează null, folosim o listă goală
        // Aceasta este linia care previne eroarea de la linia 25!
        if (buchete == null) {
            buchete = new ArrayList<>();
        }

        // 3. Trimitem lista (care acum sigur NU e null) către HTML
        model.addAttribute("listaBuchete", buchete);

        return "index";
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }
}