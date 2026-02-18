package com.details.FlowerShop.service;

import com.details.FlowerShop.model.Buchet;

import java.util.List;

public interface BuchetService {
    List<Buchet>findAll();
    Buchet findById(Long id);
    Buchet save(Buchet buchet);
    void deleteById(Long id);
    List<Buchet>serachByDenumire(String denum);
}
