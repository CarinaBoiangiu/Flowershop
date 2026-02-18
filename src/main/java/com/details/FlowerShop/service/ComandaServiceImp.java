package com.details.FlowerShop.service;

import com.details.FlowerShop.model.Comanda;
import com.details.FlowerShop.model.User;
import com.details.FlowerShop.repository.ComandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComandaServiceImp implements ComandaService {

    @Autowired
    private ComandaRepository comandaRepository;

    @Override
    public List<Comanda> findAll() {
        return comandaRepository.findAll();
    }

    @Override
    public Comanda findById(Long id) {
        // Returnează comanda sau null dacă nu există
        return comandaRepository.findById(id).orElse(null);
    }

    @Override
    public Comanda save(Comanda comanda) {
        return comandaRepository.save(comanda);
    }

    @Override
    public void deleteById(Long id) {
        comandaRepository.deleteById(id);
    }

    @Override
    public List<Comanda> searchByUser(User user) {
        return comandaRepository.findByUser(user);
    }
}