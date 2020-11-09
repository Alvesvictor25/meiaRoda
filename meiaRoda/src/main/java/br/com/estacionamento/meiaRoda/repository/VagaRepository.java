package br.com.estacionamento.meiaRoda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estacionamento.meiaRoda.model.Vaga;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long>{
}
