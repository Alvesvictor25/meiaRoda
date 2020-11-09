package br.com.estacionamento.meiaRoda.service;

import java.util.List;

import br.com.estacionamento.meiaRoda.model.Cliente;

public interface ClienteService {
	
	Cliente save(Cliente cliente);
	List<Cliente> findAll();
	Cliente findById(long id);
	List<Cliente> findByNome(String nome);
}
