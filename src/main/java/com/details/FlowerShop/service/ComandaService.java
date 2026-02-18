package com.details.FlowerShop.service;

import com.details.FlowerShop.model.Comanda;
import com.details.FlowerShop.model.User;

import java.util.List;

public interface ComandaService {
    List<Comanda>findAll();
    Comanda findById(Long id);
    Comanda save(Comanda Comanda);
    void deleteById(Long id);
    List<Comanda>searchByUser(User user);
}
