package com.details.FlowerShop.service;

import com.details.FlowerShop.model.Buchet;
import com.details.FlowerShop.model.CartItem;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@SessionScope
public class CartService {
    private List<CartItem> items = new ArrayList<>();

    public void addToCart(Buchet buchet, int quantity) {
        Optional<CartItem> existing = items.stream()
                .filter(item -> item.getBuchet().getId() == buchet.getId()).findFirst();
        if (existing.isPresent()) {
            CartItem item = existing.get();
            item.setQuantity(item.getQuantity() + quantity);
        } else {
            items.add(new CartItem(buchet, quantity));
        }
    }
    public void removeItem(Long buchetId) { items.removeIf(i -> i.getBuchet().getId() == buchetId); }
    public List<CartItem> getItems() { return items; }
    public double getTotal() { return items.stream().mapToDouble(CartItem::getTotalPrice).sum(); }
    public void clearCart() { items.clear(); }
}