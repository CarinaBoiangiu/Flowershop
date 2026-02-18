package com.details.FlowerShop.controller;

import com.details.FlowerShop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.ui.Model;

@ControllerAdvice
public class GlobalModelAttributes {

    @Autowired
    private CartService cartService;

    @ModelAttribute
    public void addGlobalAttributes(Model model) {
        try {
            int count = cartService.getItems() != null ? cartService.getItems().stream().mapToInt(i -> i.getQuantity()).sum() : 0;
            double total = cartService.getTotal();
            model.addAttribute("cartItemCount", count);
            model.addAttribute("cartTotal", total);
        } catch (Exception ex) {
            model.addAttribute("cartItemCount", 0);
            model.addAttribute("cartTotal", 0.0);
        }
    }
}
