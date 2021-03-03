package com.concessionaria.innovation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.concessionaria.innovation.model.Vendas;

public interface VendasRepo extends JpaRepository<Vendas, Integer> {

}
