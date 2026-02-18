package com.details.FlowerShop.service;
import com.details.FlowerShop.model.Buchet;
import com.details.FlowerShop.repository.BuchetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BuchetServiceImp implements BuchetService {
    @Autowired private BuchetRepository buchetRepository;

    @Override public List<Buchet> findAll() { return buchetRepository.findAll(); }
    @Override public Buchet findById(Long id) { return buchetRepository.findById(id).orElse(null); }
    @Override public Buchet save(Buchet buchet) { return buchetRepository.save(buchet); }
    @Override public void deleteById(Long id) { buchetRepository.deleteById(id); }
    @Override public List<Buchet> searchByDenumire(String denum) {
        return buchetRepository.findByDenumireBuchetContainingIgnoreCase(denum);
    }
}