package br.com.estacionamento.meiaRoda.serviceImpl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.estacionamento.meiaRoda.model.Veiculo;
import br.com.estacionamento.meiaRoda.repository.VeiculoRepository;
import br.com.estacionamento.meiaRoda.service.VeiculoService;
import br.com.estacionamento.meiaRoda.serviceImpl.exceptions.DatabaseException;
import br.com.estacionamento.meiaRoda.serviceImpl.exceptions.ResourceNotFoundException;

@Service
public class VeiculoServiceImpl implements VeiculoService {

	@Autowired
	private VeiculoRepository veiculoRep;

	@Override
	public Veiculo save(Veiculo veiculo) {
		return veiculoRep.save(veiculo);
	}

	@Override
	public List<Veiculo> findAll() {
		List<Veiculo> listAll = veiculoRep.findAll();
		return listAll;
	}

	@Override
	public Veiculo findById(long id) {
		return this.veiculoRep.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

	}

	@Override
	public Veiculo findByPlaca(String placa) {
		return veiculoRep.findByPlacaIgnoreCase(placa);
	}

	@Override
	public void delete(long id) {
		try {
			veiculoRep.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	@Override
	public Veiculo update(long id, Veiculo veiculo) {
		try {
			Veiculo veiculoUpdated = veiculoRep.getOne(id);
			updateData(veiculoUpdated, veiculo);
			return veiculoRep.save(veiculoUpdated);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Veiculo veiculoUpdated, Veiculo veiculo) {
		veiculoUpdated.setModelo(veiculo.getModelo());
		veiculoUpdated.setPlaca(veiculo.getPlaca());
	}

}
