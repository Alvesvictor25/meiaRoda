package br.com.estacionamento.meiaRoda.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estacionamento.meiaRoda.model.Vaga;
import br.com.estacionamento.meiaRoda.repository.VagaRepository;
import br.com.estacionamento.meiaRoda.service.VagaService;

@Service
public class VagaServiceImpl implements VagaService {

	@Autowired
	private VagaRepository vagaRepository;

	@Override
	public Vaga save(Vaga vaga) {
		return vagaRepository.save(vaga);
	}

	@Override
	public List<Vaga> findAll() {
		List<Vaga> listAll = vagaRepository.findAll();
		return listAll;
	}

	@Override
	public Vaga findById(long id) {
		Optional<Vaga> vaga = vagaRepository.findById(id);
		return vaga.get();
	}

//	@Override
//	public boolean addVaga(Ticket ticket) {
//		// TODO Auto-generated method stub
//		return false;
//	}


}
