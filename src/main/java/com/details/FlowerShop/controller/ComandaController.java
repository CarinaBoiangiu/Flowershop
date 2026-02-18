package com.details.FlowerShop.controller;

import com.details.FlowerShop.model.Comanda;
import com.details.FlowerShop.model.User;
import com.details.FlowerShop.service.ComandaService;
import com.details.FlowerShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class ComandaController {

    @Autowired
    private UserService userService;

    @Autowired
    private ComandaService comandaService;

    // Afișează formularul de plasare a comenzii
    @GetMapping("/cumpara")
    public String showCheckoutPage(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }
        model.addAttribute("order", new Comanda());
        return "cumpara"; // așteaptă un template cumpara.html
    }

    // Plasează comanda pentru utilizatorul autentificat
    @PostMapping("/plaseaza")
    public String placeOrder(@ModelAttribute("order") Comanda order,
                             Principal principal,
                             RedirectAttributes redirectAttributes) {
        if (principal == null) {
            return "redirect:/login";
        }
        String username = principal.getName();
        Optional<User> optionalUser = userService.findByUserName(username);
        if (optionalUser.isEmpty()) {
            return "redirect:/login";
        }
        User currentUser = optionalUser.get();
        order.setUser(currentUser);
        try {
            comandaService.save(order);
            redirectAttributes.addFlashAttribute("success", "Comanda a fost plasată cu succes!");
            return "redirect:/comenzile-mele";
        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("error", "A apărut o eroare la plasarea comenzii.");
            return "redirect:/cumpara";
        }
    }

    // Lista comenzilor pentru utilizatorul curent
    @GetMapping("/comenzile-mele")
    public String myOrders(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }
        Optional<User> optionalUser = userService.findByUserName(principal.getName());
        if (optionalUser.isEmpty()) {
            return "redirect:/login";
        }
        List<Comanda> orders = comandaService.searchByUser(optionalUser.get());
        model.addAttribute("orders", orders);
        return "comenzile-mele"; // așteaptă un template comenzile-mele.html
    }

    // (Opțional) Listă toate comenzile - util pentru admin
    @GetMapping("/comenzi")
    public String listAllOrders(Model model) {
        List<Comanda> orders = comandaService.findAll();
        model.addAttribute("orders", orders);
        return "comenzi"; // așteaptă un template comenzi.html
    }

    // Șterge/Anulează o comandă după ID
    @PostMapping("/comenzi/{id}/delete")
    public String deleteOrder(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        comandaService.deleteById(id);
        redirectAttributes.addFlashAttribute("success", "Comanda a fost ștearsă.");
        return "redirect:/comenzi";
    }
}
