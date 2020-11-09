package br.com.estacionamento.meiaRoda.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estacionamento.meiaRoda.model.Funcionario;
import br.com.estacionamento.meiaRoda.repository.FuncionarioRepository;
import br.com.estacionamento.meiaRoda.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRep;

	@Override
	public Funcionario salvar(Funcionario funcionario) {
		return funcionarioRep.save(funcionario);
	}

	@Override
	public List<Funcionario> listarTodos() {
		List<Funcionario> listarTodos = funcionarioRep.findAll();
		return listarTodos;
	}

	@Override
	public Funcionario procurarPorId(long id) {
		Optional<Funcionario> funcionario = funcionarioRep.findById(id);
		return funcionario.get();
	}

}
