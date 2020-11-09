package br.com.estacionamento.meiaRoda.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.estacionamento.meiaRoda.model.Funcionario;
import br.com.estacionamento.meiaRoda.service.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	@Autowired
	FuncionarioService funcService;

	@PostMapping
	public ResponseEntity<Object> save(@RequestBody Funcionario funcionario) {
		funcionario = funcService.salvar(funcionario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(funcionario.getId())
				.toUri();
		return ResponseEntity.created(uri).body(funcionario);
	}

	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<Funcionario>> getList() {
		List<Funcionario> findAll = funcService.listarTodos();
		return new ResponseEntity<List<Funcionario>>(findAll, HttpStatus.ACCEPTED);
	}

	@RequestMapping(params = "/{id}")
	public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable("id") long id) {
		Funcionario funcionario = funcService.procurarPorId(id);
		if (funcionario == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Funcionario>(funcionario, HttpStatus.OK);
	}

}
