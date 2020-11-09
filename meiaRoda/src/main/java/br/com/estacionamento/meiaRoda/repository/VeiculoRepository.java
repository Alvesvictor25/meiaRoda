package br.com.estacionamento.meiaRoda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estacionamento.meiaRoda.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{
	Veiculo findByPlacaIgnoreCase(String placa);
}
