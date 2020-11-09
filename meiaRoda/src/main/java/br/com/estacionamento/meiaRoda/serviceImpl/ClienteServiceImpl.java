package br.com.estacionamento.meiaRoda.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estacionamento.meiaRoda.model.Cliente;
import br.com.estacionamento.meiaRoda.repository.ClienteRepository;
import br.com.estacionamento.meiaRoda.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository clienteRep;
	
	@Override
	public Cliente save(Cliente cliente) {
		return clienteRep.save(cliente);
	}

	@Override
	public List<Cliente> findAll() {
		List<Cliente> listAll = clienteRep.findAll();
		return listAll;
	}

	@Override
	public Cliente findById(long id) {
		Optional<Cliente> cliente = clienteRep.findById(id);
		return cliente.get();
	}

	@Override
	public List<Cliente> findByNome(String nome) {
		List<Cliente> listAll = clienteRep.findByNome(nome);
		return listAll;
	}

}
