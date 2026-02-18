package com.details.FlowerShop.repository;

import com.details.FlowerShop.model.Buchet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BuchetRepository extends JpaRepository<Buchet, Long> {
    List<Buchet> findByDenumireBuchetContainingIgnoreCase(String denum);
}