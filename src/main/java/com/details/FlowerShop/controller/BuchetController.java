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

    @Autowired
    private BuchetService buchetService;

    // Listă buchete + căutare opțională prin parametru de query "q"
    @GetMapping("/buchete")
    public String listBuchete(@RequestParam(value = "q", required = false) String query, Model model) {
        List<Buchet> buchete;
        if (query != null && !query.isBlank()) {
            buchete = buchetService.serachByDenumire(query);
            model.addAttribute("q", query);
        } else {
            buchete = buchetService.findAll();
        }
        model.addAttribute("buchete", buchete);
        return "buchete"; // așteaptă un template buchete.html
    }

    // Detalii buchet după id
    @GetMapping("/buchete/{id}")
    public String getBuchet(@PathVariable Long id, Model model) {
        Buchet buchet = buchetService.findById(id);
        if (buchet == null) {
            // Redirecționăm la listă dacă nu există
            return "redirect:/buchete";
        }
        model.addAttribute("buchet", buchet);
        return "buchet"; // așteaptă un template buchet.html
    }

    // Formular creare/edita buchet
    @GetMapping({"/buchete/new", "/buchete/{id}/edit"})
    public String showForm(@PathVariable(required = false) Long id, Model model) {
        Buchet buchet = (id == null) ? new Buchet() : buchetService.findById(id);
        if (buchet == null) {
            return "redirect:/buchete";
        }
        model.addAttribute("buchet", buchet);
        return "buchet-form"; // așteaptă un template buchet-form.html
    }

    // Salvare buchet (create/update)
    @PostMapping("/buchete")
    public String saveBuchet(@ModelAttribute Buchet buchet) {
        buchetService.save(buchet);
        return "redirect:/buchete";
    }

    // Ștergere buchet
    @PostMapping("/buchete/{id}/delete")
    public String deleteBuchet(@PathVariable Long id) {
        buchetService.deleteById(id);
        return "redirect:/buchete";
    }
}
