package com.concessionaria.innovation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.concessionaria.innovation.model.Cliente;

public interface ClienteRepo extends JpaRepository<Cliente, Integer> {

}
