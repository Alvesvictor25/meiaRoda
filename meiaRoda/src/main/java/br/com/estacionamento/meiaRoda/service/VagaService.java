package br.com.estacionamento.meiaRoda.service;

import java.util.List;

import br.com.estacionamento.meiaRoda.model.Vaga;

public interface VagaService {

	Vaga save( Vaga vaga);
	List<Vaga> findAll();
	Vaga findById (long id);
//	boolean addVaga (Ticket ticket);
}
