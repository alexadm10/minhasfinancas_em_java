package com.alex.minhasfinancas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alex.minhasfinancas.model.entity.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

}
