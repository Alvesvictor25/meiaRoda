package br.com.estacionamento.meiaRoda.service;

import java.util.List;

import br.com.estacionamento.meiaRoda.model.Veiculo;

public interface VeiculoService {

	Veiculo save(Veiculo veiculo);
	List<Veiculo> findAll();
	Veiculo findById(long id);
	Veiculo findByPlaca(String placa);
	Veiculo update(long id, Veiculo veiculo);
	void delete(long id);
}
