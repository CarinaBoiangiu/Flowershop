package com.details.FlowerShop.repository;

import com.details.FlowerShop.model.Comanda;
import com.details.FlowerShop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ComandaRepository extends JpaRepository<Comanda, Long> {
    Optional<Comanda> findComandaById(long id);

    List<Comanda> findByUser(User user);
}
