package com.concessionaria.innovation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.concessionaria.innovation.model.Aluguel;

public interface AluguelRepo extends JpaRepository<Aluguel, Integer> {

}
