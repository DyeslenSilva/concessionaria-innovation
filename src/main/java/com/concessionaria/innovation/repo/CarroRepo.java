package com.concessionaria.innovation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.concessionaria.innovation.model.Carro;

public interface CarroRepo extends JpaRepository<Carro, Integer> {

}
