package br.com.estacionamento.meiaRoda.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.estacionamento.meiaRoda.model.Cliente;
import br.com.estacionamento.meiaRoda.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping
	public ResponseEntity<Cliente> save( @RequestBody Cliente cliente) {
		clienteService.save(cliente);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}

	@RequestMapping(path = "/list")
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> clientes = clienteService.findAll();
		return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}")
	public ResponseEntity<Cliente> findById(@RequestParam("id") long id) {
		Cliente cliente = clienteService.findById(id);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}

	@RequestMapping(path = "/nome/{nome}")
	public ResponseEntity<List<Cliente>> findById(@PathVariable("nome") String nome) {
		List<Cliente> clientes = clienteService.findByNome(nome);
		return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
	}

}
