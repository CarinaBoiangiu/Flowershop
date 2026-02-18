package com.details.FlowerShop.controller;

import com.details.FlowerShop.model.Buchet;
import com.details.FlowerShop.service.BuchetService;
import com.details.FlowerShop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired private CartService cartService;
    @Autowired private BuchetService buchetService;

    @GetMapping
    public String viewCart(Model model) {
        model.addAttribute("cartItems", cartService.getItems());
        model.addAttribute("totalCartPrice", cartService.getTotal());
        return "cart";
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam Long buchetId, @RequestParam int quantity) {
        Buchet buchet = buchetService.findById(buchetId);
        if (buchet != null) cartService.addToCart(buchet, quantity);
        return "redirect:/buchete"; // Te întorci la listă
    }

    @GetMapping("/remove/{id}")
    public String removeFromCart(@PathVariable Long id) {
        cartService.removeItem(id);
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String checkoutPage(Model model) {
        model.addAttribute("totalPrice", cartService.getTotal());
        return "checkout";
    }

    @PostMapping("/checkout/process")
    public String processOrder() {
        cartService.clearCart();
        return "redirect:/buchete?orderSuccess";
    }
}