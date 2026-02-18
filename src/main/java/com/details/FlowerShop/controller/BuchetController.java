package com.details.FlowerShop.controller;

import com.details.FlowerShop.model.Buchet;
import com.details.FlowerShop.service.BuchetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class BuchetController {
    @Autowired private BuchetService buchetService;

    @GetMapping("/buchete")
    public String listBuchete(@RequestParam(value = "q", required = false) String query, Model model) {
        List<Buchet> buchete = (query != null && !query.isBlank())
                ? buchetService.searchByDenumire(query)
                : buchetService.findAll();
        model.addAttribute("listaBuchete", buchete);
        return "buchete";
    }

    @GetMapping("/buchete/detalii/{id}")
    public String getBuchetDetalii(@PathVariable Long id, Model model) {
        Buchet buchet = buchetService.findById(id);
        if (buchet == null) return "redirect:/buchete";
        model.addAttribute("buchet", buchet);
        return "buchet-details";
    }

    @GetMapping({"/buchete/new", "/buchete/{id}/edit"})
    public String showForm(@PathVariable(required = false) Long id, Model model) {
        Buchet buchet = (id == null) ? new Buchet() : buchetService.findById(id);
        model.addAttribute("buchet", buchet != null ? buchet : new Buchet());
        return "buchet-form";
    }

    @PostMapping("/buchete")
    public String saveBuchet(@ModelAttribute Buchet buchet) {
        buchetService.save(buchet);
        return "redirect:/buchete";
    }

    @PostMapping("/buchete/{id}/delete")
    public String deleteBuchet(@PathVariable Long id) {
        buchetService.deleteById(id);
        return "redirect:/buchete";
    }
}