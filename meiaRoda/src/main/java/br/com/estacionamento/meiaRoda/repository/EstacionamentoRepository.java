package br.com.estacionamento.meiaRoda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estacionamento.meiaRoda.model.Estacionamento;

@Repository
public interface EstacionamentoRepository extends JpaRepository<Estacionamento, Long> {

}
