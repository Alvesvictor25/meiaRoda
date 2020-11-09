package br.com.estacionamento.meiaRoda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estacionamento.meiaRoda.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	Funcionario findByLogin(String login);
}
