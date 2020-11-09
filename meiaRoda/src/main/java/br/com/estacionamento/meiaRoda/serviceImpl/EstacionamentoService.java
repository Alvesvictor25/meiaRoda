package br.com.estacionamento.meiaRoda.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estacionamento.meiaRoda.model.Estacionamento;
import br.com.estacionamento.meiaRoda.repository.EstacionamentoRepository;

@Service
public class EstacionamentoService {

	@Autowired
	private EstacionamentoRepository repository;
	
	public Estacionamento save(Estacionamento estacionamento) {
		return repository.save(estacionamento);
	}
}
