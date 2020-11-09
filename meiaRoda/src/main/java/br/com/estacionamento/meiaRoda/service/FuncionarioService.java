package br.com.estacionamento.meiaRoda.service;

import java.util.List;

import br.com.estacionamento.meiaRoda.model.Funcionario;

public interface FuncionarioService {
	
	Funcionario salvar(Funcionario funcionario);
	List<Funcionario> listarTodos();
	Funcionario procurarPorId(long id);
	
}
