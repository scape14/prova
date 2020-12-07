package com.example.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projeto.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{

}
